package fr.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.dta.globale.DatabaseHelper;
import fr.dta.model.Adherent;
import fr.dta.model.Emprunt;
import fr.dta.model.Media;

public class EmpruntDAO extends DAO<Emprunt>{
	
    private static EmpruntDAO dao;

    private EmpruntDAO() {
        super(Emprunt.class);
    }

    public static EmpruntDAO instance() {
        if (dao == null) {
            dao = new EmpruntDAO();
        }
        return dao;
    }
    
    public List<Emprunt> getEmpruntsByAdherent(Adherent a){
    	EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Emprunt> query = em.createQuery("select e "+
				"from emprunt e "+
				"where e.adherent =:id",Emprunt.class);
		query.setParameter("id", a.getId());
		List<Emprunt> emprunts = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return emprunts;
    }
    
    public List<Emprunt> getEmpruntsByMedia(Media m){
    	EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Emprunt> query = em.createQuery("select e "+
				"from emprunt e "+
				"where e.media =:id",Emprunt.class);
		query.setParameter("id", m.getId());
		List<Emprunt> emprunts = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return emprunts;
    }
}
