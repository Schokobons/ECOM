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

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.Selection;

import com.gestionnaire.data.ClientListProducer;
import com.gestionnaire.data.CommandeListProducer;
import com.gestionnaire.entities.Client;
import com.gestionnaire.entities.Commande;
import com.gestionnaire.entities.Livre;
import com.gestionnaire.registre.CommandeRegistration;


// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://www.cdi-spec.org/faq/#accordion6
@Model
public class LivreAchatController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private CommandeRegistration commandeRegistration;
    
    private CommandeListProducer commandeList;
    private ClientListProducer clientList;

    @Produces
    @Named
    private Livre livre;
    
    @Produces
    @Named
    private Commande commande;
    
    private long idCom;
    private int idCli = 2;
    
    private Client clientAcheteur;

    public void acheter() throws Exception {
        try {
        	commande = commandeList.findCommande(idCom);
        	if(commande == null){
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Achat!", "commande null");
                facesContext.addMessage(null, m);
                System.out.println("pas bon");
        	}
        	clientAcheteur = clientList.findClient(idCli);
        	if(clientAcheteur == null){
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Achat!", "clientAcheteur null");
                facesContext.addMessage(null, m);
                System.out.println("pas bon");
        	}
        	//commande.setClientAcheteur(clientAcheteur);
        	
        	//commandeRegistration.acheter(commande);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Achat!", "Achat reussi");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Achat non fait");
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
