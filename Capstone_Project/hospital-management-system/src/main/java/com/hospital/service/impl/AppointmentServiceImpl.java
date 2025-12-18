package com.hospital.service.impl;

import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.exception.BadRequestException;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    // ✅ CONSTRUCTOR INJECTION (VERY IMPORTANT)
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  DoctorRepository doctorRepository,
                                  PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Appointment bookAppointment(Appointment appointment) {

        // Validate input
        if (appointment.getDoctor() == null || appointment.getDoctor().getDoctorId() == null) {
            throw new BadRequestException("Doctor ID is required");
        }
        
        if (appointment.getPatient() == null || appointment.getPatient().getPatientId() == null) {
            throw new BadRequestException("Patient ID is required");
        }

        // 🔹 SAFELY FETCH DOCTOR
        Long doctorId = appointment.getDoctor().getDoctorId();
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + doctorId + " not found"));

        // 🔹 SAFELY FETCH PATIENT
        Long patientId = appointment.getPatient().getPatientId();
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient with ID " + patientId + " not found"));
        
        // Update patient age and gender if provided in appointment
        if (appointment.getPatient().getAge() > 0) {
            patient.setAge(appointment.getPatient().getAge());
        }
        if (appointment.getPatient().getGender() != null && !appointment.getPatient().getGender().isEmpty()) {
            patient.setGender(appointment.getPatient().getGender());
        }
        // Save updated patient information
        patientRepository.save(patient);

        // 🔴 PREVENT DOUBLE BOOKING
        boolean alreadyBooked =
                appointmentRepository.existsByDoctorDoctorIdAndAppointmentDateAndSlot(
                        doctorId,
                        appointment.getAppointmentDate(),
                        appointment.getSlot()
                );

        if (alreadyBooked) {
            throw new BadRequestException("Selected slot already booked for this doctor");
        }

        // 🔥 SET MANAGED ENTITIES
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointment.setStatus("PENDING");
        appointment.setRejectionReason(null);

        if (appointment.getPriority() == null) {
            appointment.setPriority("NORMAL");
        }

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    @Override
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorDoctorId(doctorId);
    }
}
