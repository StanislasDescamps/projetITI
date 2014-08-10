package hei.model;

public class Etudiant {

	private Integer idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private String passWord;
	private String email;
	private Integer idDroit;
	private String motif;
	private boolean firstConnexion;
	
	public Etudiant(Integer idetudiant, String nom, String prenom, String motdepass, String email, Integer iddroit, boolean first){
		
		super();
		this.idEtudiant = idetudiant;
		this.nomEtudiant = nom;
		this.prenomEtudiant = prenom;
		this.passWord = motdepass;
		this.email = email;
		this.idDroit  =iddroit;
		this.firstConnexion=first;
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
	public Etudiant(String nom, String prenom, String email, String motif){
		this.nomEtudiant = nom;
		this.prenomEtudiant = prenom;
		this.email = email;
		this.motif = motif;
	}

	public Integer getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Integer idEtudiant) {
		this.idEtudiant = idEtudiant;
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

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public boolean isFirstConnexion() {
		return firstConnexion;
	}

	public void setFirstConnexion(boolean firstConnexion) {
		this.firstConnexion = firstConnexion;
	}
}
