package fr.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import fr.dta.globale.DatabaseHelper;
import fr.dta.model.Adherent;
import fr.dta.model.Media;

@Service
@Transactional
public class AdherentDAO extends DAO<Adherent> {

    public AdherentDAO() {
        super(Adherent.class);
    }
    
    public List<Adherent> getAllAdherent(){
    	Query query = getSession().createQuery("from " + Adherent.class.getSimpleName());
		return query.list();
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
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from Adherent a "+
				"where a.nom =:nom",Adherent.class);
		query.setParameter("nom", nom);
		List<Adherent> ad = query.getResultList();
		return ad;
	}
	
	public List<Adherent> getAdherentByPrenom(String prenom){
		TypedQuery<Adherent> query = em.createQuery("select a "+
				"from Adherent a "+
				"where a.prenom =:prenom",Adherent.class);
		query.setParameter("prenom", prenom);
		List<Adherent> ad = query.getResultList();
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
	
	public List<Adherent> getAdherentByParams(Integer id,String nom, String prenom,String email){
		StringBuilder sb = new StringBuilder("");
		if(id != null){
			sb.append("id LIKE '%:id%' AND ");
		}
		
		if(nom != null){
			sb.append("nom LIKE '%:nom%' AND ");
		}
		
		if(prenom != null){
			sb.append("prenom LIKE '%:prenom%' AND ");
		}
		
		if(email != null){
			sb.append("mail LIKE '%:email%' AND ");
		}
		
		sb.delete(sb.length()-5, sb.length());		
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Adherent> query = em.createQuery("select * "+
				"from Adherent "+
				"where "+sb.toString(),Adherent.class);
		query.setParameter("id", id);
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);
		query.setParameter("mail", email);
		List<Adherent> ad = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}
	
	public Adherent updateAdherent(Adherent adherent){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Adherent a = em.merge(adherent);
		DatabaseHelper.commitTxAndClose(em);
		return a;
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
