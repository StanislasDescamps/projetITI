package hei.dao;

import hei.model.Commission;

import java.util.List;

public interface CommissionDao {

	public List<Commission> listerCommission();
	
	public void ajouterCommission(Commission commission);
	
	public Commission getCommission(Integer idCommission);
	
	public Commission getCommissionEvent(Integer idEvenement);
	
	public List<Commission> listerCommissionPole(String nomPole);
	
	public void ajouterChoixCommission(Integer idEtudiant, Integer idCommission);
	
	public List<Commission> listerChoixCommission(Integer idEtudiant);
	
	public void modifierCommission(Integer idCommission, Integer idetudiant,Integer idpole , String nom, String description, String logo);
	
	public void supprimerCommission(Integer idCommission);
	
	public void supprimerChoix(Integer idEtudiant);
}
