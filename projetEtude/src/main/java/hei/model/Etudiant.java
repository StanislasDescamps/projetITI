package hei.model;

public class Etudiant {

	private Integer idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private String passWord;
	private String email;
	private Integer idDroit;
	
	public Etudiant(Integer idetudiant, String nom, String prenom, String motdepass, String email, Integer iddroit){
		
		super();
		this.idEtudiant = idetudiant;
		this.nomEtudiant = nom;
		this.prenomEtudiant = prenom;
		this.passWord = motdepass;
		this.email = email;
		this.setIdDroit(iddroit);
	}
	
	public Etudiant(Integer idetudiant, String nom, String prenom, String email, Integer iddroit){
		this.idEtudiant = idetudiant;
		this.nomEtudiant = nom;
		this.prenomEtudiant = prenom;
		this.email = email;
		this.idDroit = iddroit;
	}
	public Etudiant(String email, String password){
		this.email = email;
		this.passWord = password;
	}
	
	public Integer getIdetudiant() {
		return idEtudiant;
	}
	public void setIdetudiant(Integer idetudiant) {
		this.idEtudiant = idetudiant;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdDroit() {
		return idDroit;
	}

	public void setIdDroit(Integer idDroit) {
		this.idDroit = idDroit;
	}
	
}
