package com.example.entrevueSpringBoot.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entrevueSpringBoot.entities.Film;

public interface IFilmRepository extends CrudRepository<Film, Long> {

}
