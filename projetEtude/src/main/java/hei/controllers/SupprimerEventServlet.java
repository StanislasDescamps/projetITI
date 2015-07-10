package hei.controllers;

import hei.metier.Manager;
//import hei.model.Commission;
//import hei.model.Evenement;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SupprimerEventServlet extends HttpServlet {

	private static final long serialVersionUID = -5396762450127606010L;
	
	/*@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		Integer idEtudiant=(Integer) session.getAttribute("idEtudiant");
		
		//Recuperation de l'identifiant de l'evenement selectionne
		Integer idEvent = Integer.parseInt(request.getParameter("idevenement"));
		
		//Recuperation des information de la commission concernee
		Commission comm = Manager.getInstance().getCommissionEvent(idEvent);
		//Recuperation de l'identifiant du responsable de commission et du responsable de pole associe
		Integer idRespComm = comm.getIdetudiant();
		
		//Vérification du droit d'acces a cette page
		if(statut==0){
			response.sendRedirect("redirection");
		}else if(statut==1 && idEtudiant!=idRespComm){
			response.sendRedirect("redirection");
		}else{		
		
		//Recuperation des informations de la commission
		Evenement event = Manager.getInstance().getEvenement(idEvent);
		request.setAttribute("evenement",event);
		
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/supprimerEvent.jsp");
		view.forward(request, response);
		}
	}*/
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		//Recuperation de l'identifiant de l'evenement selectionne
		Integer idEvent = Integer.parseInt(request.getParameter("idEvent"));
		
		if(statut==3){
			Manager.getInstance().supprimerEvenement(idEvent);
		}
		
		/*
		//Recuperation de la sélection du bouton
		String reponse1=request.getParameter("trap1");
		String reponse2=request.getParameter("trap2");
		
		//Si oui est selectionner alors supprimer la commission de la base de donnees
		if(reponse1 !=null){
			if(reponse1.equalsIgnoreCase("Supprimer")){
			Manager.getInstance().supprimerEvenement(idEvent);
			if(statut==1 || statut==2){
				response.sendRedirect("espaceResp");
			}else{
				response.sendRedirect("administration");
				}
			}
		}
		
		//Si non est selectionner alors retour a la page precedente
		if(reponse2 != null){
			if(reponse2.equalsIgnoreCase("Annuler")){
				if(statut==1 || statut==2){
					response.sendRedirect("espaceResp");
				}else{
					response.sendRedirect("administration");
					}
			
			}
		}*/
		
	}
}

