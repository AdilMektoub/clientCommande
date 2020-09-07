package com.mode.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mode.dao.ClientDAO;
import com.mode.dao.ContextDAO;
import com.mode.entities.Client;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		ContextDAO.init( this.getServletContext() );
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute( "nom", "" );
		request.setAttribute( "password", "" );
		request.setAttribute( "errorMessage", "" );
		request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter( "txtNom" );
		String password = request.getParameter( "txtPassword" );
		
//		ArrayList<Livre> tousLivres = null;
//		try {
//			tousLivres = LivreDAO.getLivres();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		ArrayList<String> titres = new ArrayList<>();
		
		request.setAttribute( "nom", nom );
		request.setAttribute( "password", password );
		
		Client connectedClient = ClientDAO.isValidLogin( nom , password );
		if ( connectedClient != null ) {
			
			HttpSession session = request.getSession( true );
			session.setAttribute( "connectedClient", connectedClient );
//			session.setAttribute( "tousLivres", tousLivres );

			request.getRequestDispatcher( "/cmd.jsp" ).forward( request, response );
		
		} else {
		
			request.setAttribute( "errorMessage", "Bad identity" );			
			request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
			
		}
		
	}

}
