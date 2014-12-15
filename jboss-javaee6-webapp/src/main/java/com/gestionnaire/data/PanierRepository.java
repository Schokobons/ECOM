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
public class PanierRepository {

    @Inject
    private EntityManager em;

    public Panier findById(Long id) {
        return em.find(Panier.class, id);
    }

    public List<Object[]> findPanierFor(long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);
        Root<Panier> panier = criteria.from(Panier.class);
        
        Join<Panier,Commande> listCommande = panier.join("listCommandePanier",JoinType.LEFT);
        Join<Commande,Livre> listlivre = panier.join("ventelivre",JoinType.LEFT);
        criteria.where(cb.equal(panier.get("clientConteneur"), id));
        criteria.multiselect(panier,listCommande,listlivre).orderBy(cb.asc(panier.get("idCommande")));

        TypedQuery<Object[]> tq = em.createQuery(criteria);
        return tq.getResultList();
    }
    
    public List<Object[]> findAllPanier() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);
        Root<Commande> commande = criteria.from(Commande.class);
        
        Join<Commande,Panier> listpanier = commande.join("listCommande",JoinType.LEFT);
        
        criteria.multiselect(listpanier,commande).orderBy(cb.asc(commande.get("idCommande")));

        TypedQuery<Object[]> tq = em.createQuery(criteria);
        return tq.getResultList();
    }

}
