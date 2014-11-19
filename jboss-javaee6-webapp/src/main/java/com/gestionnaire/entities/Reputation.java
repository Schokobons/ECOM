package com.gestionnaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "reputation")
public class Reputation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idReputation;

	public Reputation() {
		super();
	}

}
