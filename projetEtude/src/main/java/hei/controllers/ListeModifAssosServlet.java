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
import javax.servlet.http.HttpSession;

public class ListeModifAssosServlet extends HttpServlet {

	private static final long serialVersionUID = 1876450471952910486L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération de toutes les commissions dans une liste
		List<Commission> listComm = Manager.getInstance().listerCommission();
		request.setAttribute("listeComm", listComm);
		
		//Récupération du statut de l'utilisateur connecté
				HttpSession session = request.getSession(true);
				Integer statut = (Integer) session.getAttribute("idDroit");
				//request.setAttribute("statut", statut);
				
				if(statut==3){
					request.setAttribute("menuOption","menuAdmin.jsp");
				}else if(statut==2 || statut==1){
					request.setAttribute("menuOption","menuResp.jsp");
				}else{
					request.setAttribute("menuOption","menuOption.jsp");
				}
				
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/listeModifAsso.jsp");
		view.forward(request, response);
	}
}
