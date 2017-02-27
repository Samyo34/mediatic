package dao;

import javax.persistence.EntityManager;

import globale.DatabaseHelper;
import model.Emprunt;

public class EmpruntDAO extends DAO{
	
    private static EmpruntDAO dao;

    private EmpruntDAO() {
        super(Emprunt.class);
    }

    public static EmpruntDAO instance() {
        if (dao == null) {
            dao = new EmpruntDAO();
        }
        return dao;
    }

	
	public Emprunt getEmpruntByID(Long id){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Emprunt ad = em.find(Emprunt.class,id);
		DatabaseHelper.commitTxAndClose(em);
		return ad;
	}

}
