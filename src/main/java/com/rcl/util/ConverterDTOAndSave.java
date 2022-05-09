package com.rcl.util;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.rcl.domain.Characters;
import com.rcl.domain.Films;
import com.rcl.entity.CharactersEntity;
import com.rcl.entity.ResultEntity;
import com.rcl.repository.CharactersRepository;
import com.rcl.repository.FilmsResultRepository;
import com.rcl.service.CallSWApiService;

@Component
public class ConverterDTOAndSave {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ConverterDTOAndSave.class);

    private FilmsResultRepository filmsResultRepository;

    private CharactersRepository charactersRepository;

    private CallSWApiService callSWApiService;

    private ResultEntity entity;

    private CharactersEntity charactersEntity;

    private ResponseEntity<Characters> characters;

    @Autowired
    public ConverterDTOAndSave(FilmsResultRepository filmsResultRepository, CharactersRepository charactersRepository,
	    CallSWApiService callSWApiService) {
	this.filmsResultRepository = filmsResultRepository;
	this.charactersRepository = charactersRepository;
	this.callSWApiService = callSWApiService;
    }

    @SuppressWarnings("unchecked")
    private ResponseEntity<Characters> callApiSWCharacters(List<ResultEntity> entityFilmsResult, int i, int j) {
	return (ResponseEntity<Characters>) callSWApiService
		.getCallSWApiGeneric(entityFilmsResult.get(i).getCharacters().get(j), Characters.class);
    }

    public void converterFilmsToEntityAndSave(ResponseEntity<Films> films) {

	try {

	    for (int i = 0; i < films.getBody().getResults().size(); i++) {

		entity = new ResultEntity();

		entity.setTitle(films.getBody().getResults().get(i).getTitle());
		entity.setEpisode_id(films.getBody().getResults().get(i).getEpisode_id());
		entity.setOpening_crawl(films.getBody().getResults().get(i).getOpening_crawl());
		entity.setDirector(films.getBody().getResults().get(i).getDirector());
		entity.setProducer(films.getBody().getResults().get(i).getProducer());
		entity.setRelease_date(films.getBody().getResults().get(i).getRelease_date());
		entity.setCharacters(films.getBody().getResults().get(i).getCharacters());
		entity.setPlanets(films.getBody().getResults().get(i).getStarships());
		entity.setStarships(films.getBody().getResults().get(i).getVehicles());
		entity.setVehicles(films.getBody().getResults().get(i).getSpecies());
		entity.setSpecies(films.getBody().getResults().get(i).getSpecies());
		entity.setCreated(films.getBody().getResults().get(i).getCreated());
		entity.setEdited(films.getBody().getResults().get(i).getEdited());
		entity.setUrl(films.getBody().getResults().get(i).getUrl());
		entity.setVersion(1);

		filmsResultRepository.save(entity);
	    }

	} catch (Exception e) {
	    log.error("Error Save", e);
	}

    }

    public void converterCharacterstoEntityAndSave(List<ResultEntity> entityFilmsResult) {

	if (entityFilmsResult != null) {

	    try {

		for (int i = 0; i < entityFilmsResult.size(); i++) {

		    for (int j = 0; j < entityFilmsResult.get(i).getCharacters().size(); j++) {
			charactersEntity = new CharactersEntity();

			characters = callApiSWCharacters(entityFilmsResult, i, j);

			charactersEntity.setName(characters.getBody().getName());
			charactersEntity.setHeight(characters.getBody().getHeight());
			charactersEntity.setMass(null);
			charactersEntity.setHair_color(null);
			charactersEntity.setSkin_color(null);
			charactersEntity.setEye_color(null);
			charactersEntity.setBirth_year(null);
			charactersEntity.setGender(null);
			charactersEntity.setHomeworld(null);
			charactersEntity.setFilms(null);
			charactersEntity.setSpecies(null);
			charactersEntity.setVehicles(null);
			charactersEntity.setStarships(null);
			charactersEntity.setCreated(null);
			charactersEntity.setEdited(null);
			charactersEntity.setUrl(null);

			charactersRepository.save(charactersEntity);

		    }

		}
	    } catch (Exception e) {
		log.error("Error Save", e);
	    }
	}
    }

}
