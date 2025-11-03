package com.southernbites.controller;

import com.southernbites.entity.Reservation;
import com.southernbites.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin/reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    // Show admin dashboard with all reservations
    @GetMapping
    public String viewAllReservations(Model model) {
        List<Reservation> reservations = service.getAll();
        model.addAttribute("reservations", reservations);
        return "admin";
    }

    // Fetch all reservations (used by JS to refresh instantly)
    @GetMapping("/all")
    @ResponseBody
    public List<Reservation> getAllReservations() {
        return service.getAll();
    }

    // Update reservation via modal
    @PostMapping("/update")
    @ResponseBody
    public String updateReservation(@RequestBody Reservation updatedReservation) {
        service.save(updatedReservation);
        return "Reservation updated successfully!";
    }

    // Delete reservation
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteReservation(@PathVariable Long id) {
        service.deleteById(id);
        return "Reservation deleted successfully!";
    }
}
