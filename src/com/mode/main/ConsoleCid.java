package com.mode.main;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mode.entities.Developpeur;
import com.mode.entities.Site;


public class ConsoleCid {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        
        try {
            
            entityManagerFactory = Persistence.createEntityManagerFactory("manytomanydevsite");
            entityManager = entityManagerFactory.createEntityManager();
            
            List<Developpeur> devs = entityManager.createQuery( "from Developpeur", Developpeur.class )
					.getResultList();
            int idDev = 0;
            Scanner s = new Scanner(System.in);
            System.out.println("Donner moi le nom de développeur ? :");
            String nomDev = s.nextLine();
            for( Developpeur d : devs ) {
                if ( d.getNom().equals(nomDev)) idDev = d.getId_dev();
            }
            
            Developpeur cid = entityManager.find( Developpeur.class, idDev );            
            System.out.println( "Sites développés par " + nomDev);
            for( Site site : cid.getSites() ) {
                System.out.println( site.getNom() );
            }

//            Site site = entityManager.find( Site.class, 2 );            
//            System.out.println( "Développeurs qui ont participé pour le site 2" );
//            for( Developpeur associatedDeveloppeur : site.getDeveloppeurs() ) {
//                System.out.println( associatedDeveloppeur.getNom() );
//            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }

    }
}