
package com.gestionnaire.entities;
		 
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "listeParticipant")
@XmlRootElement
@Table
public class ListeParticipant implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="participants")
	private Enchere enchere;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="participations")
	private Client client;
	
	private float valeurProposer;
	
	@Temporal(TemporalType.TIMESTAMP)
    protected Date timeEncherie;
	
	
    
}
