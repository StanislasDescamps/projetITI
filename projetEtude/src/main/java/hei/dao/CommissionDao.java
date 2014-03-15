package hei.dao;

import hei.model.Commission;

import java.util.List;

public interface CommissionDao {

	public List<Commission> listerCommission();
	
	public void ajouterCommission(Commission commission);
	
	public Commission getCommission(Integer idCommission);
	
	public Commission getCommissionEvent(Integer idEvenement);
	
	public List<Commission> listerCommissionPole(String nomPole);
}
