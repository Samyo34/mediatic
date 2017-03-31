package fr.dta.model;


import java.util.Date;
import java.util.List;

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
@Table(name="adherent")
public class Adherent {
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)	private Long id;	
	@NotBlank	private String prenom;	
	@NotBlank	private String nom;	
	@Temporal(TemporalType.DATE)	private Date naissance;	
	private String mail;	
	private String adresse;	
	private String ville;	
	private String postal;	
	
//	@OneToMany(mappedBy="adherent")	private List<Emprunt> emprunts;
//	@OneToOne	private Cotisation coti;

	public Adherent() {}

	public Adherent(String prenom, String nom, Date naissance, String mail) {
		this.prenom = prenom;
		this.nom = nom;
		this.naissance = naissance;
		this.mail = mail;
	}
	
	public Adherent(String prenom, String nom, Date naissance, String mail, String adresse, String ville, String postal) {
		this(prenom,nom,naissance,mail);
		this.adresse = adresse;
		this.ville = ville;
		this.postal = postal;
	}
	
	@Override	public String toString() {		return "Adherent [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", naissance=" + naissance + ", mail="+ mail + ", adresse=" + adresse + ", ville=" + ville + ", postal=" + postal + "]";	}

	
	
	public Long getId() {		return id;	}
	public void setId(Long id) {		this.id = id;	}
	public String getPrenom() {		return prenom;	}
	public void setPrenom(String prenom) {		this.prenom = prenom;	}
	public String getNom() {		return nom;	}
	public void setNom(String nom) {		this.nom = nom;	}
	public Date getNaissance() {		return naissance;	}
	public void setNaissance(Date naissance) {		this.naissance = naissance;	}
	public String getMail() {	return mail;	}
	public void setMail(String mail) {		this.mail = mail;	}
	public String getAdresse() {		return adresse;	}
	public void setAdresse(String adresse) {		this.adresse = adresse;	}
	public String getVille() {		return ville;	}
	public void setVille(String ville) {		this.ville = ville;	}
	public String getPostal() {		return postal;	}
	public void setPostal(String postal) {		this.postal = postal;	}
//	public List<Emprunt> getEmprunts() {		return emprunts;	}
//	public void setEmprunts(List<Emprunt> medias) {		this.emprunts = medias;	}
	
}
