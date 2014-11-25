
package com.gestionnaire.entities;
		 
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
@Entity(name = "listeParticipant")
@XmlRootElement
@Table
public class ListeParticipant implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="participants")
	private Commande enchere;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="participations")
	private Client client;
	
	private float montantProposer;
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Date timeEncherie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commande getEnchere() {
		return enchere;
	}

	public void setEnchere(Commande enchere) {
		this.enchere = enchere;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float getMontantProposer() {
		return montantProposer;
	}

	public void setMontantProposer(float montantProposer) {
		this.montantProposer = montantProposer;
	}

	public Date getTimeEncherie() {
		return timeEncherie;
	}

	public void setTimeEncherie(Date timeEncherie) {
		this.timeEncherie = timeEncherie;
	}
	
	
    
}
