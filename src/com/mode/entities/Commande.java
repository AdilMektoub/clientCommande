package com.mode.entities;

import java.util.Date;

public class Commande {
	
	private int id_commande;
	private int id_client;
	private String produit;
	private int nombre;
	private int prix;
	private Date date;
	
	
	public Commande(int id_commande, int id_client, String produit, int nombre, int prix, Date date) {
		this.id_commande = id_commande;
		this.id_client = id_client;
		this.produit = produit;
		this.nombre = nombre;
		this.prix = prix;
		this.date = date;
	}


	public int getId_commande() {
		return id_commande;
	}


	public int getId_client() {
		return id_client;
	}


	public String getProduit() {
		return produit;
	}


	public int getNombre() {
		return nombre;
	}


	public int getPrix() {
		return prix;
	}


	public Date getDate() {
		return date;
	}


	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public void setProduit(String produit) {
		this.produit = produit;
	}


	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
