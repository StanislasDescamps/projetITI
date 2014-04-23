package hei.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evenement {

	private static DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");
	
	private Integer idEvenement;
	private Integer idCommission;
	private String nomCommission;
	private String nomPole;
	private String titreEvent;
	private String descriptionEvent;
	private String lieu;
	private Date dateDebut;
	private Date dateFin;
	private String image;
	
	public Evenement(Integer idevenement, Integer idcommission,String nomCommission, String nomPole, String titre, String description, String lieu, Date debut, Date fin, String image){
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
}
