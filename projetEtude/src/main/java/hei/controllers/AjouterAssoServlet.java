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

public class AjouterAssoServlet extends HttpServlet{

	private static final long serialVersionUID = -9077684945660855800L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/ajouterAsso.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		List<Etudiant> listeEtudiant = Manager.getInstance().listerEtudiant();
		List<Commission> listeCommission=Manager.getInstance().listerCommission();
		
		String nomAsso = request.getParameter("nomAsso");
		String mailReferent = request.getParameter("referent");
		String logo = request.getParameter("logo");
		String pole = request.getParameter("bureau");
		String description = request.getParameter("description");
		
		boolean Etudiantexistant =false;
		boolean Commexistante = false;
		int i =0;
		int j =0;
		
		while(Commexistante == false && j<listeCommission.size())
		{
			if(nomAsso.toLowerCase().equalsIgnoreCase(listeCommission.get(j).getNomCommission().toLowerCase()))
			{
				Commexistante = true;
				request.setAttribute("ErrorComm", "Il y a une erreur dans votre requette. Veuillez vérifier que la commission n'existe pas déjà. Si le problème persiste, voyez avec la maintenance");
			}
			else{j++;}
		}	
		
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
			
		if(Etudiantexistant){
			Integer idEtudiant = Manager.getInstance().getEtudiantMail(mailReferent).getIdetudiant();
			Integer idPole = Manager.getInstance().getPolebyNom(pole).getIdPole();
			
			Commission nouvelleCommission = new Commission(null, idEtudiant,idPole, nomAsso, description, logo);
			Manager.getInstance().ajouterCommission(nouvelleCommission);
			response.sendRedirect("mesOptions");
		}else{
			request.setAttribute("ErrorEtudiant", "Il y a une erreur dans votre requette. Veuillez vérifier que le mail de l'étudiant référent a bien été rentré et que l'étudiant a bien créé son profil auparavant.");
		}
	}
}	
}
