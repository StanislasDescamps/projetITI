package hei.controllers;

import hei.metier.Manager;
import hei.model.Etudiant;
import hei.model.Evenement;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class MonCalendrier1Servlet extends HttpServlet {

	private static final long serialVersionUID = 4899983373251596603L;
	public static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat formatHeure = new SimpleDateFormat("HH");
	public static SimpleDateFormat formatMinute = new SimpleDateFormat("mm");
	public static SimpleDateFormat formatSec = new SimpleDateFormat("ss");
	public static SimpleDateFormat formatAnnee = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat formatMois = new SimpleDateFormat("MM");
	public static SimpleDateFormat formatJour = new SimpleDateFormat("dd");


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		//Récupération des événements personnels
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		List<Evenement> listEvent = Manager.getInstance().listerEvenementEtudiant(idEtudiant);
		
		//Selectionne les événements non passés
		List<String> listeDate=new ArrayList<String>();
		Date dateToday=new Date();
		Integer aujourdhui = DateToInt(dateToday);
		
		for (int i=0; i<listEvent.size(); i++) {
			Evenement event= Manager.getInstance().getEvenement(listEvent.get(i).getIdEvenement());
			if(aujourdhui== Integer.parseInt(stringprete(event.getDateFin()))||aujourdhui<Integer.parseInt(stringprete(event.getDateFin()))){		
			
			listeDate.add(event.getDateDebut());
			}
		}
		if(listeDate.size()!=1){
			//Ordonne les dates - Les dates sont transformées en format long
			int tableaus[] = new int[listeDate.size()];
			for(int i=0; i<listeDate.size(); i++){
				tableaus[i]= Integer.parseInt(stringprete(listeDate.get(i)));
			}
			triCroissant(tableaus);
		
		//Remise en format date et dans une liste
			List<String> listeDateOrdonnee = new ArrayList<String>();
			
			for(int i=0;i<listeDate.size();i++){
				String date =nombreToString(tableaus[i]);
				listeDateOrdonnee.add(date);			
			}
		List<Evenement> listeEvent=new ArrayList<Evenement>();
			
			for (int j=0; j<listeDate.size(); j++) {
			Evenement Event = Manager.getInstance().getEvenementByDate(listeDateOrdonnee.get(j));
			listeEvent.add(Event);
			request.setAttribute("listeEventPerso", listeEvent);
			}
			}else {
			List<Evenement> listeEvent=new ArrayList<Evenement>();
				for (int j=0; j<listeDate.size(); j++) {
			Evenement Event = Manager.getInstance().getEvenementByDate(listeDate.get(j));
			listeEvent.add(Event);
			request.setAttribute("listeEventPerso", listeEvent);
				}
		}
				
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/monCalendrier1.jsp");
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
		String dateDebut = event.getDateDebut();
		String dateFin = event.getDateFin();
		
		try {
			envoyerMailEvent(idEvent,titreEvent,  lieu,  dateDebut,  dateFin,  mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("monCalendrier1");
	}
	
private void envoyerMailEvent(Integer idEvent, String nomEvent, String lieu, String dateDebut, String dateFin, String mail) throws Exception {
		
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
public static int DateToInt (Date date){
	String annee = formatAnnee.format(date);
	String mois = formatMois.format(date);
	String jour = formatJour.format(date);
	
	String nombre = annee+mois+jour;
	
	Integer dateNombre = Integer.parseInt(nombre);
	
	return dateNombre;
}
public static String nombreToString(int nombre){
	
	String nomb = String.valueOf(nombre);
	
	String year="";
	String month="";
	String day = "";
	
	 	
	for(int i=0; i<8;i++){
		if(i<4){
			year = year + nomb.charAt(i);
		} 
		if(i>=4 && i<6){
			month = month + nomb.charAt(i);
		}
		if(i>=6 && i<8){
			day = day + nomb.charAt(i);
		}
		
	}
	String date = year+"-"+month+"-"+day;
	
	return date;
}
public static String stringprete(String ladate){
	int longueur = 10;
	String string = "";
	
	for(int i=0; i<longueur; i++){
		if(i<4)
		{string = string + ladate.charAt(i);}
		if(i>=5 && i<7)
		{string = string + ladate.charAt(i);}
		if(i>=8 && i<10)
		{string = string + ladate.charAt(i);}
	}
	
	return string;	
}
public static Date stringToDate(String sDate) throws ParseException {
    return formatDate.parse(sDate);
}
public static void triCroissant(int tableau[]) {
	int longueur = tableau.length;
	int tampon = 0;
	boolean permut;

	do {
		// hypothèse : le tableau est trié
		permut = false;
		for (int i = 0; i < longueur - 1; i++) {
			// Teste si 2 éléments successifs sont dans le bon ordre ou non
			if (tableau[i] > tableau[i + 1]) {
				// s'ils ne le sont pas, on échange leurs positions
				tampon = tableau[i];
				tableau[i] = tableau[i + 1];
				tableau[i + 1] = tampon;
				permut = true;
			}
		}
	} while (permut);
}
}
