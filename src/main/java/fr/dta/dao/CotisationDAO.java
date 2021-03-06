package fr.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.dta.globale.DatabaseHelper;
import fr.dta.model.Adherent;
import fr.dta.model.Cotisation;
import fr.dta.model.Emprunt;

public class CotisationDAO extends DAO<Cotisation>{
	
    private static CotisationDAO dao;

    private CotisationDAO() {
        super(Cotisation.class);
    }

    public static CotisationDAO instance() {
        if (dao == null) {
            dao = new CotisationDAO();
        }
        return dao;
    }
    
//    private Cotisation getCotisationByAdherent(Adherent a){
//    	EntityManager em = DatabaseHelper.createEntityManager();
//		DatabaseHelper.beginTx(em);
//		TypedQuery<Cotisation> query = em.createQuery("select c "+
//				"from Cotisation c "+
//				"inner join "+
//				"where c.adherent =:id",Cotisation.class);
//		query.setParameter("id", a.getId());
//		Cotisation  coti = query.getSingleResult();
//		DatabaseHelper.commitTxAndClose(em);
//		return coti;
//    }
}
