package com.mode.entities.H;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table (name ="client")
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_client;
	private String nom;
	private String email;
	private String password;
	private int  age;
	
    @OneToOne( cascade = CascadeType.ALL )  
    @JoinColumn( name="id_compte")
	private Compte compte;
    
    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_client") 
    List<Commande> commandes = new ArrayList<>();
	
	public Client(String nom, String email, String password, 
			int age, Compte compte, List<Commande> commandes) {
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.age = age;
		this.compte = compte;
		this.commandes = commandes;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getId_client() {
		return id_client;
	}



	public String getNom() {
		return nom;
	}



	public String getEmail() {
		return email;
	}



	public String getPassword() {
		return password;
	}



	public int getAge() {
		return age;
	}



	public List<Commande> getCommandes() {
		return commandes;
	}



	public void setId_client(int id_client) {
		this.id_client = id_client;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}



	public Client() {
	}
	
}
