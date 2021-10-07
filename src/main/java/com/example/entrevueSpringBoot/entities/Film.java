package com.example.entrevueSpringBoot.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long filmId;
	private String titre;
	private String description;
	
	@OneToMany(mappedBy = "filmActeur")
	private List<Acteur> acteurs;
	
	public Film() {
		
	}
	
	public Film(String titre, String description, List<Acteur> actors) {
		super();
		this.titre = titre;
		this.description = description;
		this.acteurs = actors;
	}
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Acteur> getActors() {
		return acteurs;
	}
	public void setActors(List<Acteur> actors) {
		this.acteurs = actors;
	}
}
