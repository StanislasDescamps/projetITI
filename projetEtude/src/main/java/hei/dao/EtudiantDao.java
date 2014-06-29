package hei.dao;

import hei.model.Etudiant;

import java.util.List;

public interface EtudiantDao {

	public List<Etudiant> listerEtudiant();//liste tous les étudiants de la bdd
	
	public void ajouterEtudiant(Etudiant etudiant); //ajout d'un étudiant à la bdd
	
	public void firstConnexionSetFalse(Integer idEtudiant); //Modifie le statut de connexion de l'étudiant
	
	public Etudiant getEtudiant(Integer idEtudiant); //Récupère les informations d'un étudiant à partir de son identifiant
	
	public Etudiant getEtudiantMail(String mailEtudiant);//Récupère les informations d'un étudiant à partir de son mail
	
	public boolean etudiantExiste(String mail, String password); //Vérifie l'existance du doublet (mail, mot de passe) dans la bdd
	
	public Etudiant getEtudiantResp(Integer idCommission);//Récupère les informations d'un étudiant responsable de la commission dont l'identifiant est en paramètre
	
	public Etudiant getEtudiantNomPrenom(String nom, String prenom); //Récupère les informations d'un étudiant à partir de ses nom prenom
	
	public void modifierMail(Integer idEtudiant, String mail); //permet de modifier le mail de l'utilisateur

	public void modifierMdP(Integer idEtudiant, String mdp); //permet de modifier le mot de passe de l'utilisateur
}
