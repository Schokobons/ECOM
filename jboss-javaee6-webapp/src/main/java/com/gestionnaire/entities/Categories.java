package com.gestionnaire.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity(name = "categories")
@XmlRootElement
@Table
public class Categories implements Serializable {


	@Id
	private Long idCategories;
	private String nom;
	
	@ManyToMany(mappedBy="categories")
	private List<Livre> livres;

	public Long getIdCategories() {
		return idCategories;
	}

	public void setIdCategories(Long idCategories) {
		this.idCategories = idCategories;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	

	


}
