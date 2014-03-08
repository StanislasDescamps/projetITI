package hei.model;

import java.util.ArrayList;
import java.util.List;

public class Pole {

	private Integer idPole;
	private Integer idEtudiant;
	private String nomPole;
	
	private List<Commission> listCommission;
	
	public Pole(Integer idpole, Integer idetudiant, String nom){
		super();
		this.idPole=idpole;
		this.idEtudiant=idetudiant;
		this.nomPole=nom;
		
		listCommission= new ArrayList<Commission>();
	}

	public Integer getIdPole() {
		return idPole;
	}

	public void setIdPole(Integer idPole) {
		this.idPole = idPole;
	}

	public Integer getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Integer idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNomPole() {
		return nomPole;
	}

	public void setNomPole(String nomPole) {
		this.nomPole = nomPole;
	}

	public List<Commission> getListCommission() {
		return listCommission;
	}

	public void setListCommission(List<Commission> listCommission) {
		this.listCommission = listCommission;
	}
}
