package hei.dao.impl;

import java.sql.Connection;
import java.sql.Date;
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
	                   results.getDate("dateDebut"),
	                   results.getDate("dateFin"),
	                   results.getString("image"));
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
	                  "INSERT INTO `evenement`(`idEvenement`,`idCommission`, `titreEvent`,`descriptionEvent`,`lieuEvent`, `dateDebut`, `dateFin`) VALUES(?, ?, ?, ?, ?, ?, ?)"); 
	        stmt.setInt(1, evenement.getIdEvenement());
	        stmt.setInt(2, evenement.getIdCommission());
	        stmt.setString(3, evenement.getTitreEvent());
	        stmt.setString(4, evenement.getDescriptionEvent());
	        stmt.setString(5, evenement.getLieu());
	        stmt.setDate(6, new Date(evenement.getDateDebut().getTime()));
	        stmt.setDate(7, new Date(evenement.getDateFin().getTime()));
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	public Evenement getEvenement(Integer idEvenement) {
		
		Evenement evenement= null;
		// Cr�er une nouvelle connexion � la BDD
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
	                    results.getDate("dateDebut"),
	                    results.getDate("dateFin"),
		                results.getString("image"));
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
	    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM evenement INNER JOIN (commission INNER JOIN choix ON commission.idCommission = choix.idCommission) ON evenement.idCommission = commission.idCommission WHERE choix.idEtudiant=? ");
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
	                   results.getDate("dateDebut"),
	                   results.getDate("dateFin"),
	                   results.getString("image"));
	    	listeEvent.add(evenement);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeEvent;
	}

@Override
public Evenement getEvenementByDate(java.util.Date dateDebut) {
	Evenement evenement= null;
	// Cr�er une nouvelle connexion � la BDD
    try {
        Connection connection = 
            DataSourceProvider.getDataSource().getConnection();

        // Utiliser la connexion
        PreparedStatement stmt = (PreparedStatement) connection
        		.prepareStatement("SELECT * FROM evenement WHERE dateDebut =? ");
        
        stmt.setDate(1, (Date) dateDebut);
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
	                results.getString("image"));
        }

        // Fermer la connexion
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return evenement;
}
}
