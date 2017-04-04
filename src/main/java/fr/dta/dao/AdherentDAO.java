package fr.dta.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import fr.dta.globale.DatabaseHelper;
import fr.dta.model.Adherent;
import fr.dta.model.Media;

@Repository
@Transactional
public class AdherentDAO extends DAO<Adherent> {

    public AdherentDAO() {
        super(Adherent.class);
    }
    
    public List<Adherent> getAllAdherent(){
    	TypedQuery<Adherent> query = em.createQuery(" from Adherent",Adherent.class);
		return query.getResultList();
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
	
	public List<Adherent> getAdherentByParams(Optional<Integer> id,Optional<String> nom, Optional<String> prenom,Optional<String> email){
		StringBuilder sb = new StringBuilder("where ");
		if(id.isPresent()){
			sb.append("id=:id AND ");
		}
		
		if(nom.isPresent()){
			sb.append("nom LIKE :nom AND ");
		}
		
		if(prenom.isPresent()){
			sb.append("prenom LIKE :prenom AND ");
		}
		
		if(email.isPresent()){
			sb.append("mail LIKE :email AND ");
		}
		
		if(sb.length()>0)
		{
			sb.delete(sb.length()-5, sb.length());	
		}
		System.out.println(sb.toString());
		TypedQuery<Adherent> query = em.createQuery(" from Adherent "+sb.toString(),Adherent.class);
		if(id.isPresent())
		query.setParameter("id",id.get().longValue());
		if(nom.isPresent())
		query.setParameter("nom", "%"+nom.get()+"%");
		if(prenom.isPresent())
		query.setParameter("prenom", "%"+prenom.get()+"%");
		if(email.isPresent())
		query.setParameter("email", "%"+email.get()+"%");
		List<Adherent> ad = query.getResultList();
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
