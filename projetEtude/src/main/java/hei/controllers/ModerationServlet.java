package hei.controllers;

import hei.metier.Manager;
import hei.model.Evenement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModerationServlet extends HttpServlet {

	private static final long serialVersionUID = -1142923016491780215L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation des informations de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		//Verification du statut de l'utilisateur
		if(statut!=2 && statut!=3 ){
			response.sendRedirect("redirection");
		}else{
			
			request.setAttribute("menuOption","menuAdmin.jsp");
			//Recuperation de la liste de tous les evenements
			List<Evenement> listeEventModere = Manager.getInstance().listerEvenementModere();
			Integer nbModeration=listeEventModere.size();
			
			//Attribution des listes
			request.setAttribute("nbModeration", nbModeration);
			request.setAttribute("listeEventModere", listeEventModere);
			request.setAttribute("statut", statut);
			
		//Affichage de la page configuration.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/moderation.jsp");
		view.forward(request, response);
		}
	}
}
