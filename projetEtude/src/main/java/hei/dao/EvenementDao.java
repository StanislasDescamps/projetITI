package hei.dao;

import hei.model.Evenement;

import java.util.List;

public interface EvenementDao {

	public List<Evenement> listerEvenement(); //Liste tous les évéments de la bdd
	
	public void ajouterEvenement(Evenement evenement); //ajout d'un nouvel événement
	
	public void modifierEvenement(Integer idEvenement, Integer idCommission, String nomCommission, String nomPole , String titre, String description, String lieu, String dateDebut, String dateFin, String heureDebut, String heureFin);//modifie les informations d'un evenement
	
	public Evenement getEvenement(Integer idEvenement);//Récupération des informations d'un événement à partir de son identifiant
	
	public List<Evenement> listerEvenementEtudiant(Integer idEtudiant); //Liste tous les événements associés aux commissions que l'étudiant, dont l'identifiant est en paramètre, a choisi

	public List<Evenement> listerEvenementByCommission(Integer idCommission); //Liste tous les événements associés à la commissions dont l'identifiant est en paramètre
	
	public Evenement getEvenementByDate(String dateDebut); //Récupération des information d'un évément à partir de sa date

	public void supprimerEvenement(Integer idEvenement); //Supprime l'évènement dont l'id est en parametre
}
