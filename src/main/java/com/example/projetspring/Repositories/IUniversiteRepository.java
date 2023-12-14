package com.example.projetspring.Repositories;

import com.example.projetspring.entities.Universite;
import org.springframework.data.repository.CrudRepository;

public interface IUniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findUniversiteByNomUniversite(String nomUniversite);

}
