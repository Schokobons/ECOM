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
package com.gestionnaire.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.bean.LoginBean;
import com.gestionnaire.entities.Commande;
import com.gestionnaire.entities.Livre;

import java.util.List;

@Named
@RequestScoped
public class RechercheProducer {

    @Inject
    private CommandeRepository commandeRepository;
    

    private List<Object[]> commandesRecherche;
    private List<Livre> livreRecherche;
    

    
    private String recherche;
    

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.
    // Facelets or JSP view)
    @Produces
    @Named
    public List<Object[]> getCommandesRecherche() {
        return commandesRecherche;
    }
    
    @Produces
    @Named
    public List<Livre> getlivreRecherche() {
        return livreRecherche;
    }

    public void onCommandeListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Commande commande) {
        retrieveAllCommandesOrderedByName();
    }

    @PostConstruct
    public void retrieveAllCommandesOrderedByName() {
    	/*RechercheController rechercheController = (RechercheController) FacesContext.getCurrentInstance().
    			getExternalContext().getRequestMap().get("rechercheController");
    	if ( rechercheController != null)
    		recherche = rechercheController.getRecherche();
    	else
    		recherche = "le";*/
    	if (recherche == null || recherche == "")
    		recherche = null;
    	commandesRecherche = commandeRepository.findAllWhere(recherche);
    	livreRecherche = commandeRepository.findLivreWhere(recherche);
    }

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
    
    
    
}
