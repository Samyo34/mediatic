package fr.dta.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="media")
public class Media {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
	@NotBlank private String titre;
	@NotBlank @Enumerated(EnumType.STRING) private MediaType type;
	@NotBlank private String auteur;
	
	
	@OneToMany(mappedBy="media")
	private List<Emprunt> emprunts;
	
	public Media() {}
	
	public Media(String titre, MediaType type, String auteur) {
		this.titre = titre;
		this.type = type;
		this.auteur = auteur;
	}

	@Override public String toString() { return "Media [id=" + id + ", titre=" + titre + ", type=" + type + ", auteur=" + auteur + "]"; }

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitre() { return titre; }
	public void setTitre(String titre) { this.titre = titre; }
	public MediaType getType() { return type; }
	public void setType(MediaType type) { this.type = type; }
	public String getAuteur() { return auteur; }
	public void setAuteur(String auteur) { this.auteur = auteur; }

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
}
