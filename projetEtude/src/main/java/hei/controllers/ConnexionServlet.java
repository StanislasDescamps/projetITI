package hei.controllers;


import hei.metier.Manager;
import hei.model.Etudiant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = -4501231509110259062L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/connexion.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//Ajout du participant et de sa participation	
		String mail = request.getParameter("mail");
		String motpass = request.getParameter("pass");
		
		Etudiant etudiant = Manager.getInstance().getEtudiantMail(mail);
		
		if(motpass.equalsIgnoreCase(etudiant.getPassWord()))
			response.sendRedirect("monCalendrier1");
		else response.sendRedirect("connexion");
	}
}
