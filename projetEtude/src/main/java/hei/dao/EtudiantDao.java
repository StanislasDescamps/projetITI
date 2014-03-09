package hei.dao;

import hei.model.Etudiant;

import java.util.List;

public interface EtudiantDao {

	public List<Etudiant> listerEtudiant();
	
	public void ajouterEtudiant(Etudiant etudiant);
	
	public Etudiant getEtudiant(Integer idEtudiant);
	
	public Etudiant getEtudiant(String mailEtudiant);
}
