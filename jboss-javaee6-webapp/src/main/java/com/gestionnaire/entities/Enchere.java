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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity(name = "enchere")
@XmlRootElement
@Table
public class Enchere implements Serializable {
	

	@Id
	private Long idEnchere;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idLivre")
	private Livre livre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="encheresProposer")
	private Client clientCreator;
	
	@OneToMany(mappedBy="enchere")
	private List<ListeParticipant> participants;
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Date startDate;	
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Date endDate;
	
	private int nomtantActuel;


}
