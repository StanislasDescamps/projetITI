package hei.model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evenement {

	private static DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	
	private Integer idEvenement;
	private Integer idCommission;
	private String nomCommission;
	private String nomPole;
	private String titreEvent;
	private String descriptionEvent;
	private String lieu;
	private String dateDebut;
	private String dateFin;
	private String heureDebut;
	private String heureFin;
	private Date debut;
	private Date fin;
	private Time hDebut;
	private Time hFin;
	private String image;
	
	public Evenement(Integer idevenement, Integer idcommission,String nomCommission, String nomPole, String titre, String description, String lieu, String debut, String fin, String hdebut, String hfin, String image){
		super();
		this.idEvenement = idevenement;
		this.idCommission = idcommission;
		this.nomCommission = nomCommission;
		this.nomPole = nomPole;
		this.titreEvent = titre;
		this.descriptionEvent = description;
		this.lieu = lieu;
		this.dateDebut = debut;
		this.dateFin = fin;
		this.heureDebut = hdebut;
		this.heureFin = hfin;
		this.image = image;
	}
	
	public Evenement(Integer idevenement, Integer idcommission,String nomCommission, String nomPole, String titre, String description, String lieu, String debut, String fin, Time hdebut, Time hfin, String image){
		super();
		this.idEvenement = idevenement;
		this.idCommission = idcommission;
		this.nomCommission = nomCommission;
		this.nomPole = nomPole;
		this.titreEvent = titre;
		this.descriptionEvent = description;
		this.lieu = lieu;
		this.dateDebut = debut;
		this.dateFin = fin;
		this.hDebut = hdebut;
		this.hFin = hfin;
		this.image = image;
	}
	
	public Evenement(Integer idevenement, Integer idcommission,String nomCommission, String nomPole, String titre, String description, String lieu, Date debut, Date fin, Time hdebut, Time hfin, String image){
		super();
		this.idEvenement = idevenement;
		this.idCommission = idcommission;
		this.nomCommission = nomCommission;
		this.nomPole = nomPole;
		this.titreEvent = titre;
		this.descriptionEvent = description;
		this.lieu = lieu;
		this.debut = debut;
		this.fin = fin;
		this.hDebut = hdebut;
		this.hFin = hfin;
		this.image = image;
	}
	
	public static DateFormat getDateFormat() {
		return dateFormat;
	}
	public static void setDateFormat(DateFormat dateFormat) {
		Evenement.dateFormat = dateFormat;
	}
	public Integer getIdEvenement() {
		return idEvenement;
	}
	public void setIdEvenement(Integer idEvenement) {
		this.idEvenement = idEvenement;
	}
	public Integer getIdCommission() {
		return idCommission;
	}
	public void setIdCommission(Integer idCommission) {
		this.idCommission = idCommission;
	}
	public String getNomCommission() {
		return nomCommission;
	}
	public void setNomCommission(String nomCommission) {
		this.nomCommission = nomCommission;
	}
	public String getNomPole() {
		return nomPole;
	}
	public void setNomPole(String nomPole) {
		this.nomPole = nomPole;
	}
	public String getTitreEvent() {
		return titreEvent;
	}
	public void setTitreEvent(String titreEvent) {
		this.titreEvent = titreEvent;
	}
	public String getDescriptionEvent() {
		return descriptionEvent;
	}
	public void setDescriptionEvent(String descriptionEvent) {
		this.descriptionEvent = descriptionEvent;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public Time gethDebut() {
		return hDebut;
	}
	public void sethDebut(Time hDebut) {
		this.hDebut = hDebut;
	}
	public Time gethFin() {
		return hFin;
	}
	public void sethFin(Time hFin) {
		this.hFin = hFin;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
