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
package com.gestionnaire.registre;


import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gestionnaire.entities.Client;

import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateful
public class Authentification {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Client> clientEventSrc;
    
    private Client clientConnecteko;
    

	public int login(String email, String password) throws Exception{
		/*
		log.info("Connection " + client.getEmail());
        em.persist(client);
        clientEventSrc.fire(client);	*/
		return 0;
	}
	
	public void logout()throws Exception{
		
	
	}
	
	
	
}
