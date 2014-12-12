package com.gestionnaire.entities;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAuteur;
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
	public Long getIdAuteur() {
		return idAuteur;
	}
	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
	}
	public List<Livre> getLivres() {
		return livres;
	}
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	public void addLivres(Livre livres) {
		this.livres.add(livres);
	}
	


}
