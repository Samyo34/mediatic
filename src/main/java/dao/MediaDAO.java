package dao;

import javax.persistence.EntityManager;

import globale.DatabaseHelper;
import model.Emprunt;
import model.Media;

public class MediaDAO extends DAO{
	
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
	
	public Media getAdherentByID(Long id){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Media md = em.find(Media.class,id);
		DatabaseHelper.commitTxAndClose(em);
		return md;
	}

}
