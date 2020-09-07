package com.mode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mode.entities.Client;
import com.mode.entities.Commande;


public class CommandeDAO extends ContextDAO {
	
	public static ArrayList<Commande> getLivreById( Client client ) {
		ArrayList<Commande> commandes = null;
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			System.out.println( "connection to the database" );
			int id_client = client.getId_client();
			String strSql = "SELECT * FROM cmd WHERE id_client=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, id_client );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					resultSet.next();
					Commande c = new Commande( // (int id, String titre, String auteur, String categorie)
							resultSet.getInt( "id_commande" ),
							resultSet.getInt( "id_client" ),
							resultSet.getString( "produit" ),
							resultSet.getInt( "nombre" ),
							resultSet.getInt( "prix" ),
							resultSet.getDate( "date" )
							);
					commandes.add(c);
				}
			}
				return commandes;
		} catch ( Exception exception ) {

			throw new RuntimeException( exception );

		}
	}

}
