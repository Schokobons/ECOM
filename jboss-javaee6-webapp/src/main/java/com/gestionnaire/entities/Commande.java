package com.gestionnaire.entities;

import java.util.Calendar;
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
	private Long idCommande;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="listCommande")
	private Panier listCommandePanier;
	
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
    protected Calendar startDate;	
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Calendar endDate;
	
	private float nomtantActuel;
	
	private int tempsEnchere;
	
	private boolean isEnchere;
	
	private float montantBase;
	
	private String image;

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
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

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Panier getListCommandePanier() {
		return listCommandePanier;
	}

	public void setListCommandePanier(Panier listCommandePanier) {
		this.listCommandePanier = listCommandePanier;
	}

	public int getTempsEnchere() {
		return tempsEnchere;
	}

	public void setTempsEnchere(int tempsEnchere) {
		this.tempsEnchere = tempsEnchere;
	}

}
