package com.mode.entities.H;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Developpeur {

	@Id @GeneratedValue
	private int id_dev;
	
	private String nom;
	
	private int age;
	
    @ManyToMany
    @JoinTable( name = "associations",
    			joinColumns = @JoinColumn (name = "id_dev"),
                inverseJoinColumns = @JoinColumn( name = "id_site" ) )
    private List<Site> sites = new ArrayList<>();

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Developpeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Developpeur(int id_dev, String nom, int age) {
		super();
		this.id_dev = id_dev;
		this.nom = nom;
		this.age = age;
	}

	public int getId_dev() {
		return id_dev;
	}

	public void setId_dev(int id_dev) {
		this.id_dev = id_dev;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
