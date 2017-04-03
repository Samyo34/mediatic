package fr.dta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Media> getAllMedias(){
		System.out.println(mediaService.getAllMedias());
		return mediaService.getAllMedias();
	}
	
	@RequestMapping(path="/recherche/{id}", method=RequestMethod.GET)
	public Media getMedia(@PathVariable("id") Long id){
		System.out.println(mediaService.getByID(id));
		return mediaService.getByID(id);
	}
	
	/*@RequestMapping(path="/creation",method=RequestMethod.POST)
	public void addAdherent(@RequestBody Media media){
		System.out.println(mediaService.getAllMedias());
		mediaService.create(media);
	}
	
	@RequestMapping(path=".modification",method=RequestMethod.PUT)
	public Adherent updateAdherent(@RequestBody Adherent newAdherent){
		return adherentService.updateAdherent(newAdherent);
	}*/
	
}
