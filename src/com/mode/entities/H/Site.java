package com.mode.entities.H;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity @Table(name = "sites")
public class Site {
	
	@Id @GeneratedValue
	private int id_site;
	
	private String nom;
	
	private String url;
	
    @ManyToMany
    @JoinTable( name = "associations",
    			joinColumns = @JoinColumn (name = "id_site"),
                inverseJoinColumns = @JoinColumn( name = "id_dev" ) )
    private List<Developpeur> developpeurs = new ArrayList<>();

	public List<Developpeur> getDeveloppeurs() {
		return developpeurs;
	}

	public void setDeveloppeurs(List<Developpeur> developpeurs) {
		this.developpeurs = developpeurs;
	}

	public Site(int id_site, String nom, String url) {
		super();
		this.id_site = id_site;
		this.nom = nom;
		this.url = url;
	}

	public int getId_site() {
		return id_site;
	}

	public void setId_site(int id_site) {
		this.id_site = id_site;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Site() {
		super();
	}
	
	


}
