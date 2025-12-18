package com.hospital.repository;

import com.hospital.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Used earlier (can keep or remove later)
    List<Appointment> findByDoctorDoctorIdAndAppointmentDate(
            Long doctorId, LocalDate appointmentDate
    );

    // ✅ REQUIRED: Prevent double booking (same doctor + date + slot)
    boolean existsByDoctorDoctorIdAndAppointmentDateAndSlot(
            Long doctorId,
            LocalDate appointmentDate,
            String slot
    );

    List<Appointment> findByStatus(String status);

    // Analytics: appointments per doctor
    @Query("SELECT a.doctor.name, COUNT(a) FROM Appointment a GROUP BY a.doctor.name")
    List<Object[]> countAppointmentsByDoctor();

    // Analytics: appointments per date
    @Query("SELECT a.appointmentDate, COUNT(a) FROM Appointment a GROUP BY a.appointmentDate")
    List<Object[]> countAppointmentsByDate();
    
    // Find appointments by doctor ID
    List<Appointment> findByDoctorDoctorId(Long doctorId);
}
