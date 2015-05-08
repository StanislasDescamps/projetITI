package hei.dao;

import hei.model.Commission;

import java.util.List;

public interface CommissionDao {

	public List<Commission> listerCommission(); //Liste toutes les commisssions
	
	public Commission getCommissionByIdRef(Integer idEtudiant); //Liste toutes les commisssions dont l'utilisateur est responsable
	
	public void ajouterCommission(Commission commission); //Ajout d'une commission dans la bdd
	
	public Commission getCommission(Integer idCommission); // Recupere la commission a partir de son identifiant
	
	public Commission getCommissionEvent(Integer idEvenement);//Recupere la commission associee a l'identifiant de l'evenement en parametre
	
	public List<Commission> listerCommissionPole(String nomPole); //Liste les commissions associees au pole mis en parametre
	
	public void ajouterChoixCommission(Integer idEtudiant, Integer idCommission); //Ajout d'un choix de commission dans les preferences d'un etudiant
	
	public List<Commission> listerChoixCommission(Integer idEtudiant); // Liste les preferences d'un etudiant
	
	public void modifierCommission(Integer idCommission, Integer idetudiant,Integer idpole , String nom, String description, String logo);//modifie les informations d'une commission
	
	public void supprimerCommission(Integer idCommission);// Supprime une commission 
	
	public void supprimerChoix(Integer idEtudiant); // Supprime toutes les preferences d'un etudiant
	
	public void attribuerNouveauRepComm(Integer idCommission, Integer idEtudiant); //attribue un nouveau responsable a la commission en parametre
}
