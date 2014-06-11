package hei.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import hei.dao.impl.EvenementDaoImpl;
import hei.model.Evenement;

public class EvenementDaoTest {

	private EvenementDao evenementDao = new EvenementDaoImpl();
	
	@Test
	public void testListerEvenement() {
		List<Evenement> evenement = evenementDao.listerEvenement();
		Assert.assertEquals(6, evenement.size());
		Assert.assertEquals(1, evenement.get(0).getIdEvenement().intValue());
		Assert.assertEquals(1, evenement.get(0).getIdCommission().intValue());
		Assert.assertEquals("La Sauce", evenement.get(0).getNomCommission());
		Assert.assertEquals("BDA", evenement.get(0).getNomPole());
		Assert.assertEquals("Salon gastronomique", evenement.get(0).getTitreEvent());
		Assert.assertEquals("Viens gouter les saveur d Espagne ca va etre trop bon", evenement.get(0).getDescriptionEvent());		
		Assert.assertEquals("RR034", evenement.get(0).getLieu());
		Assert.assertEquals("img/bda.jpg", evenement.get(0).getImage());
	}
	@Test
	public void testlisterEvenementEtudiant() {
		List<Evenement> evenement = evenementDao.listerEvenementEtudiant(2);
		Assert.assertEquals(1, evenement.size());
		Assert.assertEquals(1, evenement.get(0).getIdEvenement().intValue());
		Assert.assertEquals(1, evenement.get(0).getIdCommission().intValue());
		Assert.assertEquals("La Sauce", evenement.get(0).getNomCommission());
		Assert.assertEquals("BDA", evenement.get(0).getNomPole());
		Assert.assertEquals("Salon gastronomique", evenement.get(0).getTitreEvent());
		Assert.assertEquals("Viens gouter les saveur d Espagne ca va etre trop bon", evenement.get(0).getDescriptionEvent());		
		Assert.assertEquals("RR034", evenement.get(0).getLieu());
		Assert.assertEquals("img/bda.jpg", evenement.get(0).getImage());
	}
	@Test
	public void testgetEvenement() {
		Evenement evenement = evenementDao.getEvenement(1);
		Assert.assertEquals(1, evenement.getIdEvenement().intValue());
		Assert.assertEquals(1, evenement.getIdCommission().intValue());
		Assert.assertEquals("La Sauce", evenement.getNomCommission());
		Assert.assertEquals("BDA", evenement.getNomPole());
		Assert.assertEquals("Salon gastronomique", evenement.getTitreEvent());
		Assert.assertEquals("Viens gouter les saveur d Espagne ca va etre trop bon", evenement.getDescriptionEvent());		
		Assert.assertEquals("RR034", evenement.getLieu());
		Assert.assertEquals("img/bda.jpg", evenement.getImage());
	}
	@Test
	public void testgetEvenementByDate() {
		Evenement evenement = evenementDao.getEvenementByDate("2014-05-24");
		Assert.assertEquals(1, evenement.getIdEvenement().intValue());
		Assert.assertEquals(1, evenement.getIdCommission().intValue());
		Assert.assertEquals("La Sauce", evenement.getNomCommission());
		Assert.assertEquals("BDA", evenement.getNomPole());
		Assert.assertEquals("Salon gastronomique", evenement.getTitreEvent());
		Assert.assertEquals("Viens gouter les saveur d Espagne ca va etre trop bon", evenement.getDescriptionEvent());		
		Assert.assertEquals("RR034", evenement.getLieu());
		Assert.assertEquals("img/bda.jpg", evenement.getImage());
	}
}
