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
		
		//Récupération du statut de l'utilisateur connecté
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		Etudiant etudiant=Manager.getInstance().getEtudiant(idEtudiant);
		
		if(statut==2){
			request.setAttribute("menuOption","menuAdmin.jsp");
		}else if(statut==1){
			request.setAttribute("menuOption","menuPres.jsp");
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
		
		HttpSession session = request.getSession(true);
		Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
		
		String modifMail=request.getParameter("modifMail");
		String modifMdp=request.getParameter("modifMdp");
		
		if(modifMail !=null){
			String mail=request.getParameter("newMail");
			if(mail.endsWith("@hei.fr")){
				Manager.getInstance().modifierMail(idEtudiant, mail);
				request.setAttribute("ModifOk", "Vos modifications ont bien été enregistré.");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
				view.forward(request, response);
			}else{
				request.setAttribute("ModifMailKo", "Votre adresse email doit être une adresse mail hei.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
			view.forward(request, response);
			}
		}
		
		if(modifMdp !=null){
			String mdp1=request.getParameter("newMdp1");
			String mdp2=request.getParameter("newMdp2");
			if(mdp1.equals(mdp2)){
				Manager.getInstance().modifierMdP(idEtudiant, mdp2);
				request.setAttribute("ModifOk", "Vos modifications ont bien été enregistré.");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
				view.forward(request, response);
			}else{
				request.setAttribute("ModifMdpKo", "Les deux champs doivent être identiques.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
			view.forward(request, response);
			}
		}
		
	}
}
