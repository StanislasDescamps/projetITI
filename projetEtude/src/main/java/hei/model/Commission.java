package hei.model;

public class Commission {

	private Integer idCommission;
	private Integer idPole;
	private Integer idEtudiant;
	private String nomCommission;
	private String description;
	private String logo;
	
	public Commission(Integer idcommission, Integer idetudiant,Integer idpole , String nom, String description, String logo){
		super();
		this.idCommission = idcommission;
		this.idPole = idpole;
		this.idEtudiant = idetudiant;
		this.nomCommission = nom;
		this.description = description;
		this.logo = logo;
	}

	public Integer getIdcommission() {
		return idCommission;
	}

	public void setIdcommission(Integer idcommission) {
		this.idCommission = idcommission;
	}

	public Integer getIdpole() {
		return idPole;
	}

	public void setIdpole(Integer idpole) {
		this.idPole = idpole;
	}

	public Integer getIdetudiant() {
		return idEtudiant;
	}

	public void setIdetudiant(Integer idetudiant) {
		this.idEtudiant = idetudiant;
	}

	public String getNomCommission() {
		return nomCommission;
	}

	public void setNomCommission(String nomCommission) {
		this.nomCommission = nomCommission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
