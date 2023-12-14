package com.example.projetspring.Services;

import com.example.projetspring.Repositories.IBlocRepository;
import com.example.projetspring.Repositories.IChambreRepository;
import com.example.projetspring.entities.Bloc;
import com.example.projetspring.entities.Chambre;
import com.example.projetspring.entities.TypeChambre;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ChambreServicesImpl implements IChambreServices {
    final IChambreRepository chambreRepository;
    final IBlocRepository blocRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }


    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        Chambre chambre = null;
        for (Long id : numChambre) {
            chambre = chambreRepository.findChambreByNumChambre(id);
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return bloc;
    }
    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC){
        List<Chambre> chambres = chambreRepository.findByTypeChambreAndBlocId(idBloc , typeC);
            return  chambres;
    }






    }

