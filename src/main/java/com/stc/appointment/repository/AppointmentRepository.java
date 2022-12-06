package com.stc.appointment.repository;

import com.stc.appointment.entity.*;
import com.stc.appointment.type.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDateBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

    Optional<Appointment> findByStatusNotAndAppointmentDateEquals(Status status, LocalDateTime appointmentDate);
}
