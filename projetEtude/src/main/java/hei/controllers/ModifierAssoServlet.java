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
		
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		Commission commission = Manager.getInstance().getCommission(idCommission);
		request.setAttribute("commission",commission);
		
		Etudiant etudiant=Manager.getInstance().getEtudiantResp(idCommission);
		request.setAttribute("etudiant", etudiant);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/modifierAsso.jsp");
		view.forward(request, response);
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idCommission = Integer.parseInt(request.getParameter("idcommission"));
		
		List<Etudiant> listeetudiant = Manager.getInstance().listerEtudiant();
		
		String nom = request.getParameter("nomAsso");
		
		
		String mailResp = request.getParameter("mailResp");
		Etudiant etudiant = Manager.getInstance().getEtudiantMail(mailResp);
		
		Integer idpole = Integer.parseInt(request.getParameter("bureau"));
		String description = request.getParameter("description");
		String logo = request.getParameter("logo");
		
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
	
if(Etudiantexistant){
		
		Manager.getInstance().modifierCommission(idCommission, etudiant.getIdetudiant(), idpole, nom, description, logo);
		response.sendRedirect("presentationAsso?idcommission=" + idCommission);}
else{
	request.setAttribute("ErrorEtudiant2", "Il y a une erreur dans votre requette. Veuillez vérifier que le mail de l'étudiant référent a bien été rentré et que l'étudiant a bien créé son profil auparavant.");
	}

	}
}
