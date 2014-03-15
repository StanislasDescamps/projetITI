package hei.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import hei.dao.CommissionDao;
import hei.model.Commission;

public class CommissionDaoImpl implements CommissionDao{

	public List<Commission> listerCommission() {
		
		List<Commission> listeComm = new ArrayList<Commission>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM commission");
	    while (results.next()) {
	    	Commission commission = new Commission(results.getInt("idCommission"), 
	                   results.getInt("idEtudiant"),
	                   results.getInt("idPole"),
	                   results.getString("nomCommission"),
	                   results.getString("descriptionCom"),
	                   results.getString("adresseLogo"));
	    	listeComm.add(commission);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeComm;
	}

	public void ajouterCommission(Commission commission) {
		
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `commission`(`idCommission`,`idEtudiant`, `idPole`, `nomCommission`, `descriptionCom`, `adresseLogo`) VALUES(?, ?, ?, ?, ?, ?)"); 
	        stmt.setInt(1, commission.getIdcommission());
	        stmt.setInt(2, commission.getIdetudiant());
	        stmt.setInt(3, commission.getIdpole());
	        stmt.setString(4, commission.getNomCommission());
	        stmt.setString(5, commission.getDescription());
	        stmt.setString(6, commission.getLogo());
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	public Commission getCommission(Integer idCommission) {
		
		Commission commission= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM commission WHERE idCommission =? ");
	        
	        stmt.setInt(1, idCommission);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	commission = new Commission(results.getInt("idCommission"),
	                    results.getInt("idEtudiant"),
	                    results.getInt("idPole"),
	                    results.getString("nomCommission"),
	                    results.getString("descriptionCom"),
	                    results.getString("adresseLogo"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return commission;
	}
public Commission getCommissionEvent(Integer idEvenement) {
		
		Commission commission= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM commission INNER JOIN evenement ON commission.idCommission=evenement.idCommission WHERE idEvenement =? ");
	        
	        stmt.setInt(1, idEvenement);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	commission = new Commission(results.getInt("idCommission"),
	                    results.getInt("idEtudiant"),
	                    results.getInt("idPole"),
	                    results.getString("nomCommission"),
	                    results.getString("descriptionCom"),
	                    results.getString("adresseLogo"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return commission;
	}
}
