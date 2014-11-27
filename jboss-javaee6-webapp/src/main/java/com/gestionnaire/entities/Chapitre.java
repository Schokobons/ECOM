package com.gestionnaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity(name = "chapitre")
@XmlRootElement
@Table
public class Chapitre implements Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idChapitre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="chapitres")
	private Livre livre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="venteChapitre")
	private Commande idVenteChapitre;
	
	private String numeroChapitre;
	
	private String nbPages;

	public Long getIdChapitre() {
		return idChapitre;
	}

	public void setIdChapitre(Long idChapitre) {
		this.idChapitre = idChapitre;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Commande getIdVenteChapitre() {
		return idVenteChapitre;
	}

	public void setIdVenteChapitre(Commande idVenteChapitre) {
		this.idVenteChapitre = idVenteChapitre;
	}

	public String getNumeroChapitre() {
		return numeroChapitre;
	}

	public void setNumeroChapitre(String numeroChapitre) {
		this.numeroChapitre = numeroChapitre;
	}

	public String getNbPages() {
		return nbPages;
	}

	public void setNbPages(String nbPages) {
		this.nbPages = nbPages;
	}

	
	
	
	
	

}
