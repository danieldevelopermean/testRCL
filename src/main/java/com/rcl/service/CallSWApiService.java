package com.rcl.service;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.rcl.domain.Films;

@Service
public class CallSWApiService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CallSWApiService.class);

    // Generico
    public <T> ResponseEntity<?> getCallSWApiGeneric(String url, Class<T> clazz) {

	String requestUri = url;

	ResponseEntity<T> response = null;

	HttpHeaders headers = new HttpHeaders();
	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	RestTemplate restTemplate = new RestTemplate();
	HttpEntity<?> entity = new HttpEntity<>(headers);

	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(requestUri);

	try {
	    response = (ResponseEntity<T>) restTemplate.exchange(requestUri, HttpMethod.GET, entity, clazz);

	} catch (Exception e) {
	    System.out.printf("Erro Chamada Star Wars API: " + e);
	}

	return response;
    }

    // Original Não Usado
    public ResponseEntity<Films> getCallSWApiFilm(String url) {

	String requestUri = url;

	ResponseEntity<Films> response = null;

	HttpHeaders headers = new HttpHeaders();
	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	RestTemplate restTemplate = new RestTemplate();
	HttpEntity<?> entity = new HttpEntity<>(headers);

	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(requestUri);

	try {
	    response = restTemplate.exchange(requestUri, HttpMethod.GET, entity, Films.class);

	} catch (Exception e) {
	    System.out.printf("Erro Chamada Star Wars API: " + e);
	}
	return response;
    }

}
