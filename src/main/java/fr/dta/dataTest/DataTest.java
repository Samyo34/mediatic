package fr.dta.dataTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.dta.dao.AdherentDAO;
import fr.dta.dao.EmpruntDAO;
import fr.dta.dao.MediaDAO;
import fr.dta.model.Adherent;
import fr.dta.model.Cotisation;
import fr.dta.model.Emprunt;
import fr.dta.model.Media;
import fr.dta.model.MediaType;

public class DataTest {
	
	private List<Media> medias;
	private List<Adherent> adherents;
	private List<Emprunt> emprunts;
	private List<Cotisation> cotisations;
	
	public DataTest() {
		medias = new ArrayList<>();
		adherents = new ArrayList<>();
		emprunts = new ArrayList<>();
		cotisations = new ArrayList<>();
	}

	public void addMedias(int number)
	{
		MediaDAO mDAO = MediaDAO.instance();
		for(int i = 1; i < number+1; i++) {
			medias.add(new Media("Titre " + i, MediaType.values()[i%3],"Auteur " + i));
		}
		mDAO.create(medias);
	}
	
	public void addAdherents(int number)
	{
		AdherentDAO aDAO = AdherentDAO.instance();
		for(int i = 1; i < number+1; i++) {
			adherents.add(new Adherent("Prenom " + i,"Nom " + i, new Date(),"Mail " + i));
		}
		aDAO.create(adherents);
	}
	
	public void addEmprunts()
	{
		EmpruntDAO eDAO = EmpruntDAO.instance();
		int compteur = 0;
		for (Adherent adherent : adherents) {
			emprunts.add(new Emprunt(medias.get(compteur),adherent,new Date(),new Date()));
			compteur++;
		}
		eDAO.create(emprunts);
	}
	
}
