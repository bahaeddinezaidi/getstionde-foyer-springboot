package com.example.projetspring.Controllers;

import com.example.projetspring.Services.IEtudiantServices;
import com.example.projetspring.entities.Etudiant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantController {
    final IEtudiantServices etudiantServices;


    @GetMapping("/retrieveAllEtudiants")
    public List<Etudiant> retrieveAllEtudiants(){
        return etudiantServices.retrieveAllEtudiants();
    }

    @PostMapping("/addEtudiants")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants){
       return  etudiantServices.addEtudiants(etudiants);
    }
    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return  etudiantServices.addEtudiant(etudiant);
    }

    @PutMapping("/updateEtudiant/{name}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("name") String name, @RequestBody Etudiant updatedEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudainatByname(name);
        if (existingEtudiant != null) {
            existingEtudiant.setNomEtudiant(updatedEtudiant.getNomEtudiant());
            existingEtudiant.setCin(updatedEtudiant.getCin());
            existingEtudiant.setEcole(updatedEtudiant.getEcole());
            existingEtudiant.setDateNaissence(updatedEtudiant.getDateNaissence());

            Etudiant modifiedEtudiant = etudiantServices.updateEtudiant(existingEtudiant);
            return ResponseEntity.ok(modifiedEtudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getEtudiant/{nom}")
    public Etudiant getEtudiantnaame(@PathVariable String nom){
        return  etudiantServices.getEtudainatByname(nom);
    }




}
