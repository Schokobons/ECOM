package com.gestionnaire.entities;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "enchere")
public class Enchere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEnchere;
	
	private int nomtantActuel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idLivre")
	private Livre livre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="encheres")
	private Client clientCreator;
	
	@OneToMany(mappedBy="enchere")
	private List<ListeParticipant> participants;
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Date startDate;	
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Date endDate;


}
