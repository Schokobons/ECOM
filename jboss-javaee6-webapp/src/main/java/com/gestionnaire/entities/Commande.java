package com.gestionnaire.entities;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity(name = "commande")
@XmlRootElement
@Table
public class Commande implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEnchere;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idVenteLivre")
	private Livre ventelivre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idVenteChapitre")
	private Chapitre venteChapitre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ventesProposer")
	private Client clientCreator;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AchatFait")
	private Client clientAcheteur;
	
	@OneToMany(mappedBy="enchere")
	private List<ListeParticipant> participants;
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Date startDate;	
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Date endDate;
	
	private float nomtantActuel;
	
	private boolean isEnchere;
	
	private float montantBase;

	public Long getIdEnchere() {
		return idEnchere;
	}

	public void setIdEnchere(Long idEnchere) {
		this.idEnchere = idEnchere;
	}

	public Livre getVentelivre() {
		return ventelivre;
	}

	public void setVentelivre(Livre ventelivre) {
		this.ventelivre = ventelivre;
	}

	public Chapitre getVenteChapitre() {
		return venteChapitre;
	}

	public void setVenteChapitre(Chapitre venteChapitre) {
		this.venteChapitre = venteChapitre;
	}

	public Client getClientCreator() {
		return clientCreator;
	}

	public void setClientCreator(Client clientCreator) {
		this.clientCreator = clientCreator;
	}

	public Client getClientAcheteur() {
		return clientAcheteur;
	}

	public void setClientAcheteur(Client clientAcheteur) {
		this.clientAcheteur = clientAcheteur;
	}

	public List<ListeParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ListeParticipant> participants) {
		this.participants = participants;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getNomtantActuel() {
		return nomtantActuel;
	}

	public void setNomtantActuel(float nomtantActuel) {
		this.nomtantActuel = nomtantActuel;
	}

	public boolean isEnchere() {
		return isEnchere;
	}

	public void setEnchere(boolean isEnchere) {
		this.isEnchere = isEnchere;
	}

	public float getMontantBase() {
		return montantBase;
	}

	public void setMontantBase(float montantBase) {
		this.montantBase = montantBase;
	}
	
	
	


}
