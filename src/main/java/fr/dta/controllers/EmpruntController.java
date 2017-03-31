package fr.dta.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.dao.EmpruntDAO;
import fr.dta.model.Emprunt;

@RestController
@RequestMapping("/emprunt")
public class EmpruntController {
	
	@Autowired
	private EmpruntDAO service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Emprunt> displayAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Emprunt> displayOne(@PathVariable long id) {
		Emprunt emprunt = service.getByID(id);
		if (emprunt == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(emprunt);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emprunt> create(@Valid @RequestBody Emprunt emprunt, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		service.create(emprunt);
		return ResponseEntity.status(HttpStatus.CREATED).body(emprunt); // what was added
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Emprunt> update(@PathVariable long id, @Valid @RequestBody Emprunt emprunt,
			BindingResult bindingResult)  {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		Emprunt found = service.getByID(id);
		if (found == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		found.setMedia(emprunt.getMedia());
		found.setAdherent(emprunt.getAdherent());
		found.setDateEmprunt(emprunt.getDateEmprunt());
		found.setRetourne(emprunt.isRetourne());
		found.setDateEmprunt(emprunt.getDateRetourPrevu());
		service.udpate(found);
		return ResponseEntity.status(HttpStatus.OK).body(emprunt); // updated data

	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Emprunt> update(@PathVariable long id) {
		Emprunt found = service.getByID(id);
		if (found == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		service.remove(id);
		return ResponseEntity.status(HttpStatus.OK).body(found); // what was removed
	}
}