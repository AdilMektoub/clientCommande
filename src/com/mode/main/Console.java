package com.mode.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mode.entities.Developpeur;
import com.mode.entities.Site;


public class Console {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        
        try {
            
            entityManagerFactory = Persistence.createEntityManagerFactory("manytomanydevsite");
            entityManager = entityManagerFactory.createEntityManager();
        
            Developpeur cid = entityManager.find( Developpeur.class, 1 );            
            System.out.println( "Site associés à Cid" );
            for( Site site : cid.getSites() ) {
                System.out.println( site.getNom() );
            }
            System.out.println("-----------------------");
            Site site = entityManager.find( Site.class, 2 );            
            System.out.println( "Développeurs qui ont participé pour le site 2" );
            for( Developpeur associatedDeveloppeur : site.getDeveloppeurs() ) {
                System.out.println( associatedDeveloppeur.getNom() );
            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }

    }
}