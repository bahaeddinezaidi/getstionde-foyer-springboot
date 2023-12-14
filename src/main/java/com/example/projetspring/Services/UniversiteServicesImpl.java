package com.example.projetspring.Services;

import com.example.projetspring.Repositories.IBlocRepository;
import com.example.projetspring.Repositories.IFoyerRepository;
import com.example.projetspring.Repositories.IUniversiteRepository;
import com.example.projetspring.entities.Bloc;
import com.example.projetspring.entities.Foyer;
import com.example.projetspring.entities.Universite;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UniversiteServicesImpl implements IUniversiteServices{
    final IUniversiteRepository universiteRepository;
    final IFoyerRepository foyerRepository;
    final IBlocRepository blocRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll() ;
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Universite universite =  universiteRepository.findUniversiteByNomUniversite(nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        universite.setFoyer(foyer);
        return universiteRepository.save(universite);

    }

    @Override
    public Universite desaffecterFoyerAUniversite(Long idFoyer, Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Foyer foyer =foyerRepository.findById(idFoyer).orElse(null);
        if (universite.getFoyer()== foyer ){
            universite.setFoyer(null);
            return  universiteRepository.save(universite);
        }else
        {return null;}


    }
    @Async
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
      foyerRepository.save(foyer);
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Long id = universite.getIdUniversite();
        universite.setFoyer(foyer);

        for (Bloc b : foyer.getBloc()) {
            b.setFoyer(foyer);
        }


        universiteRepository.save(universite);

        return foyer;
    }


}
