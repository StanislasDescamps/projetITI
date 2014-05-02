package hei.controllers;

import hei.metier.Manager;
import hei.model.Etudiant;
//import hei.model.Commission;
import hei.model.Evenement;
//import hei.model.Pole;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
//import java.util.ArrayList;
import java.util.List;
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

public class CalendrierHeiServlet extends HttpServlet {

	private static final long serialVersionUID = -6362843685737252100L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Evenement> listEvent = Manager.getInstance().listerEvenement();
		
		
		List<Date> listeDate=new ArrayList<Date>();
		Date dateToday=new Date();
		for (int i=0; i<listEvent.size(); i++) {
			Evenement event= Manager.getInstance().getEvenement(listEvent.get(i).getIdEvenement());
			if(dateToday.equals(event.getDateDebut())||dateToday.before(event.getDateDebut())){		
			
			listeDate.add(event.getDateDebut());
			}
		
		}
		
		/*List<Date> listeDate2=new ArrayList<Date>();
		boolean permut;
		do{
			permut=false;
			for(int i=0; i<listeDate.size() - 1; i++){
				
				if (listeDate.get(i).after(listeDate.get(i+1))) {
					// s'ils ne le sont pas, on échange leurs positions
					Date tampon1 = listeDate.get(i);
					Date tampon2 = listeDate.get(i+1);
					listeDate2.add(tampon2);
					listeDate2.add(tampon1);
					permut = true;
				}
			}
		}while(permut);*/
		
		List<Evenement> listeEvent=new ArrayList<Evenement>();
		for (int j=0; j<listeDate.size(); j++) {
		Evenement Event = Manager.getInstance().getEvenementByDate(listeDate.get(j));
		listeEvent.add(Event);
		}
		request.setAttribute("listeEventEntiere", listeEvent);
		
		/*List<String> nomDesPoles = new ArrayList<String>();
		for (int i=0; i<listEvent.size(); i++) {
			Pole pole= Manager.getInstance().getPoleEvent(listEvent.get(i).getIdEvenement());
			nomDesPoles.add(pole.getNomPole());
		}
		request.setAttribute("listePoleEvent", nomDesPoles);
		
		List<String> nomDesComm = new ArrayList<String>();
		for (int j=0;j<listEvent.size(); j++){
			Commission commission = Manager.getInstance().getCommissionEvent(listEvent.get(j).getIdCommission());
			nomDesComm.add(commission.getNomCommission());
		}
		request.setAttribute("listeCommEvent", nomDesComm);
		
		List<String> adressLogo =new ArrayList<String>();
		for (int i=0; i<listEvent.size();i++){
			Commission commission = Manager.getInstance().getCommissionEvent(listEvent.get(i).getIdCommission());
			adressLogo.add(commission.getLogo());
		}
		request.setAttribute("commission", adressLogo);*/
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/calendrierHei.jsp");
		view.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		Etudiant etudiant = Manager.getInstance().getEtudiant(idEtudiant);
		String mail = etudiant.getEmail();
		
		
		Integer idEvent = Integer.parseInt(request.getParameter("idEvent"));
		Evenement event = Manager.getInstance().getEvenement(idEvent);
		
		String titreEvent = event.getTitreEvent();
		String lieu = event.getLieu();
		Date dateDebut = event.getDateDebut();
		Date dateFin = event.getDateFin();
		
		try {
			envoyerMailEvent(idEvent,titreEvent,  lieu,  dateDebut,  dateFin,  mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("calendrierHei");
	}
private void envoyerMailEvent(Integer idEvent, String nomEvent, String lieu, Date dateDebut, Date dateFin, String mail) throws Exception {
		
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
		    message.setSubject("Evenement " + nomEvent);
	 
		    
		    message.setText("BEGIN:VCALENDAR\n"
		    		+ "VERSION:2.0\n"
		    		+ "PRODID:-//HEI DAIRY//Event//FR \n"
		    		+ "BEGIN:VEVENT\n"
		    		+ "DTSTART:"+ dateDebut +"\n"
		    		+ "DTEND:"+ dateFin +"\n"
		    		+ "SUMMARY:"+ nomEvent + "\n"
		    		+ "LOCATION:"+ lieu + "\n"
		    		+ "UID:"+ idEvent + "\n"
		    		+ "END:VEVENT\n"
		    		+ "END:VCALENDAR\n");
	 
	
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
