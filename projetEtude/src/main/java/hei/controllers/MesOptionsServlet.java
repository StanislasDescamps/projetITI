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

public class MesOptionsServlet extends HttpServlet{

	private static final long serialVersionUID = -2882946882211779676L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		List<Commission> listComm = Manager.getInstance().listerCommission();
		request.setAttribute("listeComm",listComm);
		HttpSession session = request.getSession(true);
		boolean statut = (Boolean) session.getAttribute("admin");
		//Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		request.setAttribute("statut", statut);
				
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesOptions.jsp");
		view.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		
		String btnenregistrer = request.getParameter("enregistrer");
		String btnreinitialiser = request.getParameter("reinitialiser");
		
		
		if(btnenregistrer != null){
			String[] preference = request.getParameterValues("commission");
			for(int i=0;i<preference.length;i++)
			{
				Integer idCommission=Integer.parseInt(preference[i]);
				Manager.getInstance().ajouterChoixCommission(idEtudiant,idCommission);
				
			}
			response.sendRedirect("monCalendrier1");}		
		if(btnreinitialiser != null){
			Manager.getInstance().supprimerChoix(idEtudiant);
			response.sendRedirect("mesOptions");
		}
	
	}
}
