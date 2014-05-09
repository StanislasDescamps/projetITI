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


public class ModifierAssoServlet extends HttpServlet{

	private static final long serialVersionUID = -5846886860056585206L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Récupération de l'identifiant de la commission sélectionnée
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		//Récupération des informations de la commission
		Commission commission = Manager.getInstance().getCommission(idCommission);
		request.setAttribute("commission",commission);
		
		//Récupération des informations de l'étudiant responsable de la commission
		Etudiant etudiant=Manager.getInstance().getEtudiantResp(idCommission);
		request.setAttribute("etudiant", etudiant);
		
		//Affichage de la page jsp
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
		view.forward(request, response);
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idpole2 = null;
		
		//Récupération de l'identifiant de la commission sélectionnée
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		//Récupération de tous les étudiants de la base de données dans une liste
		List<Etudiant> listeetudiant = Manager.getInstance().listerEtudiant();
		
		//Récupération des champs
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
		
		
		//Vérification de l'existance du nouvel etudiant responsable dans la base de données
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
		
		Manager.getInstance().modifierCommission(idCommission, etudiant.getIdetudiant(), idpole2, nom, description, logo);
		response.sendRedirect("presentationAsso?idcommission=" + idCommission);}
else{
	request.setAttribute("ErrorEtudiant2", "Il y a une erreur dans votre requette. Veuillez vérifier que le mail de l'étudiant référent a bien été rentré et que l'étudiant a bien créé son profil auparavant.");
	RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
	view.forward(request, response);
	}

	}
	}
}
