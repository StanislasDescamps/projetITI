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

public class AjouterEventServlet extends HttpServlet {

	private static final long serialVersionUID = -7106182673264704660L;
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			//Récupération du statut de l'utilisateur connecté
			HttpSession session = request.getSession(true);
			Integer statut = (Integer) session.getAttribute("idDroit");
			Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
			//request.setAttribute("statut", statut);
			
			if(statut==2){
				request.setAttribute("menuOption","menuAdmin.jsp");
			}else if(statut==1){
				request.setAttribute("menuOption","menuResp.jsp");
			}else{
				request.setAttribute("menuOption","menuOption.jsp");
			}
			
			Commission maComm = Manager.getInstance().getCommissionByIdRef(idEtudiant);
			request.setAttribute("commission", maComm);
			
			//Affichage de la page ajouterAsso.jsp
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/ajouterEvent.jsp");
			view.forward(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			//Récupération des informations personnelles de l'étudiant
			HttpSession session = request.getSession(true);
			Integer idEtudiant = (Integer) session.getAttribute("idEtudiant");
			Commission maCommission=Manager.getInstance().getCommissionByIdRef(idEtudiant);
			
			
			
			//Récupération des listes de tous les evenements 
			List<Evenement> listeEvenement = Manager.getInstance().listerEvenement();
			
			//Récupération des champs			
			String nomEvent = request.getParameter("nomEvent");
			String dateDebut=request.getParameter("dateDebut");
			String heureDebut=request.getParameter("heureDebut");
			String dateFin=request.getParameter("dateFin");
			String heureFin=request.getParameter("heureFin");
			String lieu = request.getParameter("lieu");
			String description = request.getParameter("description");
			
			boolean eventExist =false;
			int i =0;
			
					
			//Vérification de l'inexistance de l'évènement
			while(eventExist == false && i<listeEvenement.size())
			{
				if(nomEvent.toLowerCase().equals(listeEvenement.get(i).getTitreEvent().toLowerCase()) && dateDebut.equals(listeEvenement.get(i).getDateDebut()) && heureDebut.equals(listeEvenement.get(i).getHeureDebut()))
				{
					eventExist = true;
					request.setAttribute("ErrorEvent", "Il y a une erreur dans votre requette. Veuillez vérifier que l'évènement n'existe pas déjà. Si le problème persiste, voyez avec la maintenance");
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/ajouterEvent.jsp");
				   	view.forward(request, response);
				}
				else{
					i++;
				}
			}	
			/*if(dateFin.equals("")){
				dateFin=dateDebut;
			}
			if(heureFin.equals("")){
				addAnHour(heureFin);
			}*/
			if(lieu.equals("")){
				lieu="Non renseigné";
			}
			
			if(dateDebut.compareTo(dateFin)<=0){
				
				if(dateDebut.compareTo(dateFin)!=0 && heureDebut.compareTo(heureFin)>=0){
					Integer idCommission=maCommission.getIdcommission();
					String nomCommission=maCommission.getNomCommission();
					String logo=maCommission.getLogo();
					Integer idPole= maCommission.getIdpole();
					Pole poleAssocie=Manager.getInstance().getPole(idPole);
					String nomPole=poleAssocie.getNomPole();
					
					Evenement nouvelEvenement = new Evenement(null, idCommission,nomCommission,nomPole, nomEvent, description, lieu, dateDebut, dateFin, heureDebut, heureFin,logo);
					Manager.getInstance().ajouterEvenement(nouvelEvenement);
					response.sendRedirect("espacePresident");	
				}else{
					request.setAttribute("ErrorTime", "Il y a une erreur dans votre requette. Veuillez vérifier que l'heure de fin soit bien plus tard que l'heure de début de l'évènement.");
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/ajouterEvent.jsp");
				   	view.forward(request, response);
				}
			}else{
				request.setAttribute("ErrorDate", "Il y a une erreur dans votre requette. Veuillez vérifier que la date de fin soit bien plus tard que la date de début de l'évènement.");
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/ajouterEvent.jsp");
			   	view.forward(request, response);
			}
					
		}
		
/*	private String addAnHour(String heure){
		
		String h="";
		String reste="";
		
		for(int i=0; i<8;i++){
			if(i<2){	
			h = h + heure.charAt(i);
			}else{
			reste= reste + heure.charAt(i);
			}
		} 
		Integer h1=Integer.parseInt(h) +1;
		
		String newHour=String.valueOf(h1)+reste;
		
		return newHour;
		}*/
	
}
