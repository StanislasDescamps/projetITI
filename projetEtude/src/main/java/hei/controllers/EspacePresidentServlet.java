package hei.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EspacePresidentServlet extends HttpServlet{

	private static final long serialVersionUID = -3606105801934562728L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération du statut de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
						
		if(statut==2){
			request.setAttribute("menuOption","menuAdmin.jsp");
		}else if(statut==1){
			request.setAttribute("menuOption","menuPres.jsp");
		}else{
			request.setAttribute("menuOption","menuOption.jsp");
		}
		//Affichage de la page espacePresident.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/espacePresident.jsp");
		view.forward(request, response);
	}
}
