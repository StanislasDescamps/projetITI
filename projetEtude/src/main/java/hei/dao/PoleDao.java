package hei.dao;

import hei.model.Pole;

import java.util.List;

public interface PoleDao {

	public List<Pole> listerPole();
	
	public Pole getPole(Integer idPole);
}
