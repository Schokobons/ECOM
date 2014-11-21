package com.gestionnaire.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "vente")
public class Vente implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idVente;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[0-9]*", message = "Doit contenir des chiffres")
    private String  nb_pages;
    	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ventes")
	private Client vendeur;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="listeAchats")
	private Panier idPanier;
	
	@OneToMany(mappedBy="idVente")
	private List<Chapitre> chapitres;
	
	@OneToMany(mappedBy="idVente")
	private List<Livre> livres;
	
	
	private float prix;
	
	
	

}
