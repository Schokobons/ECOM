package com.gestionnaire.entities;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity(name = "panier")
@XmlRootElement
@Table
public class Panier implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPanier;

	@NotNull
    private Double coutTotal;

    @NotNull
    private Integer nbItems;
    
	@OneToMany(mappedBy="listCommandePanier")
	private List<Commande> listCommande;
	
	@OneToOne
	private Client clientConteneur;
	
	public Long getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(Long idPanier) {
		this.idPanier = idPanier;
	}

	public Double getCouttotal() {
		return coutTotal;
	}

	public void setCouttotal(Double couttotal) {
		this.coutTotal = couttotal;
	}

	public Integer getNbitems() {
		return nbItems;
	}

	public void setNbitems(Integer nbitems) {
		this.nbItems = nbitems;
	}

	public List<Commande> getListCommande() {
		return listCommande;
	}

	public void setListCommande(List<Commande> listCommande) {
		this.listCommande = listCommande;
	}
    
}
