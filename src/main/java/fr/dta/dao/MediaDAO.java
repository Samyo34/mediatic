package fr.dta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.dta.globale.DatabaseHelper;
import fr.dta.model.Adherent;
import fr.dta.model.Cotisation;
import fr.dta.model.Media;

public class MediaDAO extends DAO<Media> {

	private static MediaDAO dao;

	private MediaDAO() {
		super(Media.class);
	}

	public static MediaDAO instance() {
		if (dao == null) {
			dao = new MediaDAO();
		}
		return dao;
	}

	public List<Media> getAllMedias(){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Media> query = em.createQuery("from Media",Media.class);
		List<Media> med = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return med;
	}
	
	public Media findOneWithAdherentByID(Long id) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Media> query = em.createQuery(
				  "select m "
				+ "from Media m "
				+ "left join fetch m.emprunts e "
				+ "left join fetch e.adherent a "
				+ "where m.id =:id"
				, Media.class);
		query.setParameter("id", id);
		Media md = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return md;
	}
	
	/**
	 * return all the media borrow by the adherent given in parameters
	 * 
	 * @param a
	 * @return List<Media>
	 */
	private List<Media> getMediasByAdherent(Adherent a){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Media> query = em.createQuery("select m "+
				"from Media m "+
				"inner join emprunt e"+
				"where e.adherent =:id",Media.class);
		query.setParameter("id", a.getId());
		List<Media> med = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return med;
	}
	

}