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
	private boolean isReturn = false;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateRetourPrevu;
	
	
	
}
