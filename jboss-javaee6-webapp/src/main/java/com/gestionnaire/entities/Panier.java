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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table
public class Panier implements Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPanier;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="achats")
	private Client acheteur;
		
	@OneToMany(mappedBy="idPanier")
	private List<Vente> listeAchats;
		
	private float prixTotal;

	



}
