package com.alkemy.challenge.models;

import java.io.File;
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
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCharacter;
    private File image;
    private String name;
    private int age;
    private Float weigth;
    private String history;

    @ManyToMany
    private Set<Films> associated_films;

}
