package globale;

import java.util.Date;

import javax.persistence.EntityManager;

import dao.AdherentDAO;
import dao.EmpruntDAO;
import dao.MediaDAO;
import model.Adherent;
import model.Emprunt;
import model.Media;
import model.MediaType;

public class Run {

	public static void main(String[] args) {
		EntityManager em = DatabaseHelper.createEntityManager();
		
		Adherent ad = new Adherent();
		ad.setNom("Bricas");
		ad.setPrenom("Samuel");
		AdherentDAO.instance().create(ad);
		
		Media m = new Media();
		m.setTitre("Le petit cheval de manège");
		m.setAuteur("Juste Leblanc");
		m.setType(MediaType.LIVRE);
		MediaDAO.instance().create(m);
		Emprunt e = new Emprunt();
		e.setAdherent(ad);
		e.setMedia(m);
		e.setReturn(false);
		Date d =  new Date();
		e.setDateEmprunt(d);
		e.setDateRetourPrevu(d);
		EmpruntDAO.instance().create(e);
		
		Adherent a = AdherentDAO.instance().getAdherentWithEmpruntById(ad.getId());
		for (Emprunt u : a.getEmprunts()) {
			System.out.println(u.getMedia().getTitre());
		}
		
		
		//DatabaseHelper.commitTxAndClose(em);
		
		
	}

}
