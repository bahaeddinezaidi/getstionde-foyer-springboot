package com.example.projetspring.Controllers;

import com.example.projetspring.Services.IUniversiteServices;
import com.example.projetspring.entities.Foyer;
import com.example.projetspring.entities.Universite;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universite")
@RequiredArgsConstructor

public class UniversiteController {
    final IUniversiteServices universiteServices;

    @GetMapping("/retrieveAllUniversities")
    public List<Universite> retrieveAllUniversities(){
        return universiteServices.retrieveAllUniversities();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServices.addUniversite(u);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite u){
        return universiteServices.updateUniversite(u);
    }

    @GetMapping("/retrieveUniversite/{id}")
    public Universite retrieveUniversite(@PathVariable Long idUniversite){
        return universiteServices.retrieveUniversite(idUniversite);
    }

    @PostMapping("/affecterFoyerAUniversite")
    public Universite affecterFoyerAUniversite (@RequestParam Long idFoyer,@RequestParam String nomUniversite) {
        return universiteServices.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }
    @PostMapping("/desaffecterFoyerAUniversite")
    public Universite desaffecterFoyerAUniversite(@RequestParam Long idFoyer, @RequestParam Long idUniversite) {
    return universiteServices.desaffecterFoyerAUniversite(idFoyer,idUniversite);
    }
    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody  Foyer foyer, @PathVariable Long idUniversite){
        return universiteServices.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);
    }











}
