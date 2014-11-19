package com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "categories")
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;

	public Categories() {
		super();
	}
	

	@Id
	private String nom;
	private int idObjet;
	
	public int getIdObjet() {
		return idObjet;
	}
	public void setIdObjet(int idObjet) {
		this.idObjet = idObjet;
	}



}
