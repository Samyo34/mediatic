package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Media {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titre;
	
	@Column(nullable = false)
	private Type type;
	
	@Column(nullable = false)
	private String auteur;
	
	@Column(nullable = false)
	private boolean emprunt_courant;
}
