package model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="adherent",uniqueConstraints=@UniqueConstraint(columnNames = {"mail"}))
public class Adherent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String prenom;
	
	@NotBlank
	private String nom;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date naissance;
	
	@Column
	private String mail;
	
	@Column
	private String adresse;
	
	@Column
	private String ville;
	
	@Column
	private String postal;
	
	@OneToMany(mappedBy="adherent")
	private List<Emprunt> emprunts;
	
	@OneToOne
	private Cotisation coti;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> medias) {
		this.emprunts = medias;
	}
	
	
	
}
