package com.hospital.controller;

import com.hospital.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AppointmentRepository appointmentRepository;

    public AnalyticsController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/doctor")
    public List<Object[]> doctorAnalytics() {
        return appointmentRepository.countAppointmentsByDoctor();
    }

    @GetMapping("/date")
    public List<Object[]> dateAnalytics() {
        return appointmentRepository.countAppointmentsByDate();
    }
}
