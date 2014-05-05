package hei.dao;

import hei.model.Evenement;
import java.util.List;

public interface EvenementDao {

	public List<Evenement> listerEvenement();
	
	// public void ajouterEvenement(Evenement evenement);
	
	public Evenement getEvenement(Integer idEvenement);
	
	public List<Evenement> listerEvenementEtudiant(Integer idEtudiant);

	public Evenement getEvenementByDate(String dateDebut);
}
