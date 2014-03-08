package hei.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calendrier {

	private static DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	
	private Integer idCalendrier;
	private Integer idEtudiant;
	private Date dateEmission;
	private List<Evenement> listEvenement;
	
	public Calendrier(Integer idcalendrier, Integer idetudiant, Date emission){
		
		super();
		this.idCalendrier = idcalendrier;
		this.idEtudiant = idetudiant;
		this.dateEmission = emission;
		
		setListEvenement(new ArrayList<Evenement>());
	}

	public static DateFormat getDateFormat() {
		return dateFormat;
	}

	public static void setDateFormat(DateFormat dateFormat) {
		Calendrier.dateFormat = dateFormat;
	}

	public Integer getIdCalendrier() {
		return idCalendrier;
	}

	public void setIdCalendrier(Integer idCalendrier) {
		this.idCalendrier = idCalendrier;
	}

	public Integer getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Integer idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	public List<Evenement> getListEvenement() {
		return listEvenement;
	}

	public void setListEvenement(List<Evenement> listEvenement) {
		this.listEvenement = listEvenement;
	}
}
