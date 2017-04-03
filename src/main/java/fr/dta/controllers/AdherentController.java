package fr.dta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.dao.AdherentDAO;
import fr.dta.model.Adherent;
import fr.dta.model.Media;

import fr.dta.dao.EmpruntDAO;
import fr.dta.model.Emprunt;

@RestController
@Repository
@RequestMapping("/resource/adherent")
public class AdherentController {
	
	@Autowired private AdherentDAO adherentService;
	@Autowired private EmpruntDAO empruntService;
	
//	@RequestMapping(path="/recherche/", method=RequestMethod.GET)
//	public List<Adherent> getAllAdherent(@RequestParam("id") Integer id,@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("email") String email){
//		System.out.println("la");
//		return adherentService.getAdherentByParams(id, nom, prenom, email);	
//	}
//	
	@RequestMapping(path="/recherche", method=RequestMethod.GET)
	public List<Adherent> getAllAdherent(){
		System.out.println(adherentService.getAllAdherent());
		List<Adherent> ads =  adherentService.getAllAdherent();
		return ads;
	}
	
	@RequestMapping(path="/recherche/{id}", method=RequestMethod.GET)
	public Adherent getMedia(@PathVariable("id") Long id){
		System.out.println(adherentService.getByID(id));
		return adherentService.getByID(id);
	}
	
	@RequestMapping(path=".creation",method=RequestMethod.POST)
	public void addAdherent(@RequestBody Adherent adherent){
		System.out.println("la2");
		adherentService.create(adherent);
	}
	
	@RequestMapping(path=".modification",method=RequestMethod.PUT)
	public Adherent updateAdherent(@RequestBody Adherent newAdherent){
		return adherentService.updateAdherent(newAdherent);
	}
	
}
