package com.example.projetspring.Repositories;

import com.example.projetspring.entities.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {
    Etudiant findEtudiantByCin (Long cin);
    Etudiant findEtudiantByNomEtudiant(String nom);
}
