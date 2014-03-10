package hei.controllers;

import hei.metier.Manager;
import hei.model.Etudiant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		List<Etudiant> listEtudiant = new ArrayList<Etudiant>();
		listEtudiant = Manager.getInstance().listerEtudiant();
		
		Integer i=0;
		Integer n = listEtudiant.size();
		Boolean exist=false;
		
		while(i<n && !exist)
		{
			if(mail.equalsIgnoreCase(listEtudiant.get(i).getEmail()))
				{
				exist=true;
				}
			else i++;
		}
		
		if(!exist)
		{
		Etudiant nouvelEtudiant = new Etudiant(null, nom, prenom, motpass, mail, false);
		Manager.getInstance().ajouterEtudiant(nouvelEtudiant);
		response.sendRedirect("connexion");
		} 
		else
		{
		request.setAttribute("loginError", "Votre login n'est pas bon. Veuillez rentrer un utilisateur et un mot de passe valide.");
		response.sendRedirect("creationProfil");
		}
	}
}
