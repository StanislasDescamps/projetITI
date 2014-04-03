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

public class ListeModifAssosServlet extends HttpServlet {

	private static final long serialVersionUID = 1876450471952910486L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Commission> listCommBDA = Manager.getInstance().listerCommissionPole("BDA");
		request.setAttribute("listeCommBDA", listCommBDA);
		
		List<Commission> listCommBDS = Manager.getInstance().listerCommissionPole("BDS");
		request.setAttribute("listeCommBDS", listCommBDS);
		
		List<Commission> listCommCapso = Manager.getInstance().listerCommissionPole("CapSo");
		request.setAttribute("listeCommCapso", listCommCapso);
		
		List<Commission> listCommPES = Manager.getInstance().listerCommissionPole("PES");
		request.setAttribute("listeCommBDA", listCommPES);
		
		List<Commission> listCommPET = Manager.getInstance().listerCommissionPole("PET");
		request.setAttribute("listeCommBDA", listCommPET);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/listeModifAsso.jsp");
		view.forward(request, response);
	}
}
