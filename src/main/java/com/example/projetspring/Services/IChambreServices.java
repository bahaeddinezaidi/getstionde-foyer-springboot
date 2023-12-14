package com.example.projetspring.Services;

import com.example.projetspring.entities.Bloc;
import com.example.projetspring.entities.Chambre;
import com.example.projetspring.entities.TypeChambre;

import java.util.List;

public interface IChambreServices {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (Long idChambre);
    Bloc affecterChambresABloc(List<Long> numChambre, Long idBloc) ;
     List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC);

}
