package dao;

import java.util.List;

import javax.persistence.EntityManager;

import globale.DatabaseHelper;

public abstract class DAO {
	
	public static <T> void createEntity(T entity){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static <T> void createEntities(List<T> entities){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (T entity : entities) {
			em.persist(entity);
		}
		
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static <T> void udpateEntity(T entity){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static <T> void udpateEntities(List<T> entities){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (T entity : entities) {
			em.merge(entity);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
}
