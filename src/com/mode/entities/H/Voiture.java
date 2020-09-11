package com.mode.entities.H;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table ( name = "voiture")
public class Voiture {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_voiture;
	private String reference;
	private String marque;
	private String couleur;
	
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable( name = "clientsVoitures",
    			joinColumns = @JoinColumn (name = "id_voiture"),
                inverseJoinColumns = @JoinColumn( name = "id_client"))
	private List<Client> clients = new ArrayList<>();
	
	public Voiture(String reference, String marque, String couleur) {
		this.reference = reference;
		this.marque = marque;
		this.couleur = couleur;
	}

	public int getId_voiture() {
		return id_voiture;
	}

	public String getReference() {
		return reference;
	}

	public String getMarque() {
		return marque;
	}

	public String getCouleur() {
		return couleur;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setId_voiture(int id_voiture) {
		this.id_voiture = id_voiture;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Voiture() {

	}
	
	

}
