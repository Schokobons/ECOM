--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.

-- You can use this file to load seed data into the database using SQL statements
-- insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 


insert into Client (nom,prenom, email, telephone,password) values ('Inconnu', 'Smith', 'john.smith@mailinator.com', '2125551212','test') ;
insert into Client (nom,prenom, email, telephone,password) values ('Alex', 'Mo', 'alex@gmail.com', '04040404','test') ;

insert into Panier (clientConteneur_idClient,coutTotal,nbItems) values (1,55,3);

insert into Livre (nom,nbPages) values ('Le chemin de la vie', 175) ;
insert into Livre (nom,nbPages) values ('Le chemin de la mort', 220) ;
insert into Livre (nom,nbPages) values ('Le retour de Gandhi', 1500) ;
insert into Livre (nom,nbPages) values ('Un enfant qui savait lire', 53) ;
insert into Commande (endDate,image,isEnchere,montantBase,nomtantActuel,startDate,AchatFait,ventesProposer,idVenteLivre,listCommande) values ('2010-12-02', 'jdhsfdl', 1 , 73,73,'2010-12-02',2 ,2,1,1);
insert into commande (endDate,image,isEnchere,montantBase,nomtantActuel,startDate,ventesProposer,idVenteLivre,listCommande) values ('2010-12-02', 'tutu', 0 , 34,34,'2010-12-02' ,2,2,1);
insert into commande (endDate,image,isEnchere,montantBase,nomtantActuel,startDate,ventesProposer,idVenteLivre,listCommande) values ('2010-12-02', 'titi', 0 , 33,33,'2010-12-02' ,1,3,1);
insert into commande (endDate,image,isEnchere,montantBase,nomtantActuel,startDate,ventesProposer,idVenteLivre,listCommande) values ('2010-12-02', 'toto', 1 , 383,383,'2010-12-02' ,1,4,1);


