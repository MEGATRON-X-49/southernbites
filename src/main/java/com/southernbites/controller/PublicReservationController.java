package com.southernbites.controller;

import com.southernbites.entity.Reservation;
import com.southernbites.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublicReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/reserve")
    public String showReservationForm() {
        return "reservation";  // must exist in templates/
    }

    @PostMapping("/reserve")
    public String submitReservation(Reservation reservation) {
        service.save(reservation);
        return "redirect:/thankyou";
    }
}
