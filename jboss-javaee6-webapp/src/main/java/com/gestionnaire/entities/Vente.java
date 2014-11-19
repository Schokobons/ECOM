package com.gestionnaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "vente")
public class Vente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idVente;
	private int idAcheteur;
	private int idVendeur;
	private int idObjet;
	private int prix;

	public Vente() {
		super();
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

	public int getIdAcheteur() {
		return idAcheteur;
	}

	public void setIdAcheteur(int idAcheteur) {
		this.idAcheteur = idAcheteur;
	}

	public int getIdVendeur() {
		return idVendeur;
	}

	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}
	

}
