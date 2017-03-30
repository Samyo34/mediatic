package fr.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.dta.globale.DatabaseHelper;
import fr.dta.model.Adherent;
import fr.dta.model.Media;

public class AdherentDAO extends DAO<Adherent> {
	
    private static AdherentDAO dao;

    private AdherentDAO() {
        super(Adherent.class);
    }

    public static AdherentDAO instance() {
        if (dao == null) {
            dao = new AdherentDAO();
        }
        return dao;
    }
    
    public List<Adherent> getAllAdherent(){
    	EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery(" from Adherent", Adherent.class);
		List<Adherent> ads = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return ads;
    }
    
    public Adherent getAdherentWithEmpruntById(Long idAdherent){
    	EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from Adherent a "+
				"left join fetch a.emprunts e "+
				"left join fetch e.media "+
				"where a.id =:id",Adherent.class);
		query.setParameter("id", idAdherent);
		Adherent ad = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return ad;
    }
	
	public List<Adherent> getAdherentByNom(String nom){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from Adherent a "+
				"where a.nom =:nom",Adherent.class);
		query.setParameter("nom", nom);
		List<Adherent> ad = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}
	
	public List<Adherent> getAdherentByPrenom(String prenom){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from Adherent a "+
				"where a.prenom =:prenom",Adherent.class);
		query.setParameter("prenom", prenom);
		List<Adherent> ad = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}
	
	public List<Adherent> getAdherentByNomPrenom(String nom, String prenom){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from Adherent a "+
				"where a.nom =:nom AND a.prenom =:prenom",Adherent.class);
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);
		List<Adherent> ad = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}
	
	/**
	 * return all adherents who borrow the media passed in parameters
	 * 
	 * @param m
	 * @return List<Adherent>
	 */
	public List<Adherent> getAdherentsByMedia(Media m){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select a"+
				"from Adherent a "+
				"inner join emprunt e"+
				"where a.id =:mediaId",Adherent.class);
		query.setParameter("id", m.getId());
		List<Adherent> adherents = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return adherents;
	}
	
	
}
