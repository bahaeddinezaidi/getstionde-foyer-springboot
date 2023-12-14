package com.example.projetspring.Repositories;

import com.example.projetspring.entities.Bloc;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBlocRepository extends CrudRepository<Bloc,Long> {
   // @Query("SELECT b FROM Bloc b JOIN FETCH b.foyer")
  //  List<Bloc> retrieveBlocsAndFoyer();
}
