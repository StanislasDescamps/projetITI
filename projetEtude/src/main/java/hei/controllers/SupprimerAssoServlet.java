package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SupprimerAssoServlet extends HttpServlet {

	private static final long serialVersionUID = -5033196913794100712L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération du statut de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		if(statut!=3){
			response.sendRedirect("redirection");
		}else{
		
		//Récupération de l'identifiant de la commission sélectionnée
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		//Récupération des informations de la commission
		Commission commission = Manager.getInstance().getCommission(idCommission);
		request.setAttribute("commission",commission);
		
		
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/supprimerAsso.jsp");
		view.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération de l'identifiant de la commission sélectionnée
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		//Récupération de la sélection du bouton
		String reponse1=request.getParameter("trap1");
		String reponse2=request.getParameter("trap2");
		
		//Si oui est seléctionner alors supprimer la commission de la base de données
		if(reponse1 !=null){
			if(reponse1.equalsIgnoreCase("OUI")){
			Manager.getInstance().supprimerCommission(idCommission);
			response.sendRedirect("listeModifAsso");}}
		//Si non est seléctionner alors retour à la page précédente
		if(reponse2 != null){
			if(reponse2.equalsIgnoreCase("NON")){
				response.sendRedirect("listeModifAsso");}}
		
	}
}
