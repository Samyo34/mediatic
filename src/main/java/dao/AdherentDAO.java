package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import globale.DatabaseHelper;
import model.Adherent;

public class AdherentDAO extends DAO {
	
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
	
	
	public Adherent getAdherentByID(Long id){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Adherent ad = em.find(Adherent.class,id);
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
}
