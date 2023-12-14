package com.example.projetspring.Services;

import com.example.projetspring.entities.Foyer;
import com.example.projetspring.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversities();

    Universite addUniversite (Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite (Long idUniversite);
    public Universite affecterFoyerAUniversite (Long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (Long idFoyer, Long idUniversite) ;
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, Long idUniversite) ;
}
