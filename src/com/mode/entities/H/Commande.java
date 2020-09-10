package com.mode.entities.H;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table( name="commande")
public class Commande {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_commande;
	private String produit;
	private int nombre;
	private int prix;
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client") 
	private Client client;

	public Commande(String produit, int nombre, int prix, Date date, Client client) {
		this.produit = produit;
		this.nombre = nombre;
		this.prix = prix;
		this.date = date;
		this.client = client;
	}
	
	public Commande() {
	}

	public int getId_commande() {
		return id_commande;
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

	public Client getClient() {
		return client;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
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

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	

}
