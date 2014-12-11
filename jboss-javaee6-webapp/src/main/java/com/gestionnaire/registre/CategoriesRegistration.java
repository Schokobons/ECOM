package com.gestionnaire.registre;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gestionnaire.entities.Categories;

@Stateless
public class CategoriesRegistration {
	@Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Categories> categoriesEventSrc;

    public void register(Categories categories) throws Exception {
        log.info("Registering " + categories.getNom());
        em.persist(categories);
        categoriesEventSrc.fire(categories);
    }
}
