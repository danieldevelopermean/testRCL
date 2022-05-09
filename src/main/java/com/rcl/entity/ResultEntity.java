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
@Table(name = "Results")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity {

    private static final long serialVersionUID = 3001782215680858821L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    public String title;

    @Column(name = "episode_id")
    public int episode_id;

    @Column(name = "opening_crawl", length = 10000)
    public String opening_crawl;

    @Column(name = "director")
    public String director;

    @Column(name = "producer")
    public String producer;

    @Column(name = "release_date")
    public String release_date;

    @Column(name = "characters", length = 10000)
    public ArrayList<String> characters;

    @Column(name = "planets", length = 10000)
    public ArrayList<String> planets;

    @Column(name = "starships", length = 10000)
    public ArrayList<String> starships;

    @Column(name = "vehicles", length = 10000)
    public ArrayList<String> vehicles;

    @Column(name = "species", length = 10000)
    public ArrayList<String> species;

    @Column(name = "created")
    public Date created;

    @Column(name = "edited")
    public Date edited;

    @Column(name = "url")
    public String url;

    @Column(name = "version")
    public Integer version;

}
