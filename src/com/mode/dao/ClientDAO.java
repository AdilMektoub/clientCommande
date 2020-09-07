package com.mode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mode.entities.Client;

public class ClientDAO extends ContextDAO {
	
	public static Client isValidLogin( String nom , String password ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
			//String strSql = "SELECT * FROM T_Users WHERE login='" + login + "' AND password='" + password + "'";
			String strSql = "SELECT * FROM client WHERE nom=? AND password=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, nom );
				statement.setString( 2, password );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					if ( resultSet.next() ) { //(int id, int id_livre, String nom, String login, String password)
						return new Client(
								resultSet.getInt( "id_client" ),
								resultSet.getString( "nom" ),
								resultSet.getString( "prenom" ),
								resultSet.getString( "password" ),
								resultSet.getInt( "age" )		
						);
					} else {
						return null;
					}
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

}
