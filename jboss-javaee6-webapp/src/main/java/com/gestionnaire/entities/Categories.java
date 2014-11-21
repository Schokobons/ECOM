package com.gestionnaire.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity(name = "categories")
@XmlRootElement
@Table
public class Categories implements Serializable {


	@Id
	private Long idCategories;
	private String nom;
	
	@ManyToMany(mappedBy="categories")
	private List<Livre> livres;
	



}
