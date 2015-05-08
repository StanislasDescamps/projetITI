package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MesOptionsServlet extends HttpServlet{

	private static final long serialVersionUID = -2882946882211779676L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
						
		//Recuperation de toutes les commissions dans une liste
		List<Commission> listComm = Manager.getInstance().listerCommission();
		request.setAttribute("listeComm",listComm);
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		//request.setAttribute("statut", statut);
		
		if(statut==3){
			request.setAttribute("menuOption","menuAdmin.jsp");
		}else if(statut==2 || statut==1){
			request.setAttribute("menuOption","menuResp.jsp");
		}else{
			request.setAttribute("menuOption","menuOption.jsp");
		}
		
		
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesOptions.jsp");
		view.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation de l'identifiant de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		
		//Recuperation du bouton sélectionne
		String btnenregistrer = request.getParameter("enregistrer");
		String btnreinitialiser = request.getParameter("reinitialiser");
		
		//Si selection du bouton enregistrer
		if(btnenregistrer != null){
			//Recuperation de tous les elements coches et ajout dans une liste de format string
			String[] preference = request.getParameterValues("commission");
			for(int i=0;i<preference.length;i++)
			{
				//Ajout du choix de l'utilisateur dans la base de donnees
				Integer idCommission=Integer.parseInt(preference[i]);
				Manager.getInstance().ajouterChoixCommission(idEtudiant,idCommission);
				
			}
			response.sendRedirect("monCalendrier1");}
		//Si selection du bouton reinitialiser, suppression de tous les choix de l'utilisateur
		if(btnreinitialiser != null){
			Manager.getInstance().supprimerChoix(idEtudiant);
			response.sendRedirect("mesOptions");
		}
	
	}
}
