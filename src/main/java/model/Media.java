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
import javax.validation.constraints.NotNull;

@Entity
public class Media {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String titre;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private MediaType type;
	
	@NotNull
	private String auteur;
	
	@OneToMany (mappedBy = "media")
	private List<Emprunt> emprunts;
}
