package com.example.projetspring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter

public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private Long adresse;
    @OneToOne
    private Foyer foyer;

    public Universite(Long idUniversite, String nomUniversite, Long adresse, Foyer foyer) {
        this.idUniversite = idUniversite;
        this.nomUniversite = nomUniversite;
        this.adresse = adresse;
        this.foyer = foyer;
    }

    public Universite() {
    }
}
