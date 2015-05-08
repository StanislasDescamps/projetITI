package hei.dao;

import hei.model.Evenement;

import java.util.List;

public interface EvenementDao {

	public List<Evenement> listerEvenement(); //Liste tous les evements de la bdd
	
	public List<Evenement> listerEvenementNonModere(); //Liste tous les evements non moderes de la bdd
	
	public List<Evenement> listerEvenementModere(); //Liste tous les evements moderes de la bdd
	
	public void ajouterEvenement(Evenement evenement); //ajout d'un nouvel evenement
	
	public void modifierEvenement(Integer idEvenement, Integer idCommission, String nomCommission, String nomPole , String titre, String description, String lieu, String dateDebut, String dateFin, String heureDebut, String heureFin);//modifie les informations d'un evenement
	
	public Evenement getEvenement(Integer idEvenement);//Recuperation des informations d'un evenement a partir de son identifiant
	
	public List<Evenement> listerEvenementEtudiant(Integer idEtudiant); //Liste tous les evenements associes aux commissions que l'etudiant, dont l'identifiant est en parametre, a choisi

	public List<Evenement> listerEvenementByCommission(Integer idCommission); //Liste tous les evenements associes a la commissions dont l'identifiant est en parametre
	
	public Evenement getEvenementByDate(String dateDebut); //Recuperation des information d'un evement a partir de sa date

	public void supprimerEvenement(Integer idEvenement); //Supprime l'evenement dont l'id est en parametre

	public void setModeration(Integer idEvenement); //Permet la moderation de l'evenement dont l'id est en parametre
	
	public void setUnModeration(Integer idEvenement); //Permet de retirer la moderation de l'evenement dont l'id est en parametre

	public List<Integer> listerEvenementParticipationByUser(Integer idEtudiant); //Permet de recuperer tous les indentifiants auxquel participe l'utilisateur
}
