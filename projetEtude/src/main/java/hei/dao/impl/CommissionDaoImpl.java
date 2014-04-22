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
	                  "INSERT INTO `commission`(`idEtudiant`, `idPole`, `nomCommission`, `descriptionCom`, `adresseLogo`) VALUES(?, ?, ?, ?, ?)"); 
	        
	        stmt.setInt(1, commission.getIdetudiant());
	        stmt.setInt(2, commission.getIdpole());
	        stmt.setString(3, commission.getNomCommission());
	        stmt.setString(4, commission.getDescription());
	        stmt.setString(5, commission.getLogo());
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
public List<Commission> listerCommissionPole(String nomPole) {
	
	List<Commission> listeComm = new ArrayList<Commission>();
    try {
    	Connection connection = DataSourceProvider.getDataSource().getConnection();
    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM commission INNER JOIN pole ON commission.idPole = pole.idPole WHERE nomPole=?");
    	stmt.setString(1, nomPole);
    	ResultSet results = stmt.executeQuery();
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
public void ajouterChoixCommission(Integer idEtudiant, Integer idCommission){
	
	try {
        Connection connection = 
            DataSourceProvider.getDataSource().getConnection();

        // Utiliser la connexion
        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
                  "INSERT INTO `choix`(`idEtudiant`, `idCommission`) VALUES(?, ?)"); 
        
        stmt.setInt(1,idEtudiant);
        stmt.setInt(2,idCommission);
        stmt.executeUpdate();
        // Fermer la connexion
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
	
}

@Override
public List<Commission> listerChoixCommission(Integer idEtudiant) {
	List<Commission> listeChoixCommission = new ArrayList<Commission>();
    try {
    	Connection connection = DataSourceProvider.getDataSource().getConnection();
    
    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM commission INNER JOIN choix ON commission.idCommission=choix.idCommission WHERE choix.idEtudiant =?");
    	stmt.setInt(1, idEtudiant);
    	ResultSet results = stmt.executeQuery();
    while (results.next()) {
    	Commission commission = new Commission(results.getInt("idCommission"), 
                results.getInt("idEtudiant"),
                results.getInt("idPole"),
                results.getString("nomCommission"),
                results.getString("descriptionCom"),
                results.getString("adresseLogo"));
    	listeChoixCommission.add(commission);
    }
	connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return listeChoixCommission;
}

@Override
public void modifierCommission(Integer idCommission, Integer idetudiant, Integer idpole , String nom, String description, String logo) {
	try {
        Connection connection = 
            DataSourceProvider.getDataSource().getConnection();

        // Utiliser la connexion
        PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(
                  "UPDATE `commission` SET `idEtudiant`= ? WHERE `idCommission`=?");
        PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(
        		"UPDATE `commission` SET `idPole`=? WHERE `idCommission`=?");
        PreparedStatement stmt3 = (PreparedStatement) connection.prepareStatement(
        		"UPDATE `commission` SET `nomCommission`=? WHERE `idCommission`=?");
        PreparedStatement stmt4 = (PreparedStatement) connection.prepareStatement(
        		"UPDATE `commission` SET `descriptionCom`=? WHERE `idCommission`=?");
        PreparedStatement stmt5 = (PreparedStatement) connection.prepareStatement( 
        		"UPDATE `commission` SET `adresseLogo`=? WHERE `idCommission`=?"); 
        
        stmt1.setInt(1,idetudiant);
        stmt1.setInt(2,idCommission);
        stmt2.setInt(1,idpole);
        stmt2.setInt(2,idCommission);
        stmt3.setString(1,nom);
        stmt3.setInt(2,idCommission);
        stmt4.setString(1,description);
        stmt4.setInt(2,idCommission);
        stmt5.setString(1,logo);
        stmt5.setInt(2,idCommission);
        
        stmt1.executeUpdate();
        stmt2.executeUpdate();
        stmt3.executeUpdate();
        stmt4.executeUpdate();
        stmt5.executeUpdate();
        // Fermer la connexion
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
	
}

@Override
public void supprimerCommission(Integer idCommission) {
	try {
        Connection connection = 
            DataSourceProvider.getDataSource().getConnection();

        // Utiliser la connexion
        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
                  "DELETE FROM `commission` WHERE idCommission = ?"); 
        
        stmt.setInt(1,idCommission);
        stmt.executeUpdate();
        // Fermer la connexion
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}	

}
