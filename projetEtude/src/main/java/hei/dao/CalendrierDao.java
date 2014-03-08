package hei.dao;

import hei.model.Calendrier;

import java.util.List;

public interface CalendrierDao {

	public List<Calendrier> listerCalendrier();
	
	public void ajouterCalendrier(Calendrier calendrier);
	
	public Calendrier getCalendrier(Integer idEtudiant);
}
