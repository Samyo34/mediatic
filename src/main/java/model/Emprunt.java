package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	private Media media;
	
	@NotNull
	@ManyToOne
	private Adherent adherent;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateEmprunt;
	
	@NotNull
	private boolean estRetourne = false;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateRetourPrevu;

	public Emprunt(){}
	
	public Emprunt(Media media, Adherent adherent, Date dateEmprunt, Date dateRetourPrevu) {
		this.media = media;
		this.adherent = adherent;
		this.dateEmprunt = dateEmprunt;
		this.estRetourne = false;
		this.dateRetourPrevu = dateRetourPrevu;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", media=" + media + ", adherent=" + adherent + ", dateEmprunt=" + dateEmprunt
				+ ", estRetourne=" + estRetourne + ", dateRetourPrevu=" + dateRetourPrevu + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public boolean estRetourne() {
		return estRetourne;
	}

	public void setRetourne(boolean estRetourne) {
		this.estRetourne = estRetourne;
	}

	public Date getDateRetourPrevu() {
		return dateRetourPrevu;
	}

	public void setDateRetourPrevu(Date dateRetourPrevu) {
		this.dateRetourPrevu = dateRetourPrevu;
	}
	
	
	
}
