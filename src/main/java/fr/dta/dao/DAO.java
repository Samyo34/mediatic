package fr.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import fr.dta.globale.DatabaseHelper;

public class DAO<T> {
	
	private Class<T> klass;
	
	@PersistenceContext
	protected EntityManager em;

	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	
	public DAO(Class<T> klass){
		this.klass = klass;
	}
	
	public void create(T entity){
		em.persist(entity);
	}
	
	public void create(List<T> entities){
		for (T entity : entities) {
			em.persist(entity);
		}
	}
	
	public void udpate(T entity){
		em.merge(entity);
	}
	
	public void udpate(List<T> entities){
		for (T entity : entities) {
			em.merge(entity);
		}
	}
	
	public T getByID(Long id) {
		T entity = em.find(klass, id);
		return entity;
	}
}
