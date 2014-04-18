package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;
import hei.model.Etudiant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresentationAssoServlet extends HttpServlet{

	private static final long serialVersionUID = -3056386040446659933L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		Commission commission = Manager.getInstance().getCommission(idCommission);
		request.setAttribute("commission",commission);
		
		Etudiant etudiant=Manager.getInstance().getEtudiantResp(idCommission);
		request.setAttribute("etudiant", etudiant);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/presentationAsso.jsp");
		view.forward(request, response);
	}
}
