package globale;

import javax.persistence.EntityManager;

public class Run {

	public static void main(String[] args) {
		EntityManager em = DatabaseHelper.createEntityManager();
		//DatabaseHelper.commitTxAndClose(em);
		
		
	}

}
