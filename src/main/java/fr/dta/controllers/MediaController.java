package fr.dta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.dao.MediaDAO;
import fr.dta.model.Media;

@RestController
@Repository
@RequestMapping("/resource/media")
public class MediaController {
	
	@Autowired private MediaDAO mediaService;
	
	@RequestMapping(path="/recherche", method=RequestMethod.GET)
	public List<Media> getAllMedia(){
		System.out.println(mediaService.getAllMedias());
		return mediaService.getAllMedias();
	}
	
	/*@RequestMapping(path=".creation",method=RequestMethod.POST)
	public void addAdherent(@RequestBody Adherent adherent){
		System.out.println("la2");
		adherentService.create(adherent);
	}
	
	@RequestMapping(path=".modification",method=RequestMethod.PUT)
	public Adherent updateAdherent(@RequestBody Adherent newAdherent){
		return adherentService.updateAdherent(newAdherent);
	}*/
	
}
