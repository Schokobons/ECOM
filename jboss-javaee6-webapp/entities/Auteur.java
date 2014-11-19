package com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "auteur")
public class Auteur implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Auteur() {
		super();
	}
	
	@Id
	private int idAuteur;
	private String nom;
	private String prenom;


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


}
