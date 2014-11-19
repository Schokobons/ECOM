package com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "enchere")
public class Enchere implements Serializable {
	private static final long serialVersionUID = 1L;

	public Enchere() {
		super();
	}
	

	public int getIdEnchere() {
		return IdEnchere;
	}
	public void setIdEnchere(int idEnchere) {
		IdEnchere = idEnchere;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public int getNomtantActuel() {
		return nomtantActuel;
	}


	public void setNomtantActuel(int nomtantActuel) {
		this.nomtantActuel = nomtantActuel;
	}


	public int getIdObjet() {
		return idObjet;
	}


	public void setIdObjet(int idObjet) {
		this.idObjet = idObjet;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	@Id
	private int numEnchere;
	private int IdEnchere;
	private int idClient;
	private int nomtantActuel;
	private int idObjet;
	private String dateFin;


}
