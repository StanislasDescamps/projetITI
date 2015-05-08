package hei.dao;

import hei.model.Pole;

import java.util.List;

public interface PoleDao {

	public List<Pole> listerPole();//liste tous les poles
	
	public Pole getPole(Integer idPole); //Recuperation des informations d'un pole a partir de son identifiant
	
	public Pole getPoleEvent (Integer idEvenement); //Recuperation des informations d'un pole a partir de l'identifiant d'un evenement auquel il est associe
	
	public Pole getPolebyNom(String nomPole); //Recuperation des informations d'un pole a partir de son nom

	public Pole getPoleByResp(Integer idEtudiant); //Recuperation des informations d'un pole a partir de son respasable

	public Integer getIdRespPoleByComm(Integer idCommission); //Recuperation de l'identifiant du responsable de pole a partir d'une commission

	public void attribuerNouveauRepPole(Integer idPole, Integer idEtudiant); //attribue un nouveau responsable au pole en parametre
}
