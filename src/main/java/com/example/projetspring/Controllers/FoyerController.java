package com.example.projetspring.Controllers;

import com.example.projetspring.Services.IFoyerServices;
import com.example.projetspring.entities.Foyer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@RequiredArgsConstructor
public class FoyerController {
    final IFoyerServices foyerServices;


    @GetMapping("/retrieveAllFoyers")
    public List<Foyer> retrieveAllFoyers(){
        return foyerServices.retrieveAllFoyers();
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody  Foyer f){
        return foyerServices.addFoyer(f);
    }

    @PutMapping("/updateFoyer/{id}")
    public ResponseEntity<Foyer> updateFoyer(@PathVariable("id") Long id, @RequestBody Foyer updatedFoyer) {
        Foyer existingFoyer = foyerServices.retrieveFoyer(id);

        if (existingFoyer != null) {
            existingFoyer.setNomFoyer(updatedFoyer.getNomFoyer());
            existingFoyer.setCapaciteFoyer(updatedFoyer.getCapaciteFoyer());
            Foyer modifiedFoyer = foyerServices.updateFoyer(existingFoyer);
            return ResponseEntity.ok(modifiedFoyer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/retrieveFoyer/{id}")
    public Foyer retrieveFoyer(@PathVariable Long id){
        return foyerServices.retrieveFoyer(id);

    }

    @DeleteMapping("/removeFoyer/{id}")
    public void removeFoyer(@PathVariable Long idFoyer) {
        foyerServices.retrieveFoyer(idFoyer);
    }




}
