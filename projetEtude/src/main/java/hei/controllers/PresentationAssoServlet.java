package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;
import hei.model.Etudiant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresentationAssoServlet extends HttpServlet{

	private static final long serialVersionUID = -3056386040446659933L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération de l'identifiant de la commission séléctionnée
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		//Récupération des informations de la commission
		Commission commission = Manager.getInstance().getCommission(idCommission);
		request.setAttribute("commission",commission);
		
		//Récupération des informations de l'étudiant responsable de la commission
		Etudiant etudiant=Manager.getInstance().getEtudiantResp(idCommission);
		request.setAttribute("etudiant", etudiant);
		
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/presentationAsso.jsp");
		view.forward(request, response);
	}
}
