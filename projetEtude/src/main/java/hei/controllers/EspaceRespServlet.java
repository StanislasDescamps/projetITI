package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;
import hei.model.Evenement;
import hei.model.Pole;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EspaceRespServlet extends HttpServlet{

	private static final long serialVersionUID = -3606105801934562728L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération des informations de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
						
		if(statut==3){
			request.setAttribute("menuOption","menuAdmin.jsp");
			request.setAttribute("statut", statut);
		}else if(statut==2 || statut==1){
			request.setAttribute("menuOption","menuResp.jsp");
			request.setAttribute("statut", statut);
		}else{
			request.setAttribute("menuOption","menuOption.jsp");
		}
		
		if(statut==1){
			//Récupération de la liste des évènements dont l'utilisateur est responsable
			Commission comm = Manager.getInstance().getCommissionByIdRef(idEtudiant);
			request.setAttribute("commission", comm);
			
			Integer idCommission=comm.getIdcommission();
			//Récupération de la liste des évènements dont l'utilisateur est responsable
			List<Evenement> listEvent = Manager.getInstance().listerEvenementByCommission(idCommission);
			request.setAttribute("listEvent", listEvent);
		}
		
		if(statut==2){
			Pole pole=Manager.getInstance().getPoleByResp(idEtudiant);
			request.setAttribute("pole", pole);
			List<Commission> listeCommission = Manager.getInstance().listerCommissionPole(pole.getNomPole());
			request.setAttribute("listeCommission", listeCommission);
		}
		
		if(statut==3){
			//Code
		}
		//Affichage de la page espacePresident.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/espaceResp.jsp");
		view.forward(request, response);
		}
}
