package hei.controllers;

import hei.metier.Manager;
import hei.model.Calendrier;
import hei.model.Etudiant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;


//import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Message;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

//import javax.mail.Transport;
 
import javax.mail.internet.AddressException;
import javax.mail.NoSuchProviderException;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.smtp.SMTPTransport;

public class CreationProfilServlet extends HttpServlet {


	private static final long serialVersionUID = 6428922108074858393L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/creationProfil.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//Ajout du participant et de sa participation	
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String motpass= genereMdp();
		
		List<Etudiant> listEtudiant = new ArrayList<Etudiant>();
		listEtudiant = Manager.getInstance().listerEtudiant();
		
		Integer i=0;
		Integer n = listEtudiant.size();
		Boolean exist=false;
	
		String format = "dd MMMM yyyy"; 

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		
		while(i<n && !exist)
		{
			if(mail.equalsIgnoreCase(listEtudiant.get(i).getEmail()))
				{
				exist=true;
				}
			else i++;
		}
		
		if(!exist)
		{
		Etudiant nouvelEtudiant = new Etudiant(null, nom, prenom, motpass, mail, false);
		Manager.getInstance().ajouterEtudiant(nouvelEtudiant);
		try {
			envoyerMail(nom, prenom, mail, motpass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendrier nouveauCal = new Calendrier(null, Manager.getInstance().getEtudiantMail(mail).getIdetudiant(),formater.format(date));
		Manager.getInstance().ajouterCalendrier(nouveauCal);
		response.sendRedirect("connexion");
		} 
		else
		{
		request.setAttribute("loginError", "Votre login n'est pas bon. Veuillez rentrer un utilisateur et un mot de passe valide.");
		}
	}
	
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
	private void envoyerMail(String nom, String prenom, String mail, String password) throws Exception {
		
		try {
			
		    Properties props = System.getProperties();
		    props.put("mail.smtps.host", "smtp.gmail.com");
		    props.put("mail.smtps.auth", "true"); 
		    //props.setProperty("mail.transport.protocol", "smtp");
		        
		    Session		session	    = Session.getInstance(props,null);
	 
		    Message		message	    = new MimeMessage(session);
		    message.setFrom(new InternetAddress("stanislas.descamps@gmail.fr"));
		    //InternetAddress	recipient   = new InternetAddress(mail);
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail,false));
		    message.setSubject("Votre mot de passe HEI-Diary");
	 
		    
		    message.setText("Bonjour"+ prenom +" " + nom +", merci de vous être inscrit sur HEI-Diary. votre mot de passe sera : "+ password +"\n Nous vous souhaitons une bonne journée. \n Cordialement. \n L'équipe HEI-Diary");
	 
	
		    message.setSentDate(new Date());
		    
		    SMTPTransport transport = (SMTPTransport)session.getTransport("smtp");
		    transport.connect("smtp.gmail.com","stanislas.descamps@gmail.fr","sa4gcz4g");
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
