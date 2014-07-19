package hei.dao;

import hei.model.Commission;

import java.util.List;

public interface CommissionDao {

	public List<Commission> listerCommission(); //Liste toutes les commisssions
	
	public Commission getCommissionByIdRef(Integer idEtudiant); //Liste toutes les commisssions dont l'utilisateur est responsable
	
	public void ajouterCommission(Commission commission); //Ajout d'une commission dans la bdd
	
	public Commission getCommission(Integer idCommission); // Récupère la commission à partir de son identifiant
	
	public Commission getCommissionEvent(Integer idEvenement);//Récupère la commission associée à l'identifiant de l'événement en paramètre
	
	public List<Commission> listerCommissionPole(String nomPole); //Liste les commissions associées au pole mis en paramètre
	
	public void ajouterChoixCommission(Integer idEtudiant, Integer idCommission); //Ajout d'un choix de commission dans les préférences d'un étudiant
	
	public List<Commission> listerChoixCommission(Integer idEtudiant); // Liste les préférences d'un étudiant
	
	public void modifierCommission(Integer idCommission, Integer idetudiant,Integer idpole , String nom, String description, String logo);//modifie les informations d'une commission
	
	public void supprimerCommission(Integer idCommission);// Supprime une commission 
	
	public void supprimerChoix(Integer idEtudiant); // Supprime toutes les préférences d'un étudiant
}
