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
	                   results.getBoolean("admin"));
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
	                  "INSERT INTO `etudiant`(`idEtudiant`, `nomEtudiant`, `prenomEtudiant`, `password`, `email`, `admin`) VALUES(?, ?, ?, ?, ?, ?)"); 
	        stmt.setInt(1, etudiant.getIdetudiant());
	        stmt.setString(2, etudiant.getNomEtudiant());
	        stmt.setString(3, etudiant.getPrenomEtudiant());
	        stmt.setString(4, etudiant.getPassWord());
	        stmt.setString(5, etudiant.getEmail());
	        stmt.setBoolean(3,etudiant.isAdmin());
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
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
	                    results.getBoolean("admin"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return etudiant;
	}

}
