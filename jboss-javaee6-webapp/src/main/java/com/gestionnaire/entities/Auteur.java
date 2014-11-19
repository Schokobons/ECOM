package com.gestionnaire.entities;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@Entity(name = "auteur")
@XmlRootElement
@Table
public class Auteur implements Serializable {
	
	
	@Id
	private int idAuteur;
	private String nom;
	private String prenom;
	
	@ManyToMany(mappedBy="auteurs")
	private List<Livre> livres;


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
