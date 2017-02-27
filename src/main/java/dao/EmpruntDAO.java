package dao;

import model.Emprunt;

public class EmpruntDAO extends DAO<Emprunt>{
	
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
}
