package com.example.entrevueSpringBoot.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entrevueSpringBoot.dao.IFilmRepository;
import com.example.entrevueSpringBoot.entities.Film;
import com.example.entrevueSpringBoot.service.FilmService;

@RestController
@RequestMapping("/api")
public class filmController {
	
	@Autowired
	IFilmRepository filmRepo;
	
	@Autowired
	FilmService filmService;
	
	@GetMapping("/getFilm")
	public Film getFilm(@RequestParam Long id, Model model, Film film) {
		return filmService.getFilmById(id);
	}
	
	@PostMapping("/postFilm")
	@ResponseBody
	public Film createFilm(@RequestBody Film film) {
		return filmService.save(film);
	}
}
