package fr.dta.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import fr.dta.model.Adherent;
import fr.dta.model.Media;

@Repository
@Transactional
public class MediaDAO extends DAO<Media> {

	public MediaDAO() {
		super(Media.class);
	}

	public List<Media> getAllMedias(){
		TypedQuery<Media> query = em.createQuery(" from Media",Media.class);
		return query.getResultList();
	}
	
	public Media findOneWithAdherentByID(Long id) {
		TypedQuery<Media> query = em.createQuery(
				  "select m "
				+ "from Media m "
				+ "left join fetch m.emprunts e "
				+ "left join fetch e.adherent a "
				+ "where m.id =:id"
				, Media.class);
		query.setParameter("id", id);
		Media md = query.getSingleResult();
		return md;
	}
	
	/**
	 * return all the media borrow by the adherent given in parameters
	 * 
	 * @param a
	 * @return List<Media>
	 */
	public List<Media> getMediasByAdherent(Adherent a){
		TypedQuery<Media> query = em.createQuery("select m "+
				"from Media m "+
				"inner join emprunt e"+
				"where e.adherent =:id",Media.class);
		query.setParameter("id", a.getId());
		List<Media> med = query.getResultList();
		return med;
	}
	

}