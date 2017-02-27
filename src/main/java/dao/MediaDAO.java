package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import globale.DatabaseHelper;
import model.Adherent;
import model.Cotisation;
import model.Media;

public class MediaDAO extends DAO {

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
	
//	private List<Media> getMediasByTitle(String title){
//		EntityManager em = DatabaseHelper.createEntityManager();
//		DatabaseHelper.beginTx(em);
//		TypedQuery<Adherent> query = em.createQuery("select m "+
//				"from Media m "+
//				"where m.titre =:title",Adherent.class);
//		query.setParameter("title", title);
//		List<Adherent> ad = query.getResultList();
//		DatabaseHelper.commitTxAndClose(em);
//		return ad;		
//	}

}