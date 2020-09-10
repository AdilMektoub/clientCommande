package com.mode.console.H;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mode.entities.H.Client;
import com.mode.entities.H.Commande;
import com.mode.entities.H.Compte;


public class ConsoleJPA {
	

    public static void main(String[] args) throws Exception {
    	
        EntityManagerFactory entityManagerFactory = null;
        EntityManager em = null;

        Client nga = new Client("Nga", "nga@pop.fr", "0000", 30, null, null);
        Client seb = new Client( "Sébastien", "seb@pop.fr", "0000", 32, null , null);
        
        Commande cmd1 = new Commande("Chaussure", 2, 100, new Date(), seb);
        Commande cmd2 = new Commande("Nike", 20, 200, new Date(), seb);

        List<Commande> commandesDeSeb = new ArrayList<>();
        commandesDeSeb.add(cmd1);   commandesDeSeb.add(cmd2);  
        
        seb.setCommandes(commandesDeSeb);
        
        Commande cmd3 = new Commande("Chaussure de nga", 2, 100, new Date(), nga);
        Commande cmd4 = new Commande("Adidas", 20, 200, new Date(), nga);

        List<Commande> commandesDeNga = new ArrayList<>();
        commandesDeNga.add(cmd3);   commandesDeNga.add(cmd4);  
        
        nga.setCommandes(commandesDeNga);
        
        Compte c1 = new Compte("le compte de Seb", 300);
        Compte c2 = new Compte("le compte de Nga", 3000);
        
        nga.setCompte(c2);
        seb.setCompte(c1);
        
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ClientCommandeJPA");
            em = entityManagerFactory.createEntityManager();

          EntityTransaction trans = em.getTransaction();
          trans.begin(); 
          em.persist(seb);
          em.persist(nga);
          trans.commit();

        } finally {
            if ( em != null ) em.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}


