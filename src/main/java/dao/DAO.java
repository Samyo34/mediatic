package dao;

import java.util.List;

import javax.persistence.EntityManager;

import globale.DatabaseHelper;

public class DAO<T> {
	
	private Class<T> klass;
	
	public DAO(Class<T> klass){
		this.klass = klass;
	}
	
	public void createEntity(T entity){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void createEntities(List<T> entities){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (T entity : entities) {
			em.persist(entity);
		}
		
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void udpateEntity(T entity){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void udpateEntities(List<T> entities){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (T entity : entities) {
			em.merge(entity);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
}
