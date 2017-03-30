package fr.dta.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dta.dao.AdherentDAO;
import fr.dta.model.Adherent;

@Controller
@RequestMapping("/resource/adherent")
public class AdherentController {

	@Autowired private AdherentDAO adherentService;
	
	@RequestMapping(path=".recherche?id={id}&nom={nom}&prenom={prenom}&email={email}", method = RequestMethod.GET)
	public List<Adherent> getAllAdherent(@PathVariable Integer id,@PathVariable String nom, @PathVariable String prenom, @PathVariable String email){
		return adherentService.getAllAdherent();
	}
	

	
}
