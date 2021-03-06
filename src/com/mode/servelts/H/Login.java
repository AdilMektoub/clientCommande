package com.mode.servelts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mode.entities.Client;
import com.mode.entities.Commande;
import com.mode.entities.Compte;
import com.mode.entities.Voiture;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute( "nom", "" );
		request.setAttribute( "password", "" );
		request.setAttribute( "errorMessage", "" );
		request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter( "txtEmail" );
		String password = request.getParameter( "txtPassword" );	
		List<Commande> commandesClient = new ArrayList<Commande>();
		List<Voiture> voituresClient = new ArrayList<Voiture>();
	
		request.setAttribute( "email", email );
		request.setAttribute( "password", password );
		
		Client connectedClient = null ;
		Compte CompteDeClientConnecte =null;
		
        EntityManagerFactory entityManagerFactory = null;
        EntityManager em = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ClientCommandeJPA");
            em = entityManagerFactory.createEntityManager();
            
            List<Client> clients = em.createQuery( "from Client", Client.class ).getResultList();
            
            for (Client client : clients) {
				
            	if ( email.equals(client.getEmail()) && password.equals(client.getPassword())) {
            		
            		connectedClient = client;
            		commandesClient = client.getCommandes();
            		CompteDeClientConnecte = client.getCompte();
            		voituresClient = client.getVoitures();
            	}		
			}   
            
            System.out.println(commandesClient);

        } finally {
            if ( em != null ) em.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
		
		if ( connectedClient != null ) {

			HttpSession session = request.getSession( true );
			session.setAttribute( "connectedClient", connectedClient );
			session.setAttribute( "commandesClient", commandesClient );
			session.setAttribute( "compte", CompteDeClientConnecte );
			session.setAttribute( "voituresClient", voituresClient );

			request.getRequestDispatcher( "/cmd.jsp" ).forward( request, response );
		
		} else {
		
			request.setAttribute( "errorMessage", "Bad identity" );			
			request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
		}
	}
}
