package com.example.projetspring.Services;

import com.example.projetspring.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Long idEtudiant);
    Etudiant   addEtudiant(Etudiant e);
    void removeEtudiant(Long idEtudiant);
    Etudiant getEtudainatByname(String name);
}
