package com.gestionnaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table
public class Categories implements Serializable {


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
