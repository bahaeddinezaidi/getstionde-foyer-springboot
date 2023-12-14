package com.example.projetspring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter

public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private String numReservation;
    private LocalDate debutAnneeUniversitaire;
    private LocalDate finAnneeUniversitaire;
    private Boolean estValide;

    @ManyToMany
    private Set<Etudiant> etudiant;




    public Reservation(Long idReservation, String numReservation, LocalDate debutAnneeUniversitaire, LocalDate finAnneeUniversitaire, Boolean estValide) {
        this.idReservation = idReservation;
        this.numReservation = numReservation;
        this.debutAnneeUniversitaire = debutAnneeUniversitaire;
        this.finAnneeUniversitaire = finAnneeUniversitaire;
        this.estValide = estValide;
    }

    public Reservation() {
    }
}
