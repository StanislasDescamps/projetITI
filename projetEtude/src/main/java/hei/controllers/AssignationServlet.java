package hei.controllers;

import hei.metier.Manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class AssignationServlet extends HttpServlet{

	private static final long serialVersionUID = -1473788236491752870L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation des informations personnelles de l'etudiant
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		Integer idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
		Integer droitEtudiant = Manager.getInstance().getEtudiant(idEtudiant).getIdDroit();
		
		if(statut==3){	
			if(droitEtudiant==2){
				Gson gson = new Gson();
				//Envoi de l'id du pole dont l'etudiant est responsable
				String json = gson.toJson(Manager.getInstance().getPoleByResp(idEtudiant).getIdPole());
				PrintWriter out = response.getWriter();
				out.append(json);
			}else if(droitEtudiant==1){
				Gson gson = new Gson();
				//Envoi de l'id de la commission dont l'etudiant est responsable
				String json = gson.toJson(Manager.getInstance().getCommissionByIdRef(idEtudiant).getIdcommission());
				PrintWriter out = response.getWriter();
				out.append(json);
			}else{
				Gson gson = new Gson();
				//Envoi d'un signe pour dire que l'etudiant n'est pas responsable
				String json = gson.toJson("rien");
				PrintWriter out = response.getWriter();
				out.append(json);
			}
		}else{
			response.sendRedirect("redirection");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recuperation du statut de l'utilisateur connecte
		HttpSession session = request.getSession(true);
		Integer statut = (Integer) session.getAttribute("idDroit");
		
		if(statut==3){
			//Recuperation de l'identifiant de l'utilisateur selectionne
			Integer idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
			Integer idDroit = Integer.parseInt(request.getParameter("droits"));
			
			if(idDroit==1){
				Integer idComm = Integer.parseInt(request.getParameter("assignation"));
				Integer idOldRef = Manager.getInstance().getCommission(idComm).getIdetudiant();
				Manager.getInstance().setAdmin(idEtudiant, idDroit);
				Manager.getInstance().setAdmin(idOldRef, 0);
				Manager.getInstance().attribuerNouveauRepComm(idComm, idEtudiant);				
			}else if(idDroit==2){
				Integer idPole = Integer.parseInt(request.getParameter("assignation"));
				Integer idOldRef = Manager.getInstance().getPole(idPole).getIdEtudiant();
				Manager.getInstance().setAdmin(idEtudiant, idDroit);
				Manager.getInstance().setAdmin(idOldRef, 0);
				Manager.getInstance().attribuerNouveauRepPole(idPole, idEtudiant);	
			}else if(idDroit==0 || idDroit==3){
				Manager.getInstance().setAdmin(idEtudiant, idDroit);
			}
		}else{
			response.sendRedirect("redirection");
		}
	}
}
