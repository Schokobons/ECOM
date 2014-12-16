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

import java.util.ArrayList;
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
import com.gestionnaire.entities.Auteur;
import com.gestionnaire.entities.Client;
import com.gestionnaire.entities.Commande;
import com.gestionnaire.entities.Livre;
import com.gestionnaire.entities.Panier;
import com.gestionnaire.registre.ClientRegistration;
import com.gestionnaire.registre.CommandeRegistration;
import com.gestionnaire.registre.PanierRegistration;


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
    private PanierRegistration panierRegistration;
    
    @Inject
    private ClientRegistration clientRegistration;
    
    @Inject
    private CommandeRepository commandeRepository;

    @Inject
    private ClientRepository clientRepository;
			
    private long idCom;
    
    private Client clientAcheteurP;
    
	private Panier paniertmp = null;
	
	public void ajouterPanier() throws Exception {
        try {
        	long idCli = 1;
        	Commande commande = commandeRepository.findById(idCom);
        	
        	//client connecter
        	if (clientAcheteurP != null){
        		commande.setClientAcheteur(clientAcheteurP);
        		
        		//paniertmp = clientAcheteurP.getPanier();
        		paniertmp = clientAcheteurP.getPanier();
        		
        		paniertmp.setListCommande(new ArrayList<Commande>());
        		paniertmp.getListCommande().add(commande);
        		
        		paniertmp.setNbitems(paniertmp.getNbitems()+1);
        		
        		paniertmp.setCouttotal(paniertmp.getCouttotal()+commande.getMontantBase());
        		
        		clientAcheteurP.setPanier(paniertmp);
        		
        		commande.setListCommandePanier(paniertmp);
        		
        		panierRegistration.update(paniertmp);
        		clientRegistration.update(clientAcheteurP);
        		
        	}else{ //client non connecter
        		Client clientInconnu = clientRepository.findById(idCli);
        		commande.setClientAcheteur(clientInconnu);
        		
        	}
        	
        	commandeRegistration.update(commande);
        	
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "ajouter panier", "ajouter panier");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "erreur", "MAJ fail");
            facesContext.addMessage(null, m);
        }
    }
	
	public long getIdCom() {
		return idCom;
	}

	public void setIdCom(long idCom) {
		this.idCom = idCom;
	}

	public Client getClientAcheteurP() {
		return clientAcheteurP;
	}

	public void setClientAcheteurP(Client clientAcheteurP) {
		this.clientAcheteurP = clientAcheteurP;
	}

	public Panier getPaniertmp() {
		return paniertmp;
	}

	public void setPaniertmp(Panier paniertmp) {
		this.paniertmp = paniertmp;
	}

	
}
