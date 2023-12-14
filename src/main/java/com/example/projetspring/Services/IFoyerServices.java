package com.example.projetspring.Services;

import com.example.projetspring.entities.Foyer;

import java.util.List;

public interface IFoyerServices {

    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer (Foyer f);

    Foyer updateFoyer (Foyer f);

    Foyer retrieveFoyer (Long idFoyer);

    void removeFoyer (Long idFoyer);
}
