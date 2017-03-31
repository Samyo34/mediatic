package fr.dta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.dao.AdherentDAO;
import fr.dta.model.Adherent;

@RestController
@Repository
@RequestMapping("/resource/adherent")
public class AdherentController {
	
	@Autowired private AdherentDAO adherentService;
	
//	@RequestMapping(path="/recherche/", method=RequestMethod.GET)
//	public List<Adherent> getAllAdherent(@RequestParam("id") Integer id,@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("email") String email){
//		System.out.println("la");
//		return adherentService.getAdherentByParams(id, nom, prenom, email);	
//	}
//	
	@RequestMapping(path="/recherche", method=RequestMethod.GET)
	public List<Adherent> getAllAdherent(){
		System.out.println("la");
		return adherentService.getAllAdherent();
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
