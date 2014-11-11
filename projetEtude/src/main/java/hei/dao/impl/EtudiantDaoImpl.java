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
	    	ResultSet results = stmt.executeQuery("SELECT * FROM etudiant ORDER BY nomEtudiant ASC");
	    while (results.next()) {
	    	Etudiant etudiant = new Etudiant(results.getInt("idEtudiant"), 
	                   results.getString("nomEtudiant"),
	                   results.getString("prenomEtudiant"),
	                   results.getString("password"),
	                   results.getString("email"),
	                   results.getInt("idDroit"),
	                   results.getBoolean("firstConnexion"));
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
	                  "INSERT INTO `etudiant`( `nomEtudiant`, `prenomEtudiant`, `password`, `email`, `idDroit`, `firstConnexion`) VALUES(?, ?, ?, ?, ?, ?)"); 
	        stmt.setString(1, etudiant.getNomEtudiant());
	        stmt.setString(2, etudiant.getPrenomEtudiant());
	        stmt.setString(3, etudiant.getPassWord());
	        stmt.setString(4, etudiant.getEmail());
	        stmt.setInt(5,etudiant.getIdDroit());
	        stmt.setBoolean(6, etudiant.isFirstConnexion());
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
	                    results.getInt("idDroit"),
	                    results.getBoolean("firstConnexion"));
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
	                    results.getInt("idDroit"),
	                    results.getBoolean("firstConnexion"));
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
	                    results.getInt("idDroit"),
	                    results.getBoolean("firstConnexion"));
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
	                    results.getInt("idDroit"),
	                    results.getBoolean("firstConnexion"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return etudiant;
	}

	@Override
	public void firstConnexionSetFalse(Integer idEtudiant) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "UPDATE `etudiant` SET `firstConnexion`= 0 WHERE `idEtudiant`=?");
	       
	        stmt.setInt(1,idEtudiant);	        
	        stmt.executeUpdate();
	        
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void modifierMail(Integer idEtudiant, String mail){
		
		try{
			 Connection connection = 
			            DataSourceProvider.getDataSource().getConnection();

			        // Utiliser la connexion
			        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
			        		"UPDATE etudiant SET email =? WHERE idEtudiant =?");
			  
			        stmt.setString(1,mail);	 
			        stmt.setInt(2,idEtudiant);	        
			        stmt.executeUpdate();
			
		connection.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	@Override
	public void modifierMdP(Integer idEtudiant, String mdp){
		
		try{
			 Connection connection = 
			            DataSourceProvider.getDataSource().getConnection();

			        // Utiliser la connexion
			        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
			        		"UPDATE etudiant SET password =? WHERE idEtudiant =?");
			  
			        stmt.setString(1,mdp);	 
			        stmt.setInt(2,idEtudiant);	        
			        stmt.executeUpdate();
			
		connection.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void setAdmin(Integer idEtudiant, Integer idDroit) {
		
		try{
			 Connection connection = 
			            DataSourceProvider.getDataSource().getConnection();

			        // Utiliser la connexion
			        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
			        		"UPDATE etudiant SET idDroit =? WHERE idEtudiant =?");
			  
			        stmt.setInt(1,idDroit);	 
			        stmt.setInt(2,idEtudiant);	        
			        stmt.executeUpdate();
			
		connection.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	/*@Override
	public void bannirEtudiant(String nom, String prenom, String email, String motif) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `listenoire`( `nomEtudiant`, `prenomEtudiant`, `email`, `motif`) VALUES(?, ?, ?, ?)"); 
	        stmt.setString(1, nom);
	        stmt.setString(2, prenom);
	        stmt.setString(3, email);
	        stmt.setString(4, motif);
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}*/

	@Override
	public void supprimerEtudiant(Integer idEtudiant) {
		try{
			 Connection connection = 
			            DataSourceProvider.getDataSource().getConnection();

			        // Utiliser la connexion
			        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
			        		"DELETE FROM etudiant WHERE idEtudiant =?");
			  
			        stmt.setInt(1,idEtudiant);	 	        
			        stmt.executeUpdate();
			
		connection.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterParticipant(Integer idEvenement, Integer idEtudiant) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `participation`( `idEtudiant`, `idEvenement`) VALUES(?, ?)"); 
	        stmt.setInt(1, idEtudiant);
	        stmt.setInt(2, idEvenement);
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public List<Etudiant> listerParticipant(Integer idEvenement) {
		List<Etudiant> listeParticipant = new ArrayList<Etudiant>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM etudiant INNER JOIN participation ON etudiant.idEtudiant=participation.idEtudiant WHERE participation.idEvenement =? ");
	        
	        stmt.setInt(1, idEvenement);
	        ResultSet results = stmt.executeQuery();
	    while (results.next()) {
	    	Etudiant etudiant = new Etudiant(results.getString("nomEtudiant"),
	                   results.getString("prenomEtudiant"),
	                   results.getString("email"));
	    	listeParticipant.add(etudiant);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeParticipant;
	}

	@Override
	public void supprimerParticipant(Integer idEvenement, Integer idEtudiant) {
		try{
			 Connection connection = 
			            DataSourceProvider.getDataSource().getConnection();

			        // Utiliser la connexion
			        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
			        		"DELETE FROM participation WHERE idEtudiant =? AND idEvenement=?");
			  
			        stmt.setInt(1,idEtudiant);
			        stmt.setInt(2,idEvenement);
			        stmt.executeUpdate();
			
		connection.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
}
