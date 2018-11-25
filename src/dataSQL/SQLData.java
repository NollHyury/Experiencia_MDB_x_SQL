package dataSQL;
import models.BancoDeDados;
import models.Coordenada;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class SQLData extends BancoDeDados {

	
	EntityManager em = JPAUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	
	@Override
	public void save(Coordenada t) {
		tx.begin();
		em.persist(t);
		tx.commit();
	}
	
	public Coordenada getOne(double latitude, double longetude) {
		Query query = em.createQuery("FROM Coordenada where Latitude = :latitude and longetude=:longetude");
		query.setParameter("latitude", latitude);
		query.setParameter("longetude", longetude);
		Coordenada c = (Coordenada) query.getSingleResult();
		return c;
	}
	
	@Override
	public void close() {
		em.close();
		
	}
	
	
	

}
