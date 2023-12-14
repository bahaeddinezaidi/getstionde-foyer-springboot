package com.example.projetspring.Controllers;

import com.example.projetspring.Services.IBlocServices;
import com.example.projetspring.Services.IChambreServices;
import com.example.projetspring.entities.Bloc;
import com.example.projetspring.entities.Chambre;
import com.example.projetspring.entities.Foyer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@RequiredArgsConstructor

public class BlocController {
    final IBlocServices blocServices;
    final IChambreServices chambreServices;

    @GetMapping("/retrieveBlocs")
    public List<Bloc> retrieveBlocs(){
        return blocServices.retrieveBlocs();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bloc> modifyBloc(@PathVariable("id") Long id, @RequestBody Bloc updatedBloc) {
        Bloc existingBloc = blocServices.retrieveBloc(id);

        if (existingBloc != null) {
            existingBloc.setNomBloc(updatedBloc.getNomBloc());
            existingBloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());
            Bloc modifiedBloc = blocServices.updateBloc(existingBloc);
            return ResponseEntity.ok(modifiedBloc);
        } else {
            return ResponseEntity.notFound().build();
        }


    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc){
        return blocServices.addBloc(bloc);
    }


    @GetMapping("/retrieveBloc/{id}")
    public Bloc retrieveBloc(@PathVariable Long id) {
        return blocServices.retrieveBloc(id);
    }

    @DeleteMapping("/removeBloc/{id}")
    public void removeBloc(@PathVariable Long id){
        blocServices.removeBloc(id);
        }

    @PutMapping("/affecterChambresABloc/{id}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre , @PathVariable Long id) {
        return chambreServices.affecterChambresABloc( numChambre , id);
    }

    @PutMapping("/affecterBlocAFoyer")
    public Bloc affecterBlocAFoyer(@RequestParam Long idBloc, @RequestParam Long idFoyer) {
        return blocServices.affecterBlocAFoyer(idBloc,idFoyer);
    }

    }



