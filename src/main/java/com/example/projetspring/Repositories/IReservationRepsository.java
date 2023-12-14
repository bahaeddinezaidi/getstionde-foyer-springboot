package com.example.projetspring.Repositories;

import com.example.projetspring.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface IReservationRepsository extends CrudRepository<Reservation,Long> {
}
