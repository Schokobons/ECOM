/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
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

import java.util.List;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.Selection;

import com.gestionnaire.data.ClientListProducer;
import com.gestionnaire.data.ClientRepository;
import com.gestionnaire.data.CommandeListProducer;
import com.gestionnaire.data.CommandeRepository;
import com.gestionnaire.data.PanierRepository;
import com.gestionnaire.entities.Client;
import com.gestionnaire.entities.Commande;
import com.gestionnaire.entities.Livre;
import com.gestionnaire.entities.Panier;
import com.gestionnaire.registre.ClientRegistration;
import com.gestionnaire.registre.CommandeRegistration;


// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://www.cdi-spec.org/faq/#accordion6
@Model
public class PanierController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private PanierRepository panierRepository;
    
    @Inject
    private CommandeRegistration commandeRegistration;
    
    @Inject
    private CommandeRepository commandeRepository;

	private boolean connecter= true;
	
	private long idCli = 1;
	
	private long idPanier = 1;
	
    private long idCom;
	
	public void ajouterPanier() throws Exception {
        try {
        	
        	Panier panier = panierRepository.findById(idPanier);

        	Commande commande = commandeRepository.findById(idCom);
        	
        	List<Commande> listCommande = panier.getListCommande();
        	listCommande.add(commande);
        	
        	commandeRegistration.update(commande);
        	
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Achat!", "Achat reussi");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "erreur", "MAJ fail");
            facesContext.addMessage(null, m);
        }
    }
	
}