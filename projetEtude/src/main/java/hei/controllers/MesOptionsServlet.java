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

public class MesOptionsServlet extends HttpServlet{

	private static final long serialVersionUID = -2882946882211779676L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		List<Commission> listCommBDA = Manager.getInstance().listerCommissionPole("BDA");
		request.setAttribute("listCommBDA",listCommBDA);
		List<Commission> listCommBDS = Manager.getInstance().listerCommissionPole("BDS");
		request.setAttribute("listCommBDS", listCommBDS);
		List<Commission> listCommCap = Manager.getInstance().listerCommissionPole("CapSo");
		request.setAttribute("listCommCap", listCommCap);
		List<Commission> listCommPES = Manager.getInstance().listerCommissionPole("PES");
		request.setAttribute("listCommPES", listCommPES);
		List<Commission> listCommPET = Manager.getInstance().listerCommissionPole("PET");
		request.setAttribute("listCommPET", listCommPET);
		
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesOptions.jsp");
		view.forward(request, response);
	}
}
