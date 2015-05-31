package hei.controllers;

import hei.metier.Manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class ParticipeServlet extends HttpServlet{

	private static final long serialVersionUID = 4405700722560101651L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recuperation des informations personnelles de l'etudiant
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		
		Gson gson = new Gson();
		//Envoi des evenement auxquels participe l'etudiant en format gson
		String json = gson.toJson(Manager.getInstance().listerEvenementParticipationByUser(idEtudiant));
		PrintWriter out = response.getWriter();
		out.append(json);		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation des informations personnelles de l'etudiant
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		
		//Recuperation de l'identifiant de l'evenement choisi par l'etudiant
		Integer idEvent = Integer.parseInt(request.getParameter("idEvent"));

		//Recuperation de la valeur du bouton presse
		String valueBouton=request.getParameter("participer");
		
		if(valueBouton.equals("Participer")){
			//Ajout de la participation de l'utilisateur dans la base de donnees
			try {
				Manager.getInstance().ajouterParticipant(idEvent,idEtudiant);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(valueBouton.equals("Ne plus Participer")){
			//Retirer de la participation de l'utilisateur dans la base de donnees
			try {
				Manager.getInstance().supprimerParticipant(idEvent,idEtudiant);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
