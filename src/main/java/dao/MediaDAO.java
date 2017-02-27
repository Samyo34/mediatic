package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import globale.DatabaseHelper;
import model.Media;

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

}