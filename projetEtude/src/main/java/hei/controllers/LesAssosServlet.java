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

public class LesAssosServlet extends HttpServlet {

	private static final long serialVersionUID = 856543977083065278L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Commission> listeComm = Manager.getInstance().listerCommission();
		request.setAttribute("listeComm", listeComm);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/lesAssos.jsp");
		view.forward(request, response);
	}
	
}
