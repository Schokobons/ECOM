package com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "livre")
public class Livre implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Livre() {
		super();
	}
   
	@Id
	private int idObjet;
	private String nom;
	private int idAuteur;
	private int prix;
	
	public int getIdAuteur() {
		return idAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	
	
}
