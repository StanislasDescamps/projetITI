package hei.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import hei.dao.CalendrierDao;
import hei.model.Calendrier;

public class CalendrierDaoImpl implements CalendrierDao{

	public List<Calendrier> listerCalendrier() {
		
		List<Calendrier> listeCal = new ArrayList<Calendrier>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM calendrier");
	    while (results.next()) {
	    	Calendrier calendrier = new Calendrier(results.getInt("idCalendrier"), 
	                   results.getInt("idEtudiant"),
	                   results.getDate("dateEmission"));
	    	listeCal.add(calendrier);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeCal;
	}

	public void ajouterCalendrier(Calendrier calendrier) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `calendrier`(`idCalendrier`,`idEtudiant`, `dateEmission`) VALUES(?, ?, ?)"); 
	        stmt.setInt(1, calendrier.getIdCalendrier());
	        stmt.setInt(2, calendrier.getIdEtudiant());
	        stmt.setDate(3, new Date(calendrier.getDateEmission().getTime()));
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	public Calendrier getCalendrier(Integer idEtudiant) {
		Calendrier calendrier= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM calendrier WHERE idEtudiant =? ");
	        
	        stmt.setInt(1, idEtudiant);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	calendrier = new Calendrier(results.getInt("idCalendrier"),
	                    results.getInt("idEtudiant"),
	                    results.getDate("dateEmission"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return calendrier;
	}

}
