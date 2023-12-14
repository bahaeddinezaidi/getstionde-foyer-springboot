package com.example.projetspring.Services;

import com.example.projetspring.Repositories.IBlocRepository;
import com.example.projetspring.Repositories.IFoyerRepository;
import com.example.projetspring.entities.Bloc;
import com.example.projetspring.entities.Foyer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor

public class BlocServicesImpl implements IBlocServices {
    final IBlocRepository blocRepository;
    final IFoyerRepository foyerRepository;


    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepository.findAll() ;
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
      return blocRepository.save(bloc);

    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return  blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
              bloc.setFoyer(foyer);
              return  blocRepository.save(bloc);
    }


}
