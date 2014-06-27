package hei.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import hei.dao.EtudiantDao;
import hei.model.Etudiant;

public class EtudiantDaoImpl implements EtudiantDao {

	public List<Etudiant> listerEtudiant() {
		List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM etudiant");
	    while (results.next()) {
	    	Etudiant etudiant = new Etudiant(results.getInt("idEtudiant"), 
	                   results.getString("nomEtudiant"),
	                   results.getString("prenomEtudiant"),
	                   results.getString("password"),
	                   results.getString("email"),
	                   results.getInt("idDroit"));
	    	listeEtudiant.add(etudiant);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeEtudiant;
	}

	public void ajouterEtudiant(Etudiant etudiant) {
		
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `etudiant`( `nomEtudiant`, `prenomEtudiant`, `password`, `email`, `admin`) VALUES(?, ?, ?, ?, ?)"); 
	        stmt.setString(1, etudiant.getNomEtudiant());
	        stmt.setString(2, etudiant.getPrenomEtudiant());
	        stmt.setString(3, etudiant.getPassWord());
	        stmt.setString(4, etudiant.getEmail());
	        stmt.setInt(5,etudiant.getIdDroit());
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	public boolean etudiantExiste(String mail, String password) {

		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();

// Utiliser la connexion
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM `etudiant` WHERE `email`=? and `password`=?");
			stmt.setString(1, mail);
			stmt.setString(2, password);

			ResultSet results = stmt.executeQuery();
            	if (results.first())
            	{
            		return true;
            	}
            
        	// Fermer la connexion
            	connection.close();
            } catch (SQLException e) {
            e.printStackTrace();
            }
            return false;
}
	
	public Etudiant getEtudiant(Integer idEtudiant) {
		Etudiant etudiant= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM etudiant WHERE idEtudiant =? ");
	        
	        stmt.setInt(1, idEtudiant);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	etudiant = new Etudiant(results.getInt("idEtudiant"),
	                    results.getString("nomEtudiant"),
	                    results.getString("prenomEtudiant"),
	                    results.getString("password"),
	                    results.getString("email"),
	                    results.getInt("idDroit"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return etudiant;
	}
	public Etudiant getEtudiantMail(String mailEtudiant) {
		Etudiant etudiant= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM etudiant WHERE email =? ");
	        
	        stmt.setString(1, mailEtudiant);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	etudiant = new Etudiant(results.getInt("idEtudiant"),
	                    results.getString("nomEtudiant"),
	                    results.getString("prenomEtudiant"),
	                    results.getString("password"),
	                    results.getString("email"),
	                    results.getInt("idDroit"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return etudiant;
	}

	@Override
	public Etudiant getEtudiantResp(Integer idCommission) {
		Etudiant etudiant= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM etudiant INNER JOIN commission ON etudiant.idEtudiant=commission.idEtudiant WHERE idCommission=? ");
	        
	        stmt.setInt(1, idCommission);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	etudiant = new Etudiant(results.getInt("idEtudiant"),
	                    results.getString("nomEtudiant"),
	                    results.getString("prenomEtudiant"),
	                    results.getString("password"),
	                    results.getString("email"),
	                    results.getInt("idDroit"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return etudiant;
	}

	@Override
	public Etudiant getEtudiantNomPrenom(String nom, String prenom) {
		Etudiant etudiant= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM etudiant WHERE nom =? AND prenom=?");
	        
	        stmt.setString(1, nom);
	        stmt.setString(2, prenom);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	etudiant = new Etudiant(results.getInt("idEtudiant"),
	                    results.getString("nomEtudiant"),
	                    results.getString("prenomEtudiant"),
	                    results.getString("password"),
	                    results.getString("email"),
	                    results.getInt("idDroit"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return etudiant;
	}
}
