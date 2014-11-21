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
@Entity
@XmlRootElement
@Table
public class Livre implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idLivre;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String name;
   

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[0-9]*", message = "Doit contenir des chiffres")
    private String  nb_pages;
    	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="venteLivre")
	private Vente idVente;
	
	@OneToMany(mappedBy="livre")
	private List<Chapitre> chapitres;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNb_pages() {
		return nb_pages;
	}

	public void setNb_pages(String nb_pages) {
		this.nb_pages = nb_pages;
	}

	public Vente getIdVente() {
		return idVente;
	}

	public void setIdVente(Vente idVente) {
		this.idVente = idVente;
	}

	public List<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(List<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}
	

    
    
}
