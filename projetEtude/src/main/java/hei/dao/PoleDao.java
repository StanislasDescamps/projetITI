package hei.dao;

import hei.model.Pole;

import java.util.List;

public interface PoleDao {

	public List<Pole> listerPole();//liste tous les poles
	
	public Pole getPole(Integer idPole); //Récupération des informations d'un pole à partir de son identifiant
	
	public Pole getPoleEvent (Integer idEvenement); //Récupération des informations d'un pole à partir de l'identifiant d'un événement auquel il est associé
	
	public Pole getPolebyNom(String nomPole); //Récupération des informations d'un pole à partir de son nom

	public Pole getPoleByResp(Integer idEtudiant); //Récupération des informations d'un pole à partir de son respasable

	public Integer getIdRespPoleByComm(Integer idCommission); //Récupération de l'identifiant du responsable de pole à partir d'une commission
}
