package hei.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import hei.dao.impl.CommissionDaoImpl;
import hei.dao.impl.DataSourceProvider;
import hei.model.Commission;


public class CommissionDaoTest {

	private CommissionDao commissionDao = new CommissionDaoImpl();
	
	@Test
	public void testListerCommission() {
		List<Commission> commission = commissionDao.listerCommission();
		Assert.assertEquals(5, commission.size());
		Assert.assertEquals(1, commission.get(0).getIdcommission().intValue());
		Assert.assertEquals(2, commission.get(0).getIdetudiant().intValue());
		Assert.assertEquals(1, commission.get(0).getIdpole().intValue());
		Assert.assertEquals("La Sauce", commission.get(0).getNomCommission());
		Assert.assertEquals("Le plaisir de manger entre etudiants", commission.get(0).getDescription());
		Assert.assertEquals("img/bda.jpg", commission.get(0).getLogo());

	}
	
	@Test
	public void testListerCommissionPole() {
		List<Commission> commission = commissionDao.listerCommissionPole("BDA");
		Assert.assertEquals(1, commission.size());
		Assert.assertEquals(1, commission.get(0).getIdcommission().intValue());
		Assert.assertEquals(2, commission.get(0).getIdetudiant().intValue());
		Assert.assertEquals(1, commission.get(0).getIdpole().intValue());
		Assert.assertEquals("La Sauce", commission.get(0).getNomCommission());
		Assert.assertEquals("Le plaisir de manger entre etudiants", commission.get(0).getDescription());
		Assert.assertEquals("img/bda.jpg", commission.get(0).getLogo());
	}
	@Test
	public void testAjouterCommission() throws Exception {
		
		Commission nouveauEtudiant = new Commission(null,1,1,"Asso", "Super", "logo.jpg");
		commissionDao.ajouterCommission(nouveauEtudiant);

		Connection connection = DataSourceProvider.getDataSource()
				.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery("SELECT * FROM commission WHERE nomCommission = 'Asso'");
		// On v�rifie qu'il y a un retour
		Assert.assertTrue(results.next());
		// On v�rifie les champs
		Assert.assertNotNull(results.getInt("idCommission"));
		Assert.assertEquals(1, results.getInt("idEtudiant"));
		Assert.assertEquals(1, results.getInt("idPole"));
		Assert.assertEquals("Asso",results.getString("nomCommission"));
		Assert.assertEquals("Super",results.getString("descriptionCom"));		
		Assert.assertEquals("logo.jpg",results.getBoolean("adresseLogo"));
		// On v�rifie qu'il n'y a qu'un r�sultat
		Assert.assertFalse(results.next());
	}
	@Test
	public void testgetCommission() {
		Commission commission = commissionDao.getCommission(1);
		Assert.assertEquals(1, commission.getIdcommission().intValue());
		Assert.assertEquals(2, commission.getIdetudiant().intValue());
		Assert.assertEquals(1, commission.getIdpole().intValue());
		Assert.assertEquals("La Sauce", commission.getNomCommission());
		Assert.assertEquals("Le plaisir de manger entre etudiants", commission.getDescription());
		Assert.assertEquals("img/bda.jpg", commission.getLogo());
	}
	@Test
	public void testgetCommissionEvent() {
		Commission commission = commissionDao.getCommissionEvent(1);
		Assert.assertEquals(1, commission.getIdcommission().intValue());
		Assert.assertEquals(2, commission.getIdetudiant().intValue());
		Assert.assertEquals(1, commission.getIdpole().intValue());
		Assert.assertEquals("La Sauce", commission.getNomCommission());
		Assert.assertEquals("Le plaisir de manger entre etudiants", commission.getDescription());
		Assert.assertEquals("img/bda.jpg", commission.getLogo());
	}
	@Test
	public void testAjouterChoixCommission() throws Exception {
		
		commissionDao.ajouterChoixCommission(1,3);

		Connection connection = DataSourceProvider.getDataSource()
				.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery("SELECT * FROM choix WHERE idEtudiant = 1");
		// On v�rifie qu'il y a un retour
		Assert.assertTrue(results.next());
		// On v�rifie les champs
		Assert.assertEquals(1, results.getInt("idEtudiant"));
		Assert.assertEquals(3, results.getInt("idCommission"));
		// On v�rifie qu'il n'y a qu'un r�sultat
		Assert.assertFalse(results.next());
	}
	@Test
	public void testListerChoixCommission() {
		List<Commission> commission = commissionDao.listerChoixCommission(2);
		Assert.assertEquals(1, commission.size());
		Assert.assertEquals(1, commission.get(0).getIdcommission().intValue());
		Assert.assertEquals(2, commission.get(0).getIdetudiant().intValue());
		Assert.assertEquals(1, commission.get(0).getIdpole().intValue());
		Assert.assertEquals("La Sauce", commission.get(0).getNomCommission());
		Assert.assertEquals("Le plaisir de manger entre etudiants", commission.get(0).getDescription());
		Assert.assertEquals("img/bda.jpg", commission.get(0).getLogo());
	}
	@Test
	public void testModifierCommission() throws Exception {
		
		commissionDao.modifierCommission(1,2,1,"La Sauce", "Le plaisir de manger entre etudiants", "img/bda.jpg");

		Connection connection = DataSourceProvider.getDataSource()
				.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery("SELECT * FROM commission WHERE nomCommission = 'La Sauce'");
		// On v�rifie qu'il y a un retour
		Assert.assertTrue(results.next());
		// On v�rifie les champs
		Assert.assertEquals(1,results.getInt("idCommission"));
		Assert.assertEquals(2, results.getInt("idEtudiant"));
		Assert.assertEquals(1, results.getInt("idPole"));
		Assert.assertEquals("La Sauce",results.getString("nomCommission"));
		Assert.assertEquals("Le plaisir de manger entre etudiants",results.getString("descriptionCom"));		
		Assert.assertEquals("img/bda.jpg",results.getBoolean("adresseLogo"));
		// On v�rifie qu'il n'y a qu'un r�sultat
		Assert.assertFalse(results.next());
	}
	@Test
	public void testSupprimerCommission() throws Exception {
		
		commissionDao.supprimerCommission(6);

		List<Commission> commission = commissionDao.listerCommission();
		Assert.assertEquals(5, commission.size());
	}
	@Test
	public void testSupprimerChoix() throws Exception {
		
		commissionDao.supprimerChoix(1);

		List<Commission> commission = commissionDao.listerChoixCommission(1);
		Assert.assertEquals(0, commission.size());
	}
	
}
