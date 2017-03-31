//package fr.dta.globale;
//
//import fr.dta.dao.MediaDAO;
//import fr.dta.dataTest.DataTest;
//import fr.dta.model.Emprunt;
//import fr.dta.model.Media;
//
//public class Run {
//
//	public static void main(String[] args) {
//		
//		DataTest dt = new DataTest();
//		dt.addMedias(10);
//		dt.addAdherents(10);
//		dt.addEmprunts();
//		MediaDAO mDAO = MediaDAO.instance();
//		Media media = mDAO.findOneWithAdherentByID(1L);
//		System.out.println(media);
////		for (Emprunt emprunt : media.getEmprunts()) {
////			System.out.println(emprunt);
////		}
//	}
//
//}
