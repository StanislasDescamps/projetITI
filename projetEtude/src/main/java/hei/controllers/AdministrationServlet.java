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
		
		//Récupération du statut de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		//Vérification du droit d'accès à cette page
		if(statut !=3){
			response.sendRedirect("redirection");
		}else{
		
		//Récupération de la liste de tous les utilisateurs
		List<Etudiant> listEtudiant = Manager.getInstance().listerEtudiant();
		request.setAttribute("listEtudiant", listEtudiant);
		
		//Récupération de toutes les commissions
		List<Commission> listeComm = Manager.getInstance().listerCommission();
		request.setAttribute("listeComm", listeComm);
		
		//Récupération de toutes les commissions
		List<Pole> listePole = Manager.getInstance().listerPole();
		request.setAttribute("listePole", listePole);
		
		//Mise en place du menu administrateur
		request.setAttribute("menuOption","menuAdmin.jsp");
		
		//Affichage de la page configuration.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/administration.jsp");
		view.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération de l'identifiant de l'utilisateur sélectionné
		Integer idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
		Integer idDroit = Integer.parseInt(request.getParameter("droits"));
		
		//Récupération de la liste de tous les utilisateurs
		List<Etudiant> listEtudiant = Manager.getInstance().listerEtudiant();
		request.setAttribute("listEtudiant", listEtudiant);
				
		//Récupération du statut de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
					
		if(statut==3){
			request.setAttribute("menuOption","menuAdmin.jsp");
		}else if(statut==2 || statut==1){
			request.setAttribute("menuOption","menuResp.jsp");
		}else{
			request.setAttribute("menuOption","menuOption.jsp");
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
	}
}
