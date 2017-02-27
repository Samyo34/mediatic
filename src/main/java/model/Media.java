package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Media {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titre;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MediaType type;
	
	@Column(nullable = false)
	private String auteur;
	
	@Column
	@OneToMany (mappedBy = "media")
	private List<Emprunt> emprunts;
}
