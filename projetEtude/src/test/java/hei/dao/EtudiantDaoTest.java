package hei.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import hei.dao.impl.DataSourceProvider;
import hei.dao.impl.EtudiantDaoImpl;
import hei.model.Etudiant;

public class EtudiantDaoTest {

	private EtudiantDao etudiantDao = new EtudiantDaoImpl();
	
	@Test
	public void testListerEtudiant() {
		List<Etudiant> etudiant = etudiantDao.listerEtudiant();
		Assert.assertEquals(4, etudiant.size());
		Assert.assertEquals(1, etudiant.get(0).getIdetudiant().intValue());
		Assert.assertEquals("Gladieux", etudiant.get(0).getNomEtudiant());
		Assert.assertEquals("Jean", etudiant.get(0).getPrenomEtudiant());
		Assert.assertEquals("admin", etudiant.get(0).getPassWord());
		Assert.assertEquals("jean.gladieux@hei.fr", etudiant.get(0).getEmail());
		Assert.assertEquals(1, etudiant.get(0).getIdDroit().intValue());
		Assert.assertEquals(0,etudiant.get(0).isFirstConnexion());
		
	}
	@Test
	public void testAjouterEtudiant() throws Exception {
		
		Etudiant nouveauEtudiant = new Etudiant(null,"Thomas", "Robert", "hei", "adressemail", 1,false);
		etudiantDao.ajouterEtudiant(nouveauEtudiant);

		Connection connection = DataSourceProvider.getDataSource()
				.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery("SELECT * FROM etudiant WHERE nomEtudiant = 'Thomas'");
		// On v�rifie qu'il y a un retour
		Assert.assertTrue(results.next());
		// On v�rifie les champs
		Assert.assertNotNull(results.getInt("idEtudiant"));
		Assert.assertEquals("Thomas", results.getString("nomEtudiant"));
		Assert.assertEquals("Robert", results.getString("prenomEtudiant"));
		Assert.assertEquals("hei",results.getString("password"));
		Assert.assertEquals("adressemail",results.getString("email"));		
		Assert.assertEquals(1,results.getInt("idDroit"));
		Assert.assertEquals(0,results.getBoolean("firstConnexion"));
		// On v�rifie qu'il n'y a qu'un r�sultat
		Assert.assertFalse(results.next());
	}
	@Test
	public void testgetEtudiant() {
		Etudiant etudiant = etudiantDao.getEtudiant(1);
		Assert.assertEquals(1, etudiant.getIdetudiant().intValue());
		Assert.assertEquals("Gladieux", etudiant.getNomEtudiant());
		Assert.assertEquals("Jean", etudiant.getPrenomEtudiant());
		Assert.assertEquals("admin", etudiant.getPassWord());
		Assert.assertEquals("jean.gladieux@hei.fr", etudiant.getEmail());
		Assert.assertEquals(1, etudiant.getIdDroit().intValue());
		Assert.assertEquals(0,etudiant.isFirstConnexion());
	}
	@Test
	public void testgetEtudiantMail() {
		Etudiant etudiant = etudiantDao.getEtudiantMail("jean.gladieux@hei.fr");
		Assert.assertEquals(1, etudiant.getIdetudiant().intValue());
		Assert.assertEquals("Gladieux", etudiant.getNomEtudiant());
		Assert.assertEquals("Jean", etudiant.getPrenomEtudiant());
		Assert.assertEquals("admin", etudiant.getPassWord());
		Assert.assertEquals("jean.gladieux@hei.fr", etudiant.getEmail());
		Assert.assertEquals(1, etudiant.getIdDroit().intValue());
		Assert.assertEquals(0,etudiant.isFirstConnexion());
	}
	@Test
	public void testgetEtudiantResp() {
		Etudiant etudiant = etudiantDao.getEtudiantResp(3);
		Assert.assertEquals(1, etudiant.getIdetudiant().intValue());
		Assert.assertEquals("Gladieux", etudiant.getNomEtudiant());
		Assert.assertEquals("Jean", etudiant.getPrenomEtudiant());
		Assert.assertEquals("admin", etudiant.getPassWord());
		Assert.assertEquals("jean.gladieux@hei.fr", etudiant.getEmail());
		Assert.assertEquals(1, etudiant.getIdDroit().intValue());
		Assert.assertEquals(0,etudiant.isFirstConnexion());
	}
	@Test
	public void testgetEtudiantNomPrenom() {
		Etudiant etudiant = etudiantDao.getEtudiantNomPrenom("Gladieux", "Jean");
		Assert.assertEquals(1, etudiant.getIdetudiant().intValue());
		Assert.assertEquals("Gladieux", etudiant.getNomEtudiant());
		Assert.assertEquals("Jean", etudiant.getPrenomEtudiant());
		Assert.assertEquals("admin", etudiant.getPassWord());
		Assert.assertEquals("jean.gladieux@hei.fr", etudiant.getEmail());
		Assert.assertEquals(1, etudiant.getIdDroit().intValue());
		Assert.assertEquals(0,etudiant.isFirstConnexion());
	}
	
}
