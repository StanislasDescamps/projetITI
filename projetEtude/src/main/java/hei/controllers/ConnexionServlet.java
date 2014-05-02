package hei.controllers;

import hei.metier.Manager;
import hei.model.Etudiant;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.smtp.SMTPTransport;

public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = -4501231509110259062L;

	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        if(request.getParameter("logout") != null){
        	 HttpSession session = request.getSession(true); 
        	 session.invalidate();
        }
    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
    	view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//
		String mail = request.getParameter("mail");
		String password = request.getParameter("pass");
		
		Etudiant etudiant = Manager.getInstance().getEtudiantMail(mail);
		
		if (Manager.getInstance().etudiantExiste(mail,password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("idEtudiant", etudiant.getIdetudiant());
			session.setAttribute("nom", etudiant.getNomEtudiant());
			session.setAttribute("prenom", etudiant.getPrenomEtudiant());
			session.setAttribute("email", etudiant.getEmail());
			session.setAttribute("admin", etudiant.isAdmin());
			session.setAttribute("etudiantConnecte", new Etudiant(mail,password));
			redirectCal(response);
		}
		else
		{
			request.setAttribute("loginError", "Votre login n'est pas bon. Veuillez rentrer un utilisateur et un mot de passe valide.");
		}
		
		String mail2 = request.getParameter("mailmdp");
		Etudiant etudiant2 = Manager.getInstance().getEtudiantMail(mail2);
		
		if(etudiant2 != null){
			try {
				envoyerMail(etudiant2.getNomEtudiant(), etudiant2.getPrenomEtudiant(), mail2, etudiant2.getPassWord());
				ServletContext context = getServletContext();
			    RequestDispatcher dispatcher = context.getRequestDispatcher("/connexion");
			    dispatcher.forward(request, response);
			    
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {request.setAttribute("mailError", "Votre login n'est pas bon. Veuillez rentrer une adresse mail valide et existante.\n"
				+ " Si l'erreur persiste, créez un nouveau profil");}
		
	}

	private void redirectCal(HttpServletResponse resp) throws IOException {
	    resp.sendRedirect(getServletContext().getContextPath()+"/monCalendrier1");
	}
		
	/*private void redirectConnexion(HttpServletResponse resp) throws IOException {
	    resp.sendRedirect(getServletContext().getContextPath()+"/connexion");
	}*/
	
private void envoyerMail(String nom, String prenom, String mail, String password) throws Exception {
		
		try {
			
		    Properties props = System.getProperties();
		    props.put("mail.smtps.host", "smtp.gmail.com");
		    props.put("mail.smtps.auth", "true"); 
		    props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.port", "587");
	       
		    Session		session	    = Session.getInstance(props,null);
	 
		    Message		message	    = new MimeMessage(session);
		    message.setFrom(new InternetAddress("heidiarybystanetnico@gmail.com"));
		    //InternetAddress	recipient   = new InternetAddress(mail);
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail,false));
		    message.setSubject("Votre mot de passe HEI-Diary");
	 
		    
		    message.setText("Bonjour"+ prenom +" " + nom +", Nous vous rappelons votre mot de passe : "+ password +"\n Nous vous souhaitons une bonne journée. \n Cordialement. \n L'équipe HEI-Diary");
	 
	
		    message.setSentDate(new Date());
		    
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
