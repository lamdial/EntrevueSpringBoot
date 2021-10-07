package com.example.entrevueSpringBoot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevueSpringBoot.dao.IActeurRepository;
import com.example.entrevueSpringBoot.dao.IFilmRepository;
import com.example.entrevueSpringBoot.entities.Acteur;
import com.example.entrevueSpringBoot.entities.Film;

@Service
public class FilmService {
	
	@Autowired
	IFilmRepository filmRepo;
	
	@Autowired
	IActeurRepository acteurRepo;
	
	public Film getFilmById(Long id) {
		Optional<Film> afilm = filmRepo.findById(id);
		if(afilm.isPresent()) {
			Film film = afilm.get();
			getActeursByFilmId(id,film);
			return film;
		} else {
			return null;
		}	
	}
	
	public Film save(Film film) {
		filmRepo.save(film);
		for(Acteur acteur : film.getActors()) {
			acteurRepo.save(acteur);
		}
		return film;
	}
	
	private void getActeursByFilmId(Long id,Film film) {
		List<Acteur> lstActeur = acteurRepo.getActeursByFilmId(id.intValue());
		for (Iterator iterator = lstActeur.iterator(); iterator.hasNext();) {
			Acteur acteur = (Acteur) iterator.next();
			film.getActors().add(acteur);
		}
	}
}
