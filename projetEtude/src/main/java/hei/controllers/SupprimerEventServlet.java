package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;
import hei.model.Evenement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SupprimerEventServlet extends HttpServlet {

	private static final long serialVersionUID = -5396762450127606010L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération du statut de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		Integer idEtudiant=(Integer) session.getAttribute("idEtudiant");
		
		//Récupération de l'identifiant de l'évènement sélectionné
		Integer idEvent = Integer.parseInt(request.getParameter("idevenement"));
		
		//Récupération des information de la commission concernée
		Commission comm = Manager.getInstance().getCommissionEvent(idEvent);
		//Récupération de l'identifiant du responsable de commission et du responsable de pole associé
		Integer idRespComm = comm.getIdetudiant();
		
		//Vérification du droit d'accès à cette page
		if(statut==0){
			response.sendRedirect("redirection");
		}else if(statut==1 && idEtudiant!=idRespComm){
			response.sendRedirect("redirection");
		}else{		
		
		//Récupération des informations de la commission
		Evenement event = Manager.getInstance().getEvenement(idEvent);
		request.setAttribute("evenement",event);
		
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/supprimerEvent.jsp");
		view.forward(request, response);
		}
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
			response.sendRedirect("espaceResp");}}
		//Si non est seléctionner alors retour à la page précédente
		if(reponse2 != null){
			if(reponse2.equalsIgnoreCase("NON")){
				response.sendRedirect("espaceResp");}}
		
	}
}

