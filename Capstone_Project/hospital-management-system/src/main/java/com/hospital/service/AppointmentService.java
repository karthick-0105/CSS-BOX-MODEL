package com.hospital.service;

import com.hospital.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByDoctor(Long doctorId);
}
