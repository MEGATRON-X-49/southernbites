package com.southernbites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.southernbites.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
