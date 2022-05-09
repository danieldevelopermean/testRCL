package com.rcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rcl.domain.Films;
import com.rcl.entity.ResultEntity;
import com.rcl.repository.FilmsResultRepository;
import com.rcl.util.ConverterDTOAndSave;

@Service
public class CrudService {

    private FilmsResultRepository filmsResultRepository;

    private ConverterDTOAndSave converterDTOAndSave;

    @Autowired
    public CrudService(FilmsResultRepository filmsResultRepository, ConverterDTOAndSave converterDTOAndSave) {
	this.filmsResultRepository = filmsResultRepository;
	this.converterDTOAndSave = converterDTOAndSave;
    }

    public Optional<ResultEntity> saveFilms(ResultEntity fr) {
	ResultEntity filmResult = filmsResultRepository.save(fr);
	return Optional.ofNullable(filmResult);
    }

    public void saveFilmResult(ResponseEntity<Films> films) {
	converterDTOAndSave.converterFilmsToEntityAndSave(films);
    }

    public void saveCharacters() {
	List<ResultEntity> entityFilmsResult = getAllFilms();
	converterDTOAndSave.converterCharacterstoEntityAndSave(entityFilmsResult);
    }

    private List<ResultEntity> getAllFilms() {
	return filmsResultRepository.findAll();
    }

}
