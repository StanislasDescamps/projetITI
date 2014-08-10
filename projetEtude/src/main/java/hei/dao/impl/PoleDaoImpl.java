package hei.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import hei.dao.PoleDao;
import hei.model.Pole;

public class PoleDaoImpl implements PoleDao {

	public List<Pole> listerPole() {
		List<Pole> listePole = new ArrayList<Pole>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM pole");
	    while (results.next()) {
	    	Pole pole = new Pole(results.getInt("idPole"), 
	                   results.getInt("idEtudiant"),
	                   results.getString("nomPole"));
	    	listePole.add(pole);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listePole;	
	}

	public Pole getPole(Integer idPole) {
		Pole pole= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM pole WHERE idPole =? ");
	        
	        stmt.setInt(1, idPole);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	pole = new Pole(results.getInt("idPole"),
	                    results.getInt("idEtudiant"),
	                    results.getString("nomPole"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pole;
	}
	public Pole getPoleEvent (Integer idEvenement) {
		Pole pole= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM pole INNER JOIN (commission INNER JOIN evenement ON commission.idCommission=evenement.idCommission) ON pole.idPole = commission.idPole WHERE idEvenement =? ");
	        
	        stmt.setInt(1, idEvenement);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	pole = new Pole(results.getInt("idPole"),
	                    results.getInt("idEtudiant"),
	                    results.getString("nomPole"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pole;
	}

	@Override
	public Pole getPolebyNom(String nomPole) {
		Pole pole= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM pole WHERE nomPole = ?");
	        
	        stmt.setString(1, nomPole);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	pole = new Pole(results.getInt("idPole"),
	                    results.getInt("idEtudiant"),
	                    results.getString("nomPole"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pole;
	}

	@Override
	public Pole getPoleByResp(Integer idEtudiant) {
			Pole pole= null;
			// Cr�er une nouvelle connexion � la BDD
		    try {
		        Connection connection = 
		            DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = (PreparedStatement) connection
		        		.prepareStatement("SELECT * FROM pole WHERE idEtudiant = ?");
		        
		        stmt.setInt(1, idEtudiant);
		        ResultSet results = stmt.executeQuery();
		        if(results.next()){
		        	pole = new Pole(results.getInt("idPole"),
		                    results.getInt("idEtudiant"),
		                    results.getString("nomPole"));
		        }

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return pole;
		}
}
