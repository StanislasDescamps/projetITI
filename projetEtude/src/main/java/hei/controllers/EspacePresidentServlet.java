package hei.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EspacePresidentServlet extends HttpServlet{

	private static final long serialVersionUID = -3606105801934562728L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Affichage de la page espacePresident.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/espacePresident.jsp");
		view.forward(request, response);
	}
}
