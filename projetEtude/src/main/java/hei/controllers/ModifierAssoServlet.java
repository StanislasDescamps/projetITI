package hei.controllers;

import hei.metier.Manager;
import hei.model.Commission;
import hei.model.Etudiant;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ModifierAssoServlet extends HttpServlet{

	private static final long serialVersionUID = -5846886860056585206L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation de l'identifiant de la commission sélectionnee
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		//Recuperation des informations de la commission
		Commission commission = Manager.getInstance().getCommission(idCommission);
		request.setAttribute("commission",commission);
		
		Integer idRespPole = Manager.getInstance().getIdRespPoleByComm(idCommission);
		
		//Recuperation des informations de l'etudiant responsable de la commission
		Etudiant etudiant=Manager.getInstance().getEtudiantResp(idCommission);
		request.setAttribute("etudiant", etudiant);
		Integer idRespComm=etudiant.getIdEtudiant();
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		request.setAttribute("statut", statut);
		Integer idEtudiant=(Integer) session.getAttribute("idEtudiant");
		
		System.out.println("IdUser:"+ idEtudiant);
		System.out.println("IdRespComm:"+ idRespComm);
		System.out.println("IdRespPole:"+ idRespPole);
		
		
		if(statut==3){
			request.setAttribute("menuOption","menuAdmin.jsp");
			request.setAttribute("noMenu", false);
		}else if(statut==2){
			if(idEtudiant==idRespPole){
				request.setAttribute("menuOption","menuResp.jsp");
				request.setAttribute("noMenu", true);
			}else{
				response.sendRedirect("redirection");
			}
		}else if(statut==1){
			if(idEtudiant==idRespComm){
				request.setAttribute("menuOption","menuResp.jsp");
				request.setAttribute("noMenu", true);
			}else{
				response.sendRedirect("redirection");
				}
		}else{
			response.sendRedirect("redirection");
		}
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
		view.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idpole2 = null;
		
		//Recuperation de l'identifiant de la commission selectionnee
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		//Recuperation de tous les etudiants de la base de donnees dans une liste
		List<Etudiant> listeetudiant = Manager.getInstance().listerEtudiant();
		
		//Recuperation des champs
		String nom = request.getParameter("nomAsso");
		String mailResp = request.getParameter("mailResp");
		String idpole = request.getParameter("bureau");
		String description = request.getParameter("description");
		String logo = request.getParameter("logo");
		
		if(idpole.equals("")){
			request.setAttribute("ErrorChamps", "Il y a une erreur dans votre requette. Veuillez vérifier que vous avez bien renseigné le champ 'pole associé' avant de valider.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
			view.forward(request, response);
		}else{
		
			idpole2=Integer.parseInt(idpole);
		
		
		//Verification de l'existance du nouvel etudiant responsable dans la base de donnees
		Etudiant etudiant = Manager.getInstance().getEtudiantMail(mailResp);
		boolean Etudiantexistant =false;
		int i =0;
		
		while(Etudiantexistant==false && i<listeetudiant.size())
			
		{
			if(mailResp.equalsIgnoreCase(listeetudiant.get(i).getEmail()))
			{
				Etudiantexistant=true;
			}
			else {Etudiantexistant=false;
			i++;}
			}
	//Si existant, enregistrer les modifications sinon message d'erreur
if(Etudiantexistant){
		
		Manager.getInstance().modifierCommission(idCommission, etudiant.getIdEtudiant(), idpole2, nom, description, logo);
		response.sendRedirect("presentationAsso?idcommission=" + idCommission);}
else{
	request.setAttribute("ErrorEtudiant2", "Il y a une erreur dans votre requette. Veuillez vérifier que le mail de l'étudiant référent a bien été rentré et que l'étudiant a bien créé son profil auparavant.");
	RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
	view.forward(request, response);
	}

	}
	}
}
