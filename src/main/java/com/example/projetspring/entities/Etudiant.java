package com.example.projetspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter

public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtud;
    private String nomEtudiant;
    private Long cin;
    private LocalDate dateNaissence;
    private String ecole ;
    @JsonIgnore

    @ManyToMany
    private Set<Reservation> reservation;

    public Etudiant(Long idEtud, String nomEtudiant, Long cin, LocalDate dateNaissence, String ecole) {
        this.idEtud = idEtud;
        this.nomEtudiant = nomEtudiant;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
        this.ecole = ecole;
    }

    public Etudiant() {
    }
}
