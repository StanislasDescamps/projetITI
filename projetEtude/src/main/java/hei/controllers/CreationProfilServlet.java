package hei.controllers;

import hei.metier.Manager;
import hei.model.Etudiant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreationProfilServlet extends HttpServlet {


	private static final long serialVersionUID = 6428922108074858393L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/creationProfil.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//Ajout du participant et de sa participation	
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String motpass= "azer1";
		
		Etudiant nouvelEtudiant = new Etudiant(null, nom, prenom, motpass, mail, false);
		Manager.getInstance().ajouterEtudiant(nouvelEtudiant);
		
		response.sendRedirect("connexion");
	}
}
