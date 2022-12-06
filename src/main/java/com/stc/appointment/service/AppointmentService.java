package com.stc.appointment.service;

import com.stc.appointment.entity.*;
import com.stc.appointment.type.*;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;

public interface AppointmentService {

    List<Appointment> todayAppointments();
    Appointment addAppointment(Appointment appointment);
    Appointment cancelAppointment(long appointmentId, CancellationReason cancellationReason);
    List<Appointment> filterAppointments(LocalDateTime fromDate, LocalDateTime toDate, String patientName);

}
