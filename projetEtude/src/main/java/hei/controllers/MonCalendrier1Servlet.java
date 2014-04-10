package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;
import hei.model.Evenement;
import hei.model.Pole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MonCalendrier1Servlet extends HttpServlet {

	private static final long serialVersionUID = 4899983373251596603L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		List<Evenement> listEvent = Manager.getInstance().listerEvenementEtudiant(idEtudiant);
		request.setAttribute("listeEventPerso", listEvent);
		
		List<String> nomDesPoles = new ArrayList<String>();
		for (int i=0; i<listEvent.size(); i++) {
			Pole pole= Manager.getInstance().getPoleEvent(listEvent.get(i).getIdEvenement());
			nomDesPoles.add(pole.getNomPole());
		}
		request.setAttribute("listePoleEvent", nomDesPoles);
		
		List<String> nomDesComm = new ArrayList<String>();
		for (int j=0;j<listEvent.size(); j++){
			Commission commission = Manager.getInstance().getCommissionEvent(listEvent.get(j).getIdCommission());
			nomDesComm.add(commission.getNomCommission());
		}
		request.setAttribute("listeCommEvent", nomDesComm);
		
		List<String> adressLogo =new ArrayList<String>();
		for (int i=0; i<listEvent.size();i++){
			Commission commission = Manager.getInstance().getCommissionEvent(listEvent.get(i).getIdCommission());
			adressLogo.add(commission.getLogo());
		}
		request.setAttribute("commission", adressLogo);
		
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/monCalendrier1.jsp");
		view.forward(request, response);
	}
}
