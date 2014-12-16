/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gestionnaire.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.gestionnaire.entities.Auteur;
import com.gestionnaire.entities.Categories;
import com.gestionnaire.entities.Client;
import com.gestionnaire.entities.Commande;
import com.gestionnaire.entities.Livre;
import com.gestionnaire.registre.AuteurRegistration;
import com.gestionnaire.registre.CategoriesRegistration;
import com.gestionnaire.registre.ClientRegistration;
import com.gestionnaire.registre.CommandeRegistration;
import com.gestionnaire.registre.LivreRegistration;


// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class CommandeController {

	
    @Inject
    private FacesContext facesContext;

    @Inject
    private CommandeRegistration commandeRegistration;

    @Produces
    @Named
    private Commande newCommande;
    
    @Inject
    private LivreRegistration livreRegistration;

    @Produces
    @Named
    private Livre newLivreVente;
    
    @Inject
    private AuteurRegistration auteurRegistration;

    private Client clientAcheteur;
    
  
    @Produces
    @Named
    private Auteur newAuteur;
    
    @Inject
    private CategoriesRegistration categoriesRegistration;

    @Produces
    @Named
    private Categories newCategorie;


    
    @PostConstruct
    public void initNewCommande() {
    		newCommande = new Commande();
            newLivreVente = new Livre();
            newAuteur = new Auteur();
            newCategorie = new Categories();
    }

    
    public void register() throws Exception {
        try {
        
        	newCommande.setNomtantActuel(newCommande.getMontantBase());
            newCommande.setEnchere(false);
            
            // ajout de l auteur / livre
            newLivreVente.setAuteurs(new ArrayList<Auteur>());
            newLivreVente.getAuteurs().add(newAuteur);
            newAuteur.setLivres(new ArrayList<Livre>());
            newAuteur.getLivres().add(newLivreVente);
            
            // ajout de la categorie / livre
            newLivreVente.setCategories(new ArrayList<Categories>());
            newLivreVente.getCategories().add(newCategorie);
        	newCategorie.setLivres(new ArrayList<Livre>());
        	newCategorie.getLivres().add(newLivreVente);
        	
        	
        	// enregistrement dans la BDD des livre / categories / auteurs
            auteurRegistration.register(newAuteur);
            categoriesRegistration.register(newCategorie);
            livreRegistration.register(newLivreVente);
            
            newCommande.setVentelivre(newLivreVente); 
            newCommande.setClientAcheteur(clientAcheteur);
        	
        	commandeRegistration.register(newCommande);
        	
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
            
            
            initNewCommande();
            
          // commandeRegistration.register(newCommande);
        
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }
    
    public void registerEnchere() throws Exception {
        try {
        	//Gestion des dates
        	newCommande.setStartDate(Calendar.getInstance());
        	Calendar dateFinCalculée = Calendar.getInstance();
        	dateFinCalculée.add(Calendar.DATE,newCommande.getTempsEnchere());
        	newCommande.setEndDate(dateFinCalculée);
        	
        	
        	newCommande.setNomtantActuel(newCommande.getMontantBase());
            newCommande.setEnchere(true);
            
            // ajout de l auteur / livre
            newLivreVente.setAuteurs(new ArrayList<Auteur>());
            newLivreVente.getAuteurs().add(newAuteur);
            newAuteur.setLivres(new ArrayList<Livre>());
            newAuteur.getLivres().add(newLivreVente);
            
            // ajout de la categorie / livre
            newLivreVente.setCategories(new ArrayList<Categories>());
            newLivreVente.getCategories().add(newCategorie);
        	newCategorie.setLivres(new ArrayList<Livre>());
        	newCategorie.getLivres().add(newLivreVente);
        	
        	
        	// enregistrement dans la BDD des livre / categories / auteurs
            auteurRegistration.register(newAuteur);
            categoriesRegistration.register(newCategorie);
            livreRegistration.register(newLivreVente);
            
            newCommande.setVentelivre(newLivreVente);  	
        	newCommande.setClientAcheteur(clientAcheteur);
        	commandeRegistration.register(newCommande);
        	
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
            
            
            initNewCommande();
        
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }

}
