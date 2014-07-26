package hei.controllers;

import hei.metier.Manager;
import hei.model.Evenement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimerEventServlet extends HttpServlet {

	private static final long serialVersionUID = -5396762450127606010L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération de l'identifiant de l'évènement sélectionné
		Integer idEvent = Integer.parseInt(request.getParameter("idevenement"));
		
		//Récupération des informations de la commission
		Evenement event = Manager.getInstance().getEvenement(idEvent);
		request.setAttribute("evenement",event);
		
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/supprimerEvent.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération de l'identifiant de l'évènement sélectionné
		Integer idEvent = Integer.parseInt(request.getParameter("idevenement"));
		
		//Récupération de la sélection du bouton
		String reponse1=request.getParameter("trap1");
		String reponse2=request.getParameter("trap2");
		
		//Si oui est seléctionner alors supprimer la commission de la base de données
		if(reponse1 !=null){
			if(reponse1.equalsIgnoreCase("OUI")){
			Manager.getInstance().supprimerEvenement(idEvent);
			response.sendRedirect("espacePresident");}}
		//Si non est seléctionner alors retour à la page précédente
		if(reponse2 != null){
			if(reponse2.equalsIgnoreCase("NON")){
				response.sendRedirect("espacePresident");}}
		
	}
}

