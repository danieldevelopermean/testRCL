package com.rcl.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Characters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharactersEntity {

    private static final long serialVersionUID = 3001782215680858821L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "height")
    public String height;

    @Column(name = "mass")
    public String mass;

    @Column(name = "hair_color")
    public String hair_color;

    @Column(name = "skin_color")
    public String skin_color;

    @Column(name = "eye_color")
    public String eye_color;

    @Column(name = "birth_year")
    public String birth_year;

    @Column(name = "gender")
    public String gender;

    @Column(name = "homeworld")
    public String homeworld;

    @Column(name = "films", length = 10000)
    public ArrayList<String> films;

    @Column(name = "species", length = 10000)
    public ArrayList<Object> species;

    @Column(name = "vehicles", length = 10000)
    public ArrayList<String> vehicles;

    @Column(name = "starships", length = 10000)
    public ArrayList<String> starships;

    @Column(name = "created")
    public Date created;

    @Column(name = "edited")
    public Date edited;

    @Column(name = "url")
    public String url;

}
