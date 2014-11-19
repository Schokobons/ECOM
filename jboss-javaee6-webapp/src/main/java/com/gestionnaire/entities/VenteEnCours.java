package com.gestionnaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "venteEnCours")
public class VenteEnCours implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idVente;
	private int idClient;
	private int idObjet;
	private int prix;

	public VenteEnCours() {
		super();
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdObjet() {
		return idObjet;
	}

	public void setIdObjet(int idObjet) {
		this.idObjet = idObjet;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	

}
