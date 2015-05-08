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


public class AjouterAssoServlet extends HttpServlet{

	private static final long serialVersionUID = -9077684945660855800L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		//request.setAttribute("statut", statut);
		
		//Verification du droit d'acces a cette page
		if(statut!=3){
			response.sendRedirect("redirection");
			
		}else {
		//Mise en place du menu administrateur
		request.setAttribute("menuOption","menuAdmin.jsp");
		
		//Affichage de la page ajouterAsso.jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/ajouterAsso.jsp");
		view.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//Recuperation des listes de tous les etudiants et commissions
		List<Etudiant> listeEtudiant = Manager.getInstance().listerEtudiant();
		List<Commission> listeCommission=Manager.getInstance().listerCommission();
		
		//Recuperation des champs
		String nomAsso = request.getParameter("nomAsso");
		String mailReferent = request.getParameter("referent");
		String pole = request.getParameter("bureau");
		String logo =request.getParameter("logo");
		String description = request.getParameter("description");
		
		boolean Etudiantexistant =false;
		boolean Commexistante = false;
		int i =0;
		int j =0;
		
		Integer idPole=null;
		
		if(pole.equals("")){
			request.setAttribute("ErrorChamps", "Il y a une erreur dans votre requette. Veuillez vérifier que vous avez bien renseigné le champ 'pole associé' avant de valider.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/ajouterAsso.jsp");
			view.forward(request, response);
		}else{
			idPole = Manager.getInstance().getPolebyNom(pole).getIdPole();
				
		//Verification de l'inexistance de la commission
		while(Commexistante == false && j<listeCommission.size())
		{
			if(nomAsso.toLowerCase().equalsIgnoreCase(listeCommission.get(j).getNomCommission().toLowerCase()))
			{
				Commexistante = true;
				request.setAttribute("ErrorComm", "Il y a une erreur dans votre requette. Veuillez vérifier que la commission n'existe pas déjà. Si le problème persiste, voyez avec la maintenance");
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/ajouterAsso.jsp");
		    	view.forward(request, response);
			}
			else{j++;}
		}	
		
		//Si inexistante, verification de l'existance du referent
		if(!Commexistante){
				while(Etudiantexistant==false && i<listeEtudiant.size())
			
				{
					if(mailReferent.equalsIgnoreCase(listeEtudiant.get(i).getEmail()))
					{
						Etudiantexistant=true;
					}
					else {Etudiantexistant=false;
					i++;}
					}
			//Si referent existant, recuperation de ses infos et creation de la nouvelle commission sinon message erreur
		if(Etudiantexistant){
			Integer idEtudiant = Manager.getInstance().getEtudiantMail(mailReferent).getIdEtudiant();
			
			Commission nouvelleCommission = new Commission(null, idEtudiant,idPole, nomAsso, description, logo);
			Manager.getInstance().ajouterCommission(nouvelleCommission);
			response.sendRedirect("espaceResp");
		}else{
			request.setAttribute("ErrorEtudiant", "Il y a une erreur dans votre requette. "
					+ "Veuillez vérifier que le mail de l'étudiant référent a bien été rentré et que l'étudiant a bien créé son profil auparavant.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/ajouterAsso.jsp");
	    	view.forward(request, response);
		}
	}
	}
}	
}
