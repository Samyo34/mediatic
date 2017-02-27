package dao;

import model.Cotisation;

public class CotisationDAO extends DAO{
	
    private static CotisationDAO dao;

    private CotisationDAO() {
        super(Cotisation.class);
    }

    public static CotisationDAO instance() {
        if (dao == null) {
            dao = new CotisationDAO();
        }
        return dao;
    }
}
