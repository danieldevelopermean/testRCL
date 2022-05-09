package com.rcl.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcl.domain.Films;
import com.rcl.service.CallSWApiService;
import com.rcl.service.CrudService;

@RestController
@RequestMapping("/call_sw_api")
public class CallSWAPIControler {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CallSWAPIControler.class);

    private CallSWApiService callSWApiFilmsService;

    private CrudService crudService;

    @Autowired
    public CallSWAPIControler(CallSWApiService callSWApi, CrudService crudService) {
	this.callSWApiFilmsService = callSWApi;
	this.crudService = crudService;
    }

    @SuppressWarnings("unchecked")
    private ResponseEntity<Films> callApiSWFilms(String url) {
	return (ResponseEntity<Films>) this.callSWApiFilmsService.getCallSWApiGeneric(url, Films.class);
    }

    // http://localhost:9001/call_sw_api/allFilms
    @GetMapping(value = "/allFilms")
    public ResponseEntity<Films> getAllMovies() {
	log.info("Find all Movies in API Star Wars");
	String url = "https://swapi.dev/api/films";

	try {

	    ResponseEntity<Films> films = callApiSWFilms(url);

	    if (films != null) {

		crudService.saveFilmResult(films);
		crudService.saveCharacters();

		return films;

	    } else {
		log.info("Films not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(films.getBody());
	    }
	} catch (Exception ex) {
	    log.debug("Error: " + ex);
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
    }

}
