package hei.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Calendrier {

	private static DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	
	private Integer idCalendrier;
	private Integer idEtudiant;
	private String dateEmission;
	private List<Evenement> listEvenement;
	
	public Calendrier(Integer idcalendrier, Integer idetudiant, String emission){
		
		super();
		this.idCalendrier = idcalendrier;
		this.idEtudiant = idetudiant;
		this.setDateEmission(emission);
		
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

	public List<Evenement> getListEvenement() {
		return listEvenement;
	}

	public void setListEvenement(List<Evenement> listEvenement) {
		this.listEvenement = listEvenement;
	}

	public String getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(String dateEmission) {
		this.dateEmission = dateEmission;
	}
}
