package globale;

import dao.MediaDAO;
import dataTest.DataTest;
import model.Emprunt;
import model.Media;

public class Run {

	public static void main(String[] args) {
		
		DataTest dt = new DataTest();
		dt.addMedias(10);
		dt.addAdherents(10);
		dt.addEmprunts();
		MediaDAO mDAO = MediaDAO.instance();
		Media media = mDAO.findOneWithAdherentByID(1L);
		System.out.println(media);
		for (Emprunt emprunt : media.getEmprunts()) {
			System.out.println(emprunt);
		}
	}

}
