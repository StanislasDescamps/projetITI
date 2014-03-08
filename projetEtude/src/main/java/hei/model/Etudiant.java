package hei.model;

public class Etudiant {

	private Integer idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private String passWord;
	private String email;
	private boolean admin;
	
	public Etudiant(Integer idetudiant, String nom, String prenom, String motdepass, String email, boolean admin){
		
		super();
		this.idEtudiant = idetudiant;
		this.nomEtudiant = nom;
		this.prenomEtudiant = prenom;
		this.passWord = motdepass;
		this.email = email;
		this.admin = admin;
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
