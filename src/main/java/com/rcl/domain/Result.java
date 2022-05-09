package com.rcl.domain;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Result {

    public String title;
    public int episode_id;
    public String opening_crawl;
    public String director;
    public String producer;
    public String release_date;
    public ArrayList<String> characters;
    public ArrayList<String> planets;
    public ArrayList<String> starships;
    public ArrayList<String> vehicles;
    public ArrayList<String> species;
    public Date created;
    public Date edited;
    public String url;

}
