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

public class CalendrierHeiServlet extends HttpServlet {

	private static final long serialVersionUID = -6362843685737252100L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Evenement> listEvent = Manager.getInstance().listerEvenement();
		request.setAttribute("listeEventEntiere", listEvent);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/calendrierHei.jsp");
		view.forward(request, response);
	}
}
