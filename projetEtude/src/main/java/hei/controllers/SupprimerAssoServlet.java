package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimerAssoServlet extends HttpServlet {

	private static final long serialVersionUID = -5033196913794100712L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		Commission commission = Manager.getInstance().getCommission(idCommission);
		request.setAttribute("commission",commission);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/supprimerAsso.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		String reponse=request.getParameter("monBouton");
		
		System.out.println(reponse);
		//if(reponse.equals("OUI")){
		//	Manager.getInstance().supprimerCommission(idCommission);}
			
		//response.sendRedirect("listeModifAsso");
	}
}
