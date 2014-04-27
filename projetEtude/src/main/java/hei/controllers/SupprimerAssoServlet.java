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
		
		String reponse1=request.getParameter("trap1");
		String reponse2=request.getParameter("trap2");
		
		if(reponse1 !=null){
			if(reponse1.equalsIgnoreCase("OUI")){
			Manager.getInstance().supprimerCommission(idCommission);
			response.sendRedirect("listeModifAsso");}}
		if(reponse2 != null){
			if(reponse2.equalsIgnoreCase("NON")){
				response.sendRedirect("listeModifAsso");}}
		
	}
}
