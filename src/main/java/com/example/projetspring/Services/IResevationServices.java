package com.example.projetspring.Services;

import com.example.projetspring.entities.Reservation;

import java.util.List;
import java.util.Set;

public interface IResevationServices {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (Long idReservation);
    Reservation ajouterReservation (Long idChambre, Long cinEtudiant) ;
    Set<Reservation> annulerReservation(Long cinEtudiant) ;
}
