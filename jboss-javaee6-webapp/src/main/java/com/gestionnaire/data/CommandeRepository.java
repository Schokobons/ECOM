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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

import com.gestionnaire.entities.Client;
import com.gestionnaire.entities.Commande;
import com.gestionnaire.entities.Livre;
import com.gestionnaire.entities.Panier;

import java.util.List;


@ApplicationScoped
public class CommandeRepository {

    @Inject
    private EntityManager em;

    public Commande findById(Long id) {
        return em.find(Commande.class, id);
    }

    public List<Object[]> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);
        Root<Commande> commande = criteria.from(Commande.class);
        

        Join<Commande,Livre> li = commande.join("ventelivre",JoinType.LEFT);
        Join<Commande,Client> clientAcheteur = commande.join("clientAcheteur",JoinType.LEFT);
        
        criteria.multiselect(commande,li.get("nom"),clientAcheteur).orderBy(cb.asc(commande.get("ventelivre")));

        //criteria.where(cb.equal(clientAcheteur, null));
        
        TypedQuery<Object[]> tq = em.createQuery(criteria);
        return tq.getResultList();
    }

	public Commande findCommande(long idCommande) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = cb.createQuery(Commande.class);
        Root<Commande> commande = criteria.from(Commande.class);
        criteria.select(commande);
        
        criteria.where(cb.equal(commande.get("idCommande"), idCommande));
		return em.createQuery(criteria).getResultList().get(0);
	}

	public Commande findCommandePanierFor(Panier paniertmp) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = cb.createQuery(Commande.class);
        Root<Commande> commande = criteria.from(Commande.class);
        criteria.select(commande);
        
        criteria.where(cb.equal(commande.get("listCommandePanier"), paniertmp));
		return em.createQuery(criteria).getResultList().get(0);
	}
}
