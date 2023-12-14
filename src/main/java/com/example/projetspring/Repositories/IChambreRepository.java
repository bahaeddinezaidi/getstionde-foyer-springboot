package com.example.projetspring.Repositories;

import com.example.projetspring.entities.Chambre;
import com.example.projetspring.entities.TypeChambre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IChambreRepository extends CrudRepository<Chambre,Long> {
    Chambre findChambreByNumChambre(Long numChambre);
    @Query("SELECT c FROM Chambre c JOIN c.bloc b WHERE b.idBloc = :idBloc AND c.typeChambre = :typeChambre")
    List<Chambre> findByTypeChambreAndBlocId(@Param("idBloc") Long idBloc,@Param("typeChambre") TypeChambre typeChambre);
}
