package com.example.entrevueSpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entrevueSpringBoot.entities.Acteur;

public interface IActeurRepository extends CrudRepository<Acteur, Long> {

	@Query(nativeQuery=true, value="SELECT * FROM ACTEUR where FILM_IDENT = ?1")
	public List<Acteur> getActeursByFilmId(Integer Film_id);
	
}
