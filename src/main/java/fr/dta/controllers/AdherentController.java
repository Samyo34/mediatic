package fr.dta.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/recherche"	, method=RequestMethod.GET)
	public List<Adherent> getAllAdherent(@RequestParam(value="id",required=false) Optional<Integer> id,
										@RequestParam(value="nom",required=false) Optional<String> nom,
										@RequestParam(value="prenom",required=false) Optional<String> prenom,
										@RequestParam(value="mail",required=false) Optional<String> email){
		System.out.println("la "+id+" "+nom+" "+prenom+" "+email);
		System.out.println();
		return adherentService.getAdherentByParams(id, nom, prenom, email);	
	}
	
	@RequestMapping(value={"/recherche/{id}"}	, method=RequestMethod.GET)
	public Adherent getAdherent(@PathVariable(value="id") Long id){
		return adherentService.getByID(id);	
	}
	
	@RequestMapping(path="/creation",method=RequestMethod.POST)
	public void addAdherent(@RequestBody Adherent adherent){
		adherentService.create(adherent);
	}
	
	@RequestMapping(path="/modification",method=RequestMethod.PUT)
	public Adherent updateAdherent(@RequestBody Adherent newAdherent){
		return adherentService.updateAdherent(newAdherent);
	}
	
}
