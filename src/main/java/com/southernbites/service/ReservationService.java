package com.southernbites.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.southernbites.entity.Reservation;
import com.southernbites.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repo;

    public void save(Reservation r) {
        repo.save(r);
    }

    public java.util.List<Reservation> getAll() {
        return repo.findAll();
    }
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
