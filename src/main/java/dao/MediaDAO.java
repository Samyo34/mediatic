package dao;

import javax.persistence.EntityManager;

import globale.DatabaseHelper;
import model.Media;

public class MediaDAO extends DAO{
	
	public static Media getAdherentByID(Long id){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Media md = em.find(Media.class,id);
		DatabaseHelper.commitTxAndClose(em);
		return md;
	}

}
