package com.example.entrevueSpringBoot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long acteurId;
	private String nom;
	private String prenom;
	private long filmIdent;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
      fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	private Film filmActeur;
	
	public Acteur() {
		
	}
	
	public Acteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public long getActeurId() {
		return acteurId;
	}
	public void setActeurId(long acteurId) {
		this.acteurId = acteurId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Film getFilmActeur() {
		return filmActeur;
	}

	public void setFilmActeur(Film filmActeur) {
		this.filmActeur = filmActeur;
	}

	public long getFilmIdent() {
		return filmIdent;
	}

	public void setFilmIdent(long filmId) {
		this.filmIdent = filmId;
	}

}
