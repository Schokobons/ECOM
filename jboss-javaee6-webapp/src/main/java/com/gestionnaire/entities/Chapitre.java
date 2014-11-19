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
	private Vente idVente;
	
	private String number;
	
	private String nb_page;
	
	
	

}
