package hei.controllers;

import hei.metier.Manager;
import hei.model.Calendrier;
import hei.model.Etudiant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
 
import javax.mail.internet.AddressException;
import javax.mail.NoSuchProviderException;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.smtp.*;

public class CreationProfilServlet extends HttpServlet {


	private static final long serialVersionUID = 6428922108074858393L;
	public static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/creationProfil.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//Récupération des informations	
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String motpass= genereMdp();  //génération d'un mot de passe
		
		//Récupération de tous les étudiant dans une liste
		List<Etudiant> listEtudiant = new ArrayList<Etudiant>();
		listEtudiant = Manager.getInstance().listerEtudiant();
		
		Integer i=0;
		Integer n = listEtudiant.size();
		Boolean existe=false;

		//Récupération de la date du système
		java.util.Date date = new java.util.Date(); 
				
		//Vérification de l'inexistance de l'étudiant
		while(i<n && !existe)
		{
			if(mail.equalsIgnoreCase(listEtudiant.get(i).getEmail()))
				{
				existe=true;
				}
			else i++;
		}
		
		//Si etudiant inexistant, création du profil sinon message d'erreur
		if(!existe)
		{
		Etudiant nouvelEtudiant = new Etudiant(null, nom, prenom, motpass, mail, false);
		Manager.getInstance().ajouterEtudiant(nouvelEtudiant);
		try {
			envoyerMail(nom, prenom, mail, motpass);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//Création du calendrier de l'étudiant
		Calendrier nouveauCal = null;
		nouveauCal = new Calendrier(null, Manager.getInstance().getEtudiantMail(mail).getIdetudiant(),formatDate.format(date));
	
		Manager.getInstance().ajouterCalendrier(nouveauCal);
		response.sendRedirect("connexion");
		} 
		else
		{
		request.setAttribute("loginError", "Votre login existe deja. Veuillez rentrer un autre login ou faites mot de passe oublié.");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/creationProfil.jsp");
    	view.forward(request, response);
		}
	}
	
	//Fonction générant un mot de passe aléatoire
	private String genereMdp(){
		String password = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random rand = new Random();
        for (int i=0; i<8; i++)
        {
        	password=password+(alphabet.charAt(rand.nextInt(alphabet.length())));
        } 		
		return password;
	}
	//Fonction permettant l'envoi d'un mail avec le mot de passe généré
	private void envoyerMail(String nom, String prenom, String mail, String password) throws Exception {
		
		try {
			//Configuration de l'hote d'envoi du mail
		    Properties props = System.getProperties();
		    props.put("mail.smtps.host", "smtp.gmail.com");
		    props.put("mail.smtps.auth", "true"); 
		    props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.port", "587");
	       
		    Session		session	    = Session.getInstance(props,null);
	 
		    //Rédaction du mail
		    Message		message	    = new MimeMessage(session);
		    message.setFrom(new InternetAddress("heidiarybystanetnico@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail,false));
		    message.setSubject("Votre mot de passe HEI-Diary");
	 
		    
		    message.setText("Bonjour "+ prenom +" " + nom +", merci de vous être inscrit sur HEI-Diary. votre mot de passe sera : "+ password +"\n Nous vous souhaitons une bonne journée. \n Cordialement. \n L'équipe HEI-Diary");
	
		    message.setSentDate(new Date());
		    
		    //Configuration de l'envoi du mail
		    SMTPTransport transport = (SMTPTransport)session.getTransport("smtp");
		    transport.connect("smtp.gmail.com","heidiarybystanetnico@gmail.com","heidiary2014");
		    transport.sendMessage(message,message.getAllRecipients());
		System.out.println("Reponse" + transport.getLastServerResponse()); 
		transport.close();
		}
		catch(NoSuchProviderException e) {
		    System.err.println("Pas de transport disponible pour ce protocole");
		    System.err.println(e);
		}
		catch(AddressException e) {
		    System.err.println("Adresse invalide");
		    System.err.println(e);
		}
		catch(MessagingException e) {
		    System.err.println("Erreur dans le message");
		    System.err.println(e);
		}
		
	}
}
