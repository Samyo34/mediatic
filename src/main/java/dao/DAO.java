package dao;

import java.util.List;

import javax.persistence.EntityManager;

import globale.DatabaseHelper;

public class DAO<T> {
	
	private Class<T> klass;
	
	public DAO(Class<T> klass){
		this.klass = klass;
	}
	
	public void create(T entity){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void create(List<T> entities){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (T entity : entities) {
			em.persist(entity);
		}
		
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void udpate(T entity){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void udpate(List<T> entities){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (T entity : entities) {
			em.merge(entity);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public T getByID(Long id) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		T entity = em.find(klass, id);
		DatabaseHelper.commitTxAndClose(em);
		return entity;
	}
}
