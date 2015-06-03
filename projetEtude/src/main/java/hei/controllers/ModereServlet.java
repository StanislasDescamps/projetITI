package hei.controllers;

import hei.metier.Manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModereServlet extends HttpServlet{

	private static final long serialVersionUID = -3598627997971427635L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation des informations personnelles de l'etudiant
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		//Recuperation de l'identifiant de l'evenement choisi par l'etudiant
		Integer idEvent = Integer.parseInt(request.getParameter("idEvent"));
		
		//Recuperation de la valeur du bouton presse
		String value=request.getParameter("moderation");
		if(statut==2){
			if(value.equals("setModere")){
				try {
					Manager.getInstance().setModeration(idEvent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(statut==3){
			if(value.equals("unSetModere")){
				try {
					Manager.getInstance().setUnModeration(idEvent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
