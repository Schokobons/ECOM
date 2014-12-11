package com.gestionnaire.registre;

import java.util.logging.Logger;


import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gestionnaire.entities.Auteur;
@Stateless
public class AuteurRegistration {
	@Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Auteur> auteurEventSrc;

    public void register(Auteur auteur) throws Exception {
        log.info("Registering " + auteur.getPrenom() +" "+ auteur.getNom());
        em.persist(auteur);
        auteurEventSrc.fire(auteur);
    }
}
