package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import globale.DatabaseHelper;
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

	

	public Media findOneWithAdherent(Long id) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Media> query = em.createQuery(
				"select m" + 
				"from Media m"
				, Media.class);
		Media md = em.find(Media.class, id);
		DatabaseHelper.commitTxAndClose(em);
		return md;
	}

}