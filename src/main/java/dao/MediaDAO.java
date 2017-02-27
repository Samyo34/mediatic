package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import globale.DatabaseHelper;
import model.Adherent;
import model.Media;

public class MediaDAO extends DAO{
	
	public static Media getMediaByID(Long id){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Media md = em.find(Media.class,id);
		DatabaseHelper.commitTxAndClose(em);
		return md;
	}

	public static Media findOneWithAdherent(Long id){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Media md = em.find(Media.class,id);
		DatabaseHelper.commitTxAndClose(em);
		return md;
	}
	
}
