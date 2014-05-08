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

public class ListeModifAssosServlet extends HttpServlet {

	private static final long serialVersionUID = 1876450471952910486L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération de toutes les commissions dans une liste
		List<Commission> listComm = Manager.getInstance().listerCommission();
		request.setAttribute("listeComm", listComm);
		
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/listeModifAsso.jsp");
		view.forward(request, response);
	}
}
