package com.rcl.domain;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Characters {
    public String name;
    public String height;
    public String mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public ArrayList<String> films;
    public ArrayList<Object> species;
    public ArrayList<String> vehicles;
    public ArrayList<String> starships;
    public Date created;
    public Date edited;
    public String url;
}