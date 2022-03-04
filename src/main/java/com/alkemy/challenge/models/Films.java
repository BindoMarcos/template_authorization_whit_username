package com.alkemy.challenge.models;

import java.io.File;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity

@Table(name = "films")
public class Films {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idFilm;

    private File image;
    private String title;
    private Date creation_date;
    private int qualification;

    @ManyToMany
    private Set<Films> characters;

    @ManyToMany
    private Set<Genre> genres;
}
