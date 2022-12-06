package com.stc.appointment.service.impl;

import com.stc.appointment.constant.*;
import com.stc.appointment.entity.*;
import com.stc.appointment.exception.*;
import com.stc.appointment.repository.*;
import com.stc.appointment.service.*;
import com.stc.appointment.type.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientService patientService;
    @Override
    public List<Appointment> todayAppointments() {

        LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
        LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
        List<Appointment> appointments = appointmentRepository.findByAppointmentDateBetween(startOfDay, endOfDay);
        return appointments;
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findByStatusNotAndAppointmentDateEquals(Status.CANCELLED, appointment.getAppointmentDate());
        if (appointmentOptional.isPresent()) {
            throw new BusinessException(ErrorCodes.APPOINTMENT_DATE_ALREADY_RESERVED);
        }
        patientService.validatePatient(appointment.getPatientId());
        appointment.setStatus(Status.RESERVED);
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment cancelAppointment(long appointmentId, CancellationReason cancellationReason) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        if (!appointmentOptional.isPresent()) {
            throw new ResourceNotFoundException(ErrorCodes.APPOINTMENT_NOT_FOUND);
        }
        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(Status.CANCELLED);
        appointment.setCancellationReason(cancellationReason);
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> filterAppointments(LocalDateTime fromDate, LocalDateTime toDate, String patientName) {
        List<Appointment> appointments = appointmentRepository.findByAppointmentDateBetween(fromDate, toDate);
        if (appointments.size() > 0 && patientName != null) {

            appointments = appointments.stream()
                    .filter(appointment -> appointment.getPatient().getPatientName().equalsIgnoreCase(patientName))
                    .collect(Collectors.toList());
        }
        return appointments;
    }
}
