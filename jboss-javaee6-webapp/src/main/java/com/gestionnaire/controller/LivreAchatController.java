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

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.Selection;

import com.bean.LoginBean;
import com.gestionnaire.data.ClientListProducer;
import com.gestionnaire.data.ClientRepository;
import com.gestionnaire.data.CommandeListProducer;
import com.gestionnaire.data.CommandeRepository;
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
    
    @Inject
    private CommandeRepository commandeRepository;
    
    @Inject
    private ClientRepository clientRepository;
    
    private Client clientAcheteur;

    private long idCom;
    
    private boolean infoLivre = false;
    
    private Commande commandeInfo; 
        	
    public void acheter() throws Exception {
        try {
        	long idCli = 1;
        	Commande commande = commandeRepository.findById(idCom);
        	//Client clientAcheteur = clientRepository.findById(idCli);
        	

        	//commande.setClientAcheteur(clientAcheteur);
        	//clientAcheteur = loginBean.getClientConnect();
        	if (clientAcheteur != null)
        		commande.setClientAcheteur(clientAcheteur);
        	else 
        		commande.setClientAcheteur(clientRepository.findById(idCli));
        	
        	commandeRegistration.update(commande);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Achat!", "Achat reussi");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "MAJ fail");
            facesContext.addMessage(null, m);
        }
    }
    
    public void info() throws Exception {
        try {

        	infoLivre = true;

        	commandeInfo = commandeRepository.findById(idCom);
        	
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "info");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "MAJ fail");
            facesContext.addMessage(null, m);
        }
    }
    
    public Commande getCommandeInfo() {
		return commandeInfo;
	}

	public void setCommandeInfo(Commande commandeInfo) {
		this.commandeInfo = commandeInfo;
	}

	public boolean isInfoLivre() {
		return infoLivre;
	}

	public void setInfoLivre(boolean infoLivre) {
		this.infoLivre = infoLivre;
	}

	public void acheter(long id) throws Exception {
        try {
        	idCom =id;
        	long idCli = 1;
        	Commande commande = commandeRepository.findById(idCom);
        	Client clientAcheteur = clientRepository.findById(idCli);

        	commande.setClientAcheteur(clientAcheteur);
        	
        	commandeRegistration.update(commande);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Achat!", "Achat reussi");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "MAJ fail");
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

	public long getIdCom() {
		return idCom;
	}

	public void setIdCom(long idCom) {
		this.idCom = idCom;
	}

	public Client getClientAcheteur() {
		return clientAcheteur;
	}

	public void setClientAcheteur(Client clientAcheteur) {
		this.clientAcheteur = clientAcheteur;
	}

	
}
