package com.gestionnaire.entities;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity(name = "livre")
@XmlRootElement
@Table
public class Livre implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idLivre;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String nom;
   

  
    private int  nbPages;
	
	@OneToMany(mappedBy="livre")
	private List<Chapitre> chapitres;
	
	@OneToMany(mappedBy="ventelivre")
	private List<Commande> idVenteLivre;
	
	@ManyToMany
	@JoinTable(
	      name="livreAuteur",
	      joinColumns={@JoinColumn(name="id_Livre", referencedColumnName="idLivre")},
	      inverseJoinColumns={@JoinColumn(name="id_Auteur", referencedColumnName="idAuteur")})
	  private List<Auteur> auteurs;
	
	@ManyToMany
	@JoinTable(
	      name="livreCategories",
	      joinColumns={@JoinColumn(name="id_Livre", referencedColumnName="idLivre")},
	      inverseJoinColumns={@JoinColumn(name="id_Categories", referencedColumnName="idCategories")})
	private List<Categories> categories;

	public Long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Long idLivre) {
		this.idLivre = idLivre;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public List<Commande> getIdVenteLivre() {
		return idVenteLivre;
	}

	public void setIdVenteLivre(List<Commande> idVenteLivre) {
		this.idVenteLivre = idVenteLivre;
	}

	public List<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(List<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public void addAuteurs(Auteur newAuteur) {
		auteurs.add(newAuteur);		
	}

	public void addCategories(Categories newCategorie) {
		categories.add(newCategorie);		
	}
	
	
    
    
}
