package com.example.projetspring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter

public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;

    @ManyToOne
    private Bloc bloc;

    @OneToMany
    private Set<Reservation> reservation;


    public Chambre(Long idChambre, Long numChambre, TypeChambre typeChambre) {
        this.idChambre = idChambre;
        this.numChambre = numChambre;
        this.typeChambre = typeChambre;
    }

    public Chambre() {
    }
}
