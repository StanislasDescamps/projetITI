package hei.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evenement {

	private static DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");
	
	private Integer idEvenement;
	private Integer idCommission;
	private String titreEvent;
	private String descriptionEvent;
	private String lieu;
	private Date dateDebut;
	private Date dateFin;
	
	public Evenement(Integer idevenement, Integer idcommission, String titre, String description, String lieu, Date debut, Date fin){
		super();
		this.idEvenement = idevenement;
		this.idCommission = idcommission;
		this.titreEvent = titre;
		this.descriptionEvent = description;
		this.lieu = lieu;
		this.dateDebut = debut;
		this.dateFin = fin;
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}	
}
