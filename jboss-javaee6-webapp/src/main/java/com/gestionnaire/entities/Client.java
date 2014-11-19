
package com.gestionnaire.entities;
		 
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
@Entity(name = "client")
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Client implements Serializable {

	 @Id
    @GeneratedValue
    private Long idClient;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String nom;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String prenom;

	@NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)
    @Column(name = "telephone")
    private String telephone;


	@OneToMany(mappedBy="client")
	private List<ListeParticipant> participations;
	
	@OneToMany(mappedBy="clientCreator")
	private List<Enchere> encheresProposer;
	
	@OneToMany(mappedBy="acheteur")
	private List<Panier> achats;
	
	@OneToMany(mappedBy="vendeur")
	private List<Vente> ventes;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<ListeParticipant> getParticipations() {
		return participations;
	}

	public void setParticipations(List<ListeParticipant> participations) {
		this.participations = participations;
	}

	public List<Enchere> getEncheres() {
		return encheresProposer;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheresProposer = encheres;
	}
	
	
	
	
}
