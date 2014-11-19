package com.gestionnaire.entities;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "enchere")
public class Enchere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEnchere;
	private int idClientCreator;
	
	private int nomtantActuel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idLivre")
	private Livre livre;
	
	@OneToMany(mappedBy="enchere")
	private List<ListeParticipant> participants;
	
	



}
