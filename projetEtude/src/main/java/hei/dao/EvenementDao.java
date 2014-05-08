package hei.dao;

import hei.model.Evenement;
import java.util.List;

public interface EvenementDao {

	public List<Evenement> listerEvenement(); //Liste tous les évéments de la bdd
	
	public void ajouterEvenement(Evenement evenement); //ajout d'un nouvel événement..fonction non utilisé mais déjà créer en prevision
	
	public Evenement getEvenement(Integer idEvenement);//Récupération des informations d'un événement à partir de son identifiant
	
	public List<Evenement> listerEvenementEtudiant(Integer idEtudiant); //Liste tous les événements associés aux commissions que l'étudiant, dont l'identifiant est en paramètre, a choisi

	public Evenement getEvenementByDate(String dateDebut); //Récupération des information d'un évément à partir de sa date
}
