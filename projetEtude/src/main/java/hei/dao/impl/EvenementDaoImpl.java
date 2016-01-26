package hei.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import hei.dao.EvenementDao;
import hei.model.Evenement;

public class EvenementDaoImpl implements EvenementDao {

	public List<Evenement> listerEvenement() {
		
		List<Evenement> listeEvent = new ArrayList<Evenement>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM evenement");
	    while (results.next()) {
	    	Evenement evenement = new Evenement(results.getInt("idEvenement"), 
	                   results.getInt("idCommission"),
	                   results.getString("nomCommission"),
	                   results.getString("nomPole"),
	                   results.getString("titreEvent"),
	                   results.getString("descriptionEvent"),
	                   results.getString("lieuEvent"),
	                   results.getString("dateDebut"),
	                   results.getString("dateFin"),
	                   results.getTime("heureDebut"),
	                   results.getTime("heureFin"),
	                   results.getString("image"),
	                   results.getBoolean("moderation"));
	    	listeEvent.add(evenement);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeEvent;
	}
	
	public List<Evenement> listerEvenementNonModere() {
			
			List<Evenement> listeEvent = new ArrayList<Evenement>();
		    try {
		    	Connection connection = DataSourceProvider.getDataSource().getConnection();
		    	Statement stmt = connection.createStatement();
		    	ResultSet results = stmt.executeQuery("SELECT * FROM evenement where moderation = false ORDER BY dateDebut ASC");
		    while (results.next()) {
		    	Evenement evenement = new Evenement(results.getInt("idEvenement"), 
		                   results.getInt("idCommission"),
		                   results.getString("nomCommission"),
		                   results.getString("nomPole"),
		                   results.getString("titreEvent"),
		                   results.getString("descriptionEvent"),
		                   results.getString("lieuEvent"),
		                   results.getDate("dateDebut"),
		                   results.getDate("dateFin"),
		                   results.getTime("heureDebut"),
		                   results.getTime("heureFin"),
		                   results.getString("image"),
		                   results.getBoolean("moderation"));
		    	listeEvent.add(evenement);
		    }
			connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return listeEvent;
	}

	public List<Evenement> listerEvenementModere() {
		
		List<Evenement> listeEvent = new ArrayList<Evenement>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM evenement where moderation = true");
	    while (results.next()) {
	    	Evenement evenement = new Evenement(results.getInt("idEvenement"), 
	                   results.getInt("idCommission"),
	                   results.getString("nomCommission"),
	                   results.getString("nomPole"),
	                   results.getString("titreEvent"),
	                   results.getString("descriptionEvent"),
	                   results.getString("lieuEvent"),
	                   results.getDate("dateDebut"),
	                   results.getDate("dateFin"),
	                   results.getTime("heureDebut"),
	                   results.getTime("heureFin"),
	                   results.getString("image"),
	                   results.getBoolean("moderation"));
	    	listeEvent.add(evenement);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeEvent;
	}

	public void ajouterEvenement(Evenement evenement) {

		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `evenement`(`idCommission`,`nomCommission`,`nomPole`, `titreEvent`,`descriptionEvent`,`lieuEvent`, `dateDebut`, `dateFin`, `heureDebut`, `heureFin`, `image`, `moderation`) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?,?)"); 
	        stmt.setInt(1, evenement.getIdCommission());
	        stmt.setString(2, evenement.getNomCommission());
	        stmt.setString(3, evenement.getNomPole());
	        stmt.setString(4, evenement.getTitreEvent());
	        stmt.setString(5, evenement.getDescriptionEvent());
	        stmt.setString(6, evenement.getLieu());
	        stmt.setString(7, evenement.getDateDebut());
	        stmt.setString(8, evenement.getDateFin());
	        stmt.setString(9, evenement.getHeureDebut());
	        stmt.setString(10, evenement.getHeureFin());
	        stmt.setString(11, evenement.getImage());
	        stmt.setBoolean(12, evenement.isModeration());
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	public Evenement getEvenement(Integer idEvenement) {
		
		Evenement evenement= null;
		// Creer une nouvelle connexion a la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM evenement WHERE idEvenement =? ");
	        
	        stmt.setInt(1, idEvenement);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	evenement = new Evenement(results.getInt("idEvenement"),
	                    results.getInt("idCommission"),
	                    results.getString("nomCommission"),
		                results.getString("nomPole"),
	                    results.getString("titreEvent"),
	                    results.getString("descriptionEvent"),
	                    results.getString("lieuEvent"),
	                    results.getString("dateDebut"),
	                    results.getString("dateFin"),
	                    results.getTime("heureDebut"),
		                results.getTime("heureFin"),
		                results.getString("image"),
		                results.getBoolean("moderation"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return evenement;
	}
	public List<Evenement> listerEvenementEtudiant(Integer idEtudiant) {
			
			List<Evenement> listeEvent = new ArrayList<Evenement>();
		    try {
		    	Connection connection = DataSourceProvider.getDataSource().getConnection();
		    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM evenement INNER JOIN (commission INNER JOIN choix ON commission.idCommission = choix.idCommission) ON evenement.idCommission = commission.idCommission WHERE choix.idEtudiant=? AND evenement.moderation=false ORDER BY dateDebut ASC");
		    	stmt.setInt(1, idEtudiant);
		    	ResultSet results = stmt.executeQuery();
		    	while (results.next()) {
		    	Evenement evenement = new Evenement(results.getInt("idEvenement"), 
		                   results.getInt("idCommission"),
		                   results.getString("nomCommission"),
		                   results.getString("nomPole"),
		                   results.getString("titreEvent"),
		                   results.getString("descriptionEvent"),
		                   results.getString("lieuEvent"),
		                   results.getString("dateDebut"),
		                   results.getString("dateFin"),
		                   results.getTime("heureDebut"),
		                   results.getTime("heureFin"),
		                   results.getString("image"),
		                   results.getBoolean("moderation"));
		    	listeEvent.add(evenement);
		    }
			connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return listeEvent;
	}


	public Evenement getEvenementByDate(String dateDebut) {
		Evenement evenement= null;
		// Creer une nouvelle connexion de la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM evenement WHERE dateDebut =? ");
	        
	        stmt.setString(1, dateDebut);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	evenement = new Evenement(results.getInt("idEvenement"),
	                    results.getInt("idCommission"),
	                    results.getString("nomCommission"),
		                results.getString("nomPole"),
	                    results.getString("titreEvent"),
	                    results.getString("descriptionEvent"),
	                    results.getString("lieuEvent"),
	                    results.getDate("dateDebut"),
	                    results.getDate("dateFin"),
	                    results.getTime("heureDebut"),
		                results.getTime("heureFin"),
		                results.getString("image"),
		                results.getBoolean("moderation"));
	        }
	
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return evenement;
	}
	
	public void supprimerEvenement(Integer idEvenement) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "DELETE FROM `evenement` WHERE idEvenement = ?"); 
	        
	        stmt.setInt(1,idEvenement);
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public List<Evenement> listerEvenementByCommission(Integer idCommission) {
		List<Evenement> listeEvent = new ArrayList<Evenement>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM evenement WHERE idCommission=? ");
	    	stmt.setInt(1, idCommission);
	    	ResultSet results = stmt.executeQuery();
	    	while (results.next()) {
	    	Evenement evenement = new Evenement(results.getInt("idEvenement"), 
	                   results.getInt("idCommission"),
	                   results.getString("nomCommission"),
	                   results.getString("nomPole"),
	                   results.getString("titreEvent"),
	                   results.getString("descriptionEvent"),
	                   results.getString("lieuEvent"),
	                   results.getString("dateDebut"),
	                   results.getString("dateFin"),
	                   results.getTime("heureDebut"),
	                   results.getTime("heureFin"),
	                   results.getString("image"),
	                   results.getBoolean("moderation"));
	    	listeEvent.add(evenement);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listeEvent;
	}
	
	public void modifierEvenement(Integer idEvenement, Integer idCommission, String nomCommission, String nomPole, String titre, String description, String lieu, String dateDebut, String dateFin, String heureDebut, String heureFin) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(
	                  "UPDATE `evenement` SET `idCommission`= ? WHERE `idEvenement`=?");
	        PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(
	        		"UPDATE `evenement` SET `nomCommission`=? WHERE `idEvenement`=?");
	        PreparedStatement stmt3 = (PreparedStatement) connection.prepareStatement(
	        		"UPDATE `evenement` SET `nomPole`=? WHERE `idEvenement`=?");
	        PreparedStatement stmt4 = (PreparedStatement) connection.prepareStatement(
	        		"UPDATE `evenement` SET `titreEvent`=? WHERE `idEvenement`=?");
	        PreparedStatement stmt5 = (PreparedStatement) connection.prepareStatement(
	        		"UPDATE `evenement` SET `descriptionEvent`=? WHERE `idEvenement`=?");
	        PreparedStatement stmt6 = (PreparedStatement) connection.prepareStatement( 
	        		"UPDATE `evenement` SET `lieuEvent`=? WHERE `idEvenement`=?"); 
	        PreparedStatement stmt7 = (PreparedStatement) connection.prepareStatement( 
	        		"UPDATE `evenement` SET `dateDebut`=? WHERE `idEvenement`=?");
	        PreparedStatement stmt8 = (PreparedStatement) connection.prepareStatement( 
	        		"UPDATE `evenement` SET `dateFin`=? WHERE `idEvenement`=?");
	        PreparedStatement stmt9 = (PreparedStatement) connection.prepareStatement( 
	        		"UPDATE `evenement` SET `heureDebut`=? WHERE `idEvenement`=?");
	        PreparedStatement stmt10 = (PreparedStatement) connection.prepareStatement( 
	        		"UPDATE `evenement` SET `heureFin`=? WHERE `idEvenement`=?");
	        
	        stmt1.setInt(1,idCommission);
	        stmt1.setInt(2,idEvenement);
	        stmt2.setString(1,nomCommission);
	        stmt2.setInt(2,idEvenement);
	        stmt3.setString(1,nomPole);
	        stmt3.setInt(2,idEvenement);
	        stmt4.setString(1,titre);
	        stmt4.setInt(2,idEvenement);
	        stmt5.setString(1,description);
	        stmt5.setInt(2,idEvenement);
	        stmt6.setString(1,lieu);
	        stmt6.setInt(2,idEvenement);
	        stmt7.setString(1,dateDebut);
	        stmt7.setInt(2,idEvenement);
	        stmt8.setString(1,dateFin);
	        stmt8.setInt(2,idEvenement);
	        stmt9.setString(1,heureDebut);
	        stmt9.setInt(2,idEvenement);
	        stmt10.setString(1,heureFin);
	        stmt10.setInt(2,idEvenement);
	        
	        stmt1.executeUpdate();
	        stmt2.executeUpdate();
	        stmt3.executeUpdate();
	        stmt4.executeUpdate();
	        stmt5.executeUpdate();
	        stmt6.executeUpdate();
	        stmt7.executeUpdate();
	        stmt8.executeUpdate();
	        stmt9.executeUpdate();
	        stmt10.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void setModeration(Integer idEvenement) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(
	                  "UPDATE `evenement` SET `moderation`= true WHERE `idEvenement`=?");
	       
	        stmt1.setInt(1,idEvenement);   
	        stmt1.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void setUnModeration(Integer idEvenement) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(
	                  "UPDATE `evenement` SET `moderation`= false WHERE `idEvenement`=?");
	       
	        stmt1.setInt(1,idEvenement);   
	        stmt1.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public List<Integer> listerEvenementParticipationByUser(Integer idEtudiant) {
		List<Integer> listeEventPart = new ArrayList<Integer>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT idEvenement FROM participation WHERE idEtudiant=? ");
	    	stmt.setInt(1, idEtudiant);
	    	ResultSet results = stmt.executeQuery();
	    while (results.next()) {
	    	listeEventPart.add(results.getInt("idEvenement"));
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeEventPart;
	}
}
