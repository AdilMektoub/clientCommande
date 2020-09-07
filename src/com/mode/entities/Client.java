package com.mode.entities;

public class Client {
	
	private int id_client;
	private String nom;
	private String prenom;
	private String password;
	private int age ;
	
	
	public Client(int id_client, String nom, 
			String prenom, String password, int age) {
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.age = age;
	}


	public int getId_client() {
		return id_client;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getPassword() {
		return password;
	}


	public int getAge() {
		return age;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
