package com.example.projetspring.Controllers;

import com.example.projetspring.Services.IResevationServices;
import com.example.projetspring.entities.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/resrvation")
@RequiredArgsConstructor

public class ReservationController {
    final IResevationServices resevationServices;

    @GetMapping("/retrieveAllReservation")
    public List<Reservation> retrieveAllReservation(){
        return resevationServices.retrieveAllReservation();
    }


    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation res){
        return resevationServices.updateReservation(res);
    }

    @GetMapping("/retrieveReservation/{id}")
    public Reservation retrieveReservation(@PathVariable Long idReservation){
        return resevationServices.retrieveReservation(idReservation);
    }
    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestParam Long idChambre,@RequestParam Long cinEtudiant){
       return resevationServices.ajouterReservation(idChambre,cinEtudiant);
    }

    @PutMapping("/annulerReservation")
    public Set<Reservation> annulerReservation(@RequestParam Long cinEtudiant){
        return resevationServices.annulerReservation(cinEtudiant);
    }




}
