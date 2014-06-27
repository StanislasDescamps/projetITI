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
		//Si l'utilisateur n'est pas connecté, fermer la session
        if(request.getParameter("logout") != null){
        	 HttpSession session = request.getSession(true); 
        	 session.invalidate();
        }
        //Permet l'ouverture de la page
    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
    	view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//Récupération des informations pour la connexion
		String mail = request.getParameter("mail");
		String password = request.getParameter("pass");
		//Récupération de la valeur du bouton actionné
		String connexion = request.getParameter("connexion");
		String passoublie = request.getParameter("passoublie");
		
		Etudiant etudiant = Manager.getInstance().getEtudiantMail(mail);
		
		//Si password et login bon alors récupérer informations personnelles sinon message d'erreur
		if(connexion != null){
		if (Manager.getInstance().etudiantExiste(mail,password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("idEtudiant", etudiant.getIdetudiant());
			session.setAttribute("nom", etudiant.getNomEtudiant());
			session.setAttribute("prenom", etudiant.getPrenomEtudiant());
			session.setAttribute("email", etudiant.getEmail());
			session.setAttribute("idDroit", etudiant.getIdDroit());
			session.setAttribute("firstConnexion", etudiant.isFirstConnexion());
			session.setAttribute("etudiantConnecte", new Etudiant(mail,password));
			
			//Récupération de firstConnexion
			Boolean firstConnexion = (Boolean) session.getAttribute("firstConnexion");
			Integer idetudiant= (Integer) session.getAttribute("idEtudiant");
			//Si premiere connexion rediriger vers mes Preferences sinon vers mon calendrier
			if(firstConnexion) {
				redirectPref(response);
				Manager.getInstance().firstConnexionSetFalse(idetudiant);
			}
			else redirectCal(response);
		}
		else
		{
			request.setAttribute("loginError", "Votre login n'est pas bon. Veuillez rentrer un utilisateur et un mot de passe valide.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
	    	view.forward(request, response);
		}
		}
		//Récupération des informations si mot de passe oublié
		String mail2 = request.getParameter("mailmdp");
		Etudiant etudiant2 = Manager.getInstance().getEtudiantMail(mail2);
		
		//Si le mail existe dans la base de donnée, envoyer un mail avec le mot de passe sinon message d'erreur
		if(passoublie != null){
		if(etudiant2 != null){
			try {
				boolean envoi=envoyerMail(etudiant2.getNomEtudiant(), etudiant2.getPrenomEtudiant(), mail2, etudiant2.getPassWord());		
				if(envoi){
					request.setAttribute("mailEnvoye", "Votre mot de passe a bien été envoyé sur votre boite mail");
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
					view.forward(request, response);}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {request.setAttribute("mailError", "Votre login n'est pas bon. Veuillez rentrer une adresse mail valide et existante.\n"
				+ " Si l'erreur persiste, créez un nouveau profil");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
    	view.forward(request, response);
		}}
		
	}

	//Renvoi vers la page d'accueil 
	private void redirectCal(HttpServletResponse resp) throws IOException {
	    resp.sendRedirect(getServletContext().getContextPath()+"/monCalendrier1");
	}
	//Renvoi vers la page de préférence
		private void redirectPref(HttpServletResponse resp) throws IOException {
		    resp.sendRedirect(getServletContext().getContextPath()+"/mesOptions");
		}	
	
	//Fonction permettant l'envoi d'un mail pour rappeler le mot de passe à l'utilisateur
private boolean envoyerMail(String nom, String prenom, String mail, String password) throws Exception {
		
	boolean envoi = false;
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
	 
		    
		    message.setText("Bonjour "+ prenom +" " + nom +",\nNous vous rappelons votre mot de passe : "+ password +"\n Nous vous souhaitons une bonne journée. \n Cordialement. \n L'équipe HEI-Diary");
	 
	
		    message.setSentDate(new Date());
		    
		  //Configuration de l'envoi du mail
		    SMTPTransport transport = (SMTPTransport)session.getTransport("smtp");
		    transport.connect("smtp.gmail.com","heidiarybystanetnico@gmail.com","heidiary2014");
		    transport.sendMessage(message,message.getAllRecipients());
		    if(transport.getLastServerResponse() != null){
		    	envoi=true;
		    }
		System.out.println("Reponse " + transport.getLastServerResponse());
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
		return envoi;
	}
}
