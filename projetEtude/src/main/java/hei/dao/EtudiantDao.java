package hei.dao;

import hei.model.Etudiant;

import java.util.List;

public interface EtudiantDao {

	public List<Etudiant> listerEtudiant();//liste tous les etudiants de la bdd
	
	public void ajouterEtudiant(Etudiant etudiant); //ajout d'un etudiant a la bdd
	
	public void firstConnexionSetFalse(Integer idEtudiant); //Modifie le statut de connexion de l'etudiant
	
	public Etudiant getEtudiant(Integer idEtudiant); //Recupere les informations d'un etudiant a partir de son identifiant
	
	public Etudiant getEtudiantMail(String mailEtudiant);//Recupere les informations d'un etudiant a partir de son mail
	
	public boolean etudiantExiste(String mail, String password); //Verifie l'existance du doublet (mail, mot de passe) dans la bdd
	
	public Etudiant getEtudiantResp(Integer idCommission);//Recupere les informations d'un etudiant responsable de la commission dont l'identifiant est en parametre
	
	public Etudiant getEtudiantNomPrenom(String nom, String prenom); //Recupere les informations d'un etudiant a partir de ses nom prenom
	
	public void modifierMail(Integer idEtudiant, String mail); //permet de modifier le mail de l'utilisateur

	public void modifierMdP(Integer idEtudiant, String mdp); //permet de modifier le mot de passe de l'utilisateur

	public void setAdmin(Integer idEtudiant, Integer idDroit); //permet de changer les droits utilisateur

	//public void bannirEtudiant(String nom, String prenom, String email, String motif); //permet de bannir un utilisateur

	public void supprimerEtudiant(Integer idEtudiant); //permet de supprimer un utilisateur de la BDD

	public void ajouterParticipant(Integer idEvenement, Integer idEtudiant); //ajoute un participant a un evenement 
	
	public void supprimerParticipant(Integer idEvenement, Integer idEtudiant); //retire la participation de l'etudiant a un evenement 

	public List<Etudiant> listerParticipant(Integer idEvenement);//liste tous les participants de l'evenement en parametre
}
