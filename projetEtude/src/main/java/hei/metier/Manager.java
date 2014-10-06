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
	public void modifierMail(Integer idEtudiant, String mail) {
		etudiantDao.modifierMail(idEtudiant,mail);
	}
	public void modifierMdP(Integer idEtudiant, String mdp) {
		etudiantDao.modifierMdP(idEtudiant,mdp);
	}
	public void firstConnexionSetFalse(Integer idEtudiant) {
		etudiantDao.firstConnexionSetFalse(idEtudiant);
	}
	public void setAdmin(Integer idEtudiant, Integer idDroit) {
		etudiantDao.setAdmin(idEtudiant,idDroit);
	}
	public Etudiant getEtudiant(Integer idEtudiant){
		return etudiantDao.getEtudiant(idEtudiant);
	}
	public Etudiant getEtudiantMail(String mailEtudiant){
		return etudiantDao.getEtudiantMail(mailEtudiant);
	}
	public boolean etudiantExiste(String mail, String password){
		return etudiantDao.etudiantExiste(mail, password);
	}
	public Etudiant getEtudiantResp(Integer idCommission){
		return etudiantDao.getEtudiantResp(idCommission);
	}
	public Etudiant getEtudiantNomPrenom(String nom, String prenom ){
		return etudiantDao.getEtudiantNomPrenom(nom, prenom);
	}
	// Pole
	public List<Pole> listerPole() {
		return poleDao.listerPole();
	}
	public Pole getPole(Integer idPole){
		return poleDao.getPole(idPole);
	}
	public Pole getPoleEvent(Integer idEvenement){
		return poleDao.getPoleEvent(idEvenement);
	}
	public Pole getPolebyNom(String nomPole){
		return poleDao.getPolebyNom(nomPole);
	}
	public Pole getPoleByResp(Integer idEtudiant){
		return poleDao.getPoleByResp(idEtudiant);
	}
	public Integer getIdRespPoleByComm(Integer idCommission){
		return poleDao.getIdRespPoleByComm(idCommission);
	}
	
	//Evenement
	public List<Evenement> listerEvenement() {
		return evenementDao.listerEvenement();
	}
	public void ajouterEvenement(Evenement evenement){
		evenementDao.ajouterEvenement(evenement);
	}
	public void modifierEvenement(Integer idEvenement, Integer idCommission, String nomCommission, String nomPole, String nomEvent, String description, String lieu, String dateDebut, String dateFin, String heureDebut, String heureFin){
	evenementDao.modifierEvenement(idEvenement, idCommission,nomCommission,nomPole, nomEvent, description, lieu, dateDebut, dateFin, heureDebut, heureFin);
	}
	public void supprimerEvenement(Integer idEvenement){
		evenementDao.supprimerEvenement(idEvenement);
	}
	public List<Evenement> listerEvenementEtudiant(Integer idEtudiant) {
		return evenementDao.listerEvenementEtudiant(idEtudiant);
	}
	public List<Evenement> listerEvenementByCommission(Integer idCommission) {
		return evenementDao.listerEvenementByCommission(idCommission);
	}
	public Evenement getEvenement(Integer idEvenement){
		return evenementDao.getEvenement(idEvenement);
	}
	public Evenement getEvenementByDate(String dateDebut) {
		return evenementDao.getEvenementByDate(dateDebut);
	}
	
	//Commission
	public List<Commission> listerCommission() {
		return commissionDao.listerCommission();
	}
	public Commission getCommission(Integer idCommission){
		return commissionDao.getCommission(idCommission);
	}
	public Commission getCommissionEvent(Integer idEvenement){
		return commissionDao.getCommissionEvent(idEvenement);
	}
	public List<Commission> listerCommissionPole(String nomPole){
		return commissionDao.listerCommissionPole(nomPole);
	}
	public void ajouterCommission(Commission commission){
		commissionDao.ajouterCommission(commission);
	}
	public void ajouterChoixCommission(Integer idEtudiant, Integer idCommission){
		commissionDao.ajouterChoixCommission(idEtudiant,idCommission);
	}
	public List<Commission> listerChoixCommission(Integer idEtudiant) {
		return commissionDao.listerChoixCommission(idEtudiant);
	}
	public Commission getCommissionByIdRef(Integer idEtudiant) {
		return commissionDao.getCommissionByIdRef(idEtudiant);
	}
	public void modifierCommission(Integer idCommission, Integer idetudiant,Integer idpole , String nom, String description, String logo){
		commissionDao.modifierCommission(idCommission, idetudiant, idpole ,  nom,  description,  logo);
	}
	public void supprimerCommission(Integer idCommission){
		commissionDao.supprimerCommission(idCommission);
	}
	public void supprimerChoix(Integer idEtudiant){
		commissionDao.supprimerChoix(idEtudiant);
	}
	
	//Calendrier
	public List<Calendrier> listerCalendrier() {
		return calendrierDao.listerCalendrier();
	}
	public void ajouterCalendrier(Calendrier calendrier) {
		calendrierDao.ajouterCalendrier(calendrier);
	}
	
}
