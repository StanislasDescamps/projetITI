package hei.metier;


import java.util.List;

import hei.dao.CalendrierDao;
import hei.dao.CommissionDao;
import hei.dao.EtudiantDao;
import hei.dao.EvenementDao;
import hei.dao.PoleDao;
import hei.dao.impl.CalendrierDaoImpl;
import hei.dao.impl.CommissionDaoImpl;
import hei.dao.impl.EtudiantDaoImpl;
import hei.dao.impl.EvenementDaoImpl;
import hei.dao.impl.PoleDaoImpl;
import hei.metier.Manager;
import hei.model.Calendrier;
import hei.model.Commission;
import hei.model.Etudiant;
import hei.model.Evenement;
import hei.model.Pole;

public class Manager {

	private static Manager instance;
	
	private CommissionDao commissionDao = (CommissionDao) new CommissionDaoImpl();
	private EtudiantDao etudiantDao = (EtudiantDao) new EtudiantDaoImpl();
	private PoleDao poleDao = (PoleDao) new PoleDaoImpl();
	private CalendrierDao calendrierDao = (CalendrierDao) new CalendrierDaoImpl();
	private EvenementDao evenementDao = (EvenementDao) new EvenementDaoImpl();
	
	
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	// Etudiant
	public List<Etudiant> listerEtudiant() {
		return etudiantDao.listerEtudiant();
	}
	public void ajouterEtudiant(Etudiant etudiant) {
		etudiantDao.ajouterEtudiant(etudiant);
	}
	public Etudiant getEtudiant(String mailEtudiant){
		return etudiantDao.getEtudiant(mailEtudiant);
	}
	
	// Pole
	public List<Pole> listerPole() {
		return poleDao.listerPole();
	}
	public Pole getPoleEvent(Integer idEvenement){
		return poleDao.getPoleEvent(idEvenement);
	}
	
	//Evenement
	public List<Evenement> listerEvenement() {
		return evenementDao.listerEvenement();
	}
	public List<Evenement> listerEvenementEtudiant(Integer idEtudiant) {
		return evenementDao.listerEvenementEtudiant(idEtudiant);
	}
	
	//Commission
	public List<Commission> listerCommission() {
		return commissionDao.listerCommission();
	}
	public Commission getCommissionEvent(Integer idEvenement){
		return commissionDao.getCommissionEvent(idEvenement);
	}
	public List<Commission> listerCommissionPole(String nomPole){
		return commissionDao.listerCommissionPole(nomPole);
	}
	
	//Calendrier
	public List<Calendrier> listerCalendrier() {
		return calendrierDao.listerCalendrier();
	}
	
}
