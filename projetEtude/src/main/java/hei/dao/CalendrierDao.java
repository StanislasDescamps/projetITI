package hei.dao;

import hei.model.Calendrier;

import java.util.List;

public interface CalendrierDao {

	public List<Calendrier> listerCalendrier(); //Liste tous les calendriers de la bdd
	
	public void ajouterCalendrier(Calendrier calendrier); //Ajout d'un nouveau calendrier dans la bdd
	
	public Calendrier getCalendrier(Integer idEtudiant); //Recuperation d'un calendrier a partir de l'identifiant d'un etudiant
}
