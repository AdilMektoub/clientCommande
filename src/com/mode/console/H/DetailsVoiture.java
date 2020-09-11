package com.mode.console;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mode.entities.Voiture;
import com.mode.entities.Client;
/**
 * Servlet implementation class DetailsVoiture
 */
@WebServlet("/DetailsVoiture")
public class DetailsVoiture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsVoiture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession( true );
		String idVoiture = request.getParameter("btndetailsVoiture");
		 EntityManagerFactory entityManagerFactory = null;
	     EntityManager em = null;
	     Voiture lavoiture = null;
	     try {
	            
	            entityManagerFactory = Persistence.createEntityManagerFactory("ClientCommandeJPA");
	            em = entityManagerFactory.createEntityManager();
	     
	    
		 lavoiture= em.find(Voiture.class, Integer.parseInt(idVoiture));
		System.out.println("****details Voiture****");
		for (Client cl : lavoiture.getClients()) {
			System.out.println(cl.getNom());
			
		}
	     } finally {
	            if ( em != null ) em.close();
	            if ( entityManagerFactory != null ) entityManagerFactory.close();
	        }	
	     
	    
		 session.setAttribute("lavoiture", lavoiture);
		 session.setAttribute("listeProprietaires", lavoiture.getClients());
		 request.getRequestDispatcher( "/detailsVoiture.jsp" ).forward( request, response );
		
		
	}

}
