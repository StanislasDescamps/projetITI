package hei.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModifierEventServlet extends HttpServlet {

	private static final long serialVersionUID = 8505236343345600997L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération du statut de l'utilisateur connecté
				HttpSession session = request.getSession(true);
				Integer statut = (Integer) session.getAttribute("idDroit");
				//request.setAttribute("statut", statut);
				
				if(statut==2){
					request.setAttribute("menuOption","menuAdmin.jsp");
				}else if(statut==1){
					request.setAttribute("menuOption","menuPres.jsp");
				}else{
					request.setAttribute("menuOption","menuOption.jsp");
				}
				
		//Affichage de la page ajouterAsso.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierEvent.jsp");
		view.forward(request, response);
	}
}
