package hei.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import hei.dao.impl.CommissionDaoImpl;
import hei.model.Commission;


public class CommissionDaoTest {

	private CommissionDao commissionDao = new CommissionDaoImpl();
	
	@Test
	public void testListerCommission() {
		List<Commission> commission = commissionDao.listerCommission();
		Assert.assertEquals(2, commission.size());
		Assert.assertEquals(1, commission.get(0).getIdcommission().intValue());
		Assert.assertEquals(2, commission.get(0).getIdetudiant().intValue());
		Assert.assertEquals(1, commission.get(0).getIdpole().intValue());
		Assert.assertEquals("La Sauce", commission.get(0).getNomCommission());
		Assert.assertEquals("Le plaisir de manger entre etudiants", commission.get(0).getDescription());
		Assert.assertEquals("img/bda.jpg", commission.get(0).getLogo());

	}
}
