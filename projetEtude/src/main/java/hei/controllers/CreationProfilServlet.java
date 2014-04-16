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

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.Transport;
 
import javax.mail.internet.AddressException;
import javax.mail.NoSuchProviderException;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Date date = new Date(); 
		
		System.out.println(date);
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
		envoyerMail(mail,motpass);
		Calendrier nouveauCal = new Calendrier(null, nouvelEtudiant.getIdetudiant(),date);
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
	private void envoyerMail(String mail, String password){
		try {
		    Properties		props	    = new Properties();
		    props.setProperty("mail.from", "stanislas.descamps@hei.fr");
		    Session		session	    = Session.getInstance(props);
	 
		    Message		message	    = new MimeMessage(session);
		    InternetAddress	recipient   = new InternetAddress(mail);
		    message.setRecipient(Message.RecipientType.TO, recipient);
		    message.setSubject("Votre mot de passe HEI-Diary");
	 
		    // Partie 1: Le texte
		    MimeBodyPart mbp1 = new MimeBodyPart();
		    mbp1.setText("Bonjour, merci de vous être inscrit sur HEI-Diary. votre mot de passe sera : "+ password +"\n Nous vous souhaitons une bonne journée. \n Cordialement. \n L'équipe HEI-Diary");
	 
		    
		    // On regroupe les deux dans le message
		    MimeMultipart mp = new MimeMultipart();
		    mp.addBodyPart(mbp1);
		    message.setContent(mp);
	 
		    Transport.send(message);
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
