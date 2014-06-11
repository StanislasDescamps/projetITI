package hei.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import hei.dao.impl.PoleDaoImpl;
import hei.model.Pole;

public class PoleDaoTest {

	private PoleDao poleDao = new PoleDaoImpl();
	
	@Test
	public void testListerPole() {
		List<Pole> pole = poleDao.listerPole();
		Assert.assertEquals(5, pole.size());
		Assert.assertEquals(1, pole.get(0).getIdPole().intValue());
		Assert.assertEquals(1, pole.get(0).getIdEtudiant().intValue());
		Assert.assertEquals("BDA", pole.get(0).getNomPole());
	}
	
	@Test
	public void testgetPole() {
		Pole pole = poleDao.getPole(1);
		Assert.assertEquals(1, pole.getIdPole().intValue());
		Assert.assertEquals("BDA", pole.getNomPole());
		Assert.assertEquals(1, pole.getIdEtudiant().intValue());		
	}
	@Test
	public void testgetPoleEvent() {
		Pole pole = poleDao.getPoleEvent(1);
		Assert.assertEquals(1, pole.getIdPole().intValue());
		Assert.assertEquals("BDA", pole.getNomPole());
		Assert.assertEquals(1, pole.getIdEtudiant().intValue());		
	}
	@Test
	public void testgetPoleByNom() {
		Pole pole = poleDao.getPolebyNom("BDA");
		Assert.assertEquals(1, pole.getIdPole().intValue());
		Assert.assertEquals("BDA", pole.getNomPole());
		Assert.assertEquals(1, pole.getIdEtudiant().intValue());		
	}
}
