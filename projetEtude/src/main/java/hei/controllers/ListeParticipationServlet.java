package hei.controllers;

import hei.metier.Manager;
import hei.model.Etudiant;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListeParticipationServlet extends HttpServlet {

	private static final long serialVersionUID = -6072167007489569453L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération du statut de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		//Vérification du droit d'accès à cette page
		if(statut != 1){
			response.sendRedirect("redirection");
		}else{
		//Récupération de l'identifiant de la commission sélectionnée
		Integer idEvenement = Integer.parseInt(request.getParameter("idevenement"));
			
		//Récupération de la liste des participants
		List<Etudiant> listParticipant = Manager.getInstance().listerParticipant(idEvenement);
		Integer nbParticipant=listParticipant.size();
		request.setAttribute("nbParticipant", nbParticipant);
		request.setAttribute("listParticipant", listParticipant);

		//Affichage de la page configuration.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/listeParticipation.jsp");
		view.forward(request, response);
		}
	}
}
