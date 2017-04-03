package fr.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.dta.globale.DatabaseHelper;
import fr.dta.model.Adherent;
import fr.dta.model.Emprunt;
import fr.dta.model.Media;

@Repository
@Transactional
public class EmpruntDAO extends DAO<Emprunt>{
	
    public EmpruntDAO() {
        super(Emprunt.class);
    }
    
    public List<Emprunt> getEmpruntsByAdherent(Adherent a){
		TypedQuery<Emprunt> query = em.createQuery("select e "+
				"from Emprunt e "+
				"where e.adherent =:id",Emprunt.class);
		query.setParameter("id", a);
		List<Emprunt> emprunts = query.getResultList();
		return emprunts;
    }
    
    public List<Emprunt> getEmpruntsByMedia(Media m){
		TypedQuery<Emprunt> query = em.createQuery("select e "+
				"from emprunt e "+
				"where e.media =:id",Emprunt.class);
		query.setParameter("id", m);
		List<Emprunt> emprunts = query.getResultList();
		return emprunts;
    }

	public List<Emprunt> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(long id) {
		// TODO Auto-generated method stub
		
	}
}
