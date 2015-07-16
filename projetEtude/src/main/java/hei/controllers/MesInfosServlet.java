package hei.controllers;

import hei.metier.Manager;
import hei.model.Etudiant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MesInfosServlet extends HttpServlet{

	private static final long serialVersionUID = 1321202550306113393L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		Etudiant etudiant=Manager.getInstance().getEtudiant(idEtudiant);
		
		if(statut==3){
			request.setAttribute("menuOption","menuAdmin.jsp");
		}else if(statut==2 || statut==1){
			request.setAttribute("menuOption","menuResp.jsp");
		}else{
			request.setAttribute("menuOption","menuOption.jsp");
		}
		
		request.setAttribute("etudiant",etudiant);
				
		//Affichage de la page mesInfos.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesInfos.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		Integer statut = (Integer) session.getAttribute("idDroit");
		Boolean firstConnexion = (Boolean) session.getAttribute("firstConnexion");
		Etudiant etudiant=Manager.getInstance().getEtudiant(idEtudiant);
		
		String modifMail=request.getParameter("modifEmail");
		String modifMdp=request.getParameter("modifMdp");
		String suffix= "@hei.fr";
		
							
		if(statut==2){
			request.setAttribute("menuOption","menuAdmin.jsp");
		}else if(statut==1){
			request.setAttribute("menuOption","menuResp.jsp");
		}else{
			request.setAttribute("menuOption","menuOption.jsp");
		}
		request.setAttribute("etudiant",etudiant);
		
		if(modifMail !=null){
			String mail=request.getParameter("newEmail");
			if(mail.endsWith(suffix)){
				Manager.getInstance().modifierMail(idEtudiant, mail);
				request.setAttribute("ModifMailOk", "Vos modifications ont bien été enregistrées.");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesInfos.jsp");
				view.forward(request, response);
			}else{
				request.setAttribute("ModifMailKo", "Votre adresse email doit être une adresse mail hei.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesInfos.jsp");
			view.forward(request, response);
			}
		}
		
		if(modifMdp !=null){
			String mdp1=request.getParameter("newMdp1");
			String mdp2=request.getParameter("newMdp2");
			if(mdp1.equals(mdp2)){
				Manager.getInstance().modifierMdP(idEtudiant, mdp2);
				request.setAttribute("ModifMpOk", "Vos modifications ont bien été enregistrées.");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesInfos.jsp");
				view.forward(request, response);
				if(firstConnexion) {
					Manager.getInstance().firstConnexionSetFalse(idEtudiant);
				}
			}else{
				request.setAttribute("ModifMdpKo", "Les deux champs doivent être identiques.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/mesInfos.jsp");
			view.forward(request, response);
			}
		}
		
	}
}
