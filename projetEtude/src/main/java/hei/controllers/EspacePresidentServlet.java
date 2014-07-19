package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;
import hei.model.Evenement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EspacePresidentServlet extends HttpServlet{

	private static final long serialVersionUID = -3606105801934562728L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération des informations de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
						
		if(statut==2){
			request.setAttribute("menuOption","menuAdmin.jsp");
		}else if(statut==1){
			request.setAttribute("menuOption","menuPres.jsp");
		}else{
			request.setAttribute("menuOption","menuOption.jsp");
		}
		
		//Récupération de la liste des évènements dont l'utilisateur est responsable
		Commission comm = Manager.getInstance().getCommissionByIdRef(idEtudiant);
		request.setAttribute("commission", comm);
		
		Integer idCommission=comm.getIdcommission();
		//Récupération de la liste des évènements dont l'utilisateur est responsable
		List<Evenement> listEvent = Manager.getInstance().listerEvenementByCommission(idCommission);
		request.setAttribute("listEvent", listEvent);

		//Affichage de la page espacePresident.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/espacePresident.jsp");
		view.forward(request, response);
		}
}
