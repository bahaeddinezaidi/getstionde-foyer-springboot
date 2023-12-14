package com.example.projetspring.Services;

import com.example.projetspring.entities.Bloc;
import com.example.projetspring.entities.Foyer;

import java.util.List;

public interface IBlocServices {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (Long idBloc);

    void removeBloc (Long idBloc);
    Bloc affecterBlocAFoyer (Long idBloc, Long idFoyer) ;
}
