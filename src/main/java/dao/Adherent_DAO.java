package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import globale.DatabaseHelper;
import model.Adherent;

public class Adherent_DAO {
	
	public static void createAdherent(Adherent ad){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(ad);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void  createAdherents(List<Adherent> ads){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Adherent adherent : ads) {
			em.persist(adherent);
		}
		
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static Adherent getAdherentByID(Long id){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Adherent ad = em.find(Adherent.class,id);
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}
	
	public static List<Adherent> getAdherentByNom(String nom){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from adherent a "+
				"where a.nom =:nom",Adherent.class);
		query.setParameter("nom", nom);
		List<Adherent> ad = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}
	
	public static List<Adherent> getAdherentByPrenom(String prenom){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from adherent a "+
				"where a.prenom =:prenom",Adherent.class);
		query.setParameter("prenom", prenom);
		List<Adherent> ad = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}
	
	public static List<Adherent> getAdherentByNomPrenom(String nom, String prenom){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from adherent a "+
				"where a.nom =:nom AND a.prenom =:prenom",Adherent.class);
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);
		List<Adherent> ad = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}
	
	public static void udpateAdherent(Adherent ad){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(ad);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void udpateAdherents(List<Adherent> ads){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Adherent adherent : ads) {
			em.merge(adherent);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	

}
