package com.hospital.controller;

import com.hospital.entity.Appointment;
import com.hospital.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    private final AppointmentRepository appointmentRepository;

    public AdminController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // View all pending appointments
    @GetMapping("/appointments/pending")
    public List<Appointment> getPendingAppointments() {
        return appointmentRepository.findByStatus("PENDING");
    }

    // View all appointments (for admin to see all statuses)
    @GetMapping("/appointments/all")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Approve appointment
    @PutMapping("/appointments/approve/{id}")
    public void approve(@PathVariable Long id) {
        Appointment a = appointmentRepository.findById(id).orElseThrow();
        a.setStatus("APPROVED");
        a.setRejectionReason(null);
        appointmentRepository.save(a);
    }

    // Reject appointment
    @PutMapping("/appointments/reject/{id}")
    public void reject(
            @PathVariable Long id,
            @RequestParam String reason) {

        Appointment a = appointmentRepository.findById(id).orElseThrow();
        a.setStatus("REJECTED");
        a.setRejectionReason(reason);
        appointmentRepository.save(a);
    }
}
