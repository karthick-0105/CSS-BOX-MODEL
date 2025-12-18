package com.hospital.controller;

import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.exception.BadRequestException;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin("*")
public class DoctorController {

    private final DoctorService doctorService;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorService doctorService, AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.doctorService = doctorService;
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
    
    @GetMapping("/available")
    public List<Doctor> getAvailableDoctors() {
        return doctorService.getAllDoctors().stream()
                .filter(Doctor::isAvailable)
                .toList();
    }
    
    // Update doctor availability
    @PutMapping("/{id}/availability")
    public Doctor updateAvailability(
            @PathVariable Long id,
            @RequestParam boolean available) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));
        
        doctor.setAvailable(available);
        return doctorService.saveDoctor(doctor);
    }
    
    // Doctor accepts an approved appointment
    @PutMapping("/appointments/accept/{id}")
    public void acceptAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment with ID " + id + " not found"));
        
        if (!"APPROVED".equals(appointment.getStatus())) {
            throw new BadRequestException("Only approved appointments can be accepted by doctor");
        }
        
        appointment.setStatus("ACCEPTED");
        appointment.setRejectionReason(null);
        appointmentRepository.save(appointment);
    }
    
    // Doctor rejects an approved appointment with reason
    @PutMapping("/appointments/reject/{id}")
    public void rejectAppointment(
            @PathVariable Long id,
            @RequestParam String reason) {
        
        if (reason == null || reason.trim().isEmpty()) {
            throw new BadRequestException("Rejection reason is required");
        }
        
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment with ID " + id + " not found"));
        
        if (!"APPROVED".equals(appointment.getStatus())) {
            throw new BadRequestException("Only approved appointments can be rejected by doctor");
        }
        
        appointment.setStatus("REJECTED_BY_DOCTOR");
        appointment.setRejectionReason(reason);
        appointmentRepository.save(appointment);
    }
}
