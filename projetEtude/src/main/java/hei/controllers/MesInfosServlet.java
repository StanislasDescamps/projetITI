package hei.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MesInfosServlet extends HttpServlet{

	private static final long serialVersionUID = 1321202550306113393L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Affichage de la page mesInfos.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesInfos.jsp");
		view.forward(request, response);
	}

}
