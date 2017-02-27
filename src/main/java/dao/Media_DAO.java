package dao;

import javax.persistence.EntityManager;

import globale.DatabaseHelper;
import model.Adherent;

public class Media_DAO {
	
	public static void createAdherent(Adherent ad){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(ad);
		DatabaseHelper.commitTxAndClose(em);
	}

}
