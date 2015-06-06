package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;
import hei.model.Etudiant;
import hei.model.Pole;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdministrationServlet extends HttpServlet {

	private static final long serialVersionUID = 8206984011824134407L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		//Verification du droit d'acces a cette page
		if(statut==3){
			//Recuperation de la liste de tous les utilisateurs
			List<Etudiant> listEtudiant = Manager.getInstance().listerEtudiant();
			request.setAttribute("listEtudiant", listEtudiant);
			
			//Recuperation de toutes les commissions
			List<Commission> listeComm = Manager.getInstance().listerCommission();
			request.setAttribute("listeComm", listeComm);
			
			//Recuperation de toutes les commissions
			List<Pole> listePole = Manager.getInstance().listerPole();
			request.setAttribute("listePole", listePole);
			
			//Mise en place du menu administrateur
			request.setAttribute("menuOption","menuAdmin.jsp");
			
			//Affichage de la page configuration.jsp
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/administration.jsp");
			view.forward(request, response);			
		}else{
			response.sendRedirect("redirection");
		}
	}
	
	/*
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation de l'identifiant de l'utilisateur selectionne
		Integer idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
		Integer idDroit = Integer.parseInt(request.getParameter("droits"));
		
		//Recuperation de la liste de tous les utilisateurs
		List<Etudiant> listEtudiant = Manager.getInstance().listerEtudiant();
		request.setAttribute("listEtudiant", listEtudiant);
				
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
					
		if(statut==3){
			request.setAttribute("menuOption","menuAdmin.jsp");
		}else{
			response.sendRedirect("redirection");
		}
		
		Integer nouvelleAsso=Integer.parseInt(request.getParameter("assignationCommission"));
		Integer nouveauPole=Integer.parseInt(request.getParameter("assignationPole"));
		
		if(nouvelleAsso !=null){
			Manager.getInstance().attribuerNouveauRepComm(nouvelleAsso, idEtudiant);
		}
		else if(nouveauPole !=null){
			Manager.getInstance().attribuerNouveauRepPole(nouveauPole, idEtudiant);
		}else{
			Manager.getInstance().setAdmin(idEtudiant, idDroit);
		}
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/administration.jsp");
		view.forward(request, response);
	}*/
}
