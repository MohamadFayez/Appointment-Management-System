package com.stc.appointment.entity;

import com.stc.appointment.type.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;

@Data
@Table(name = "appointments")
@Entity
public class Appointment {
    @Id
    @Column(name = "appointment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentId;
    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @Enumerated(EnumType.STRING)
    @Column(name = "cancellation_reason")
    private CancellationReason cancellationReason;
    @Column(name = "patient_id")
    private long patientId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false, insertable = false, updatable = false)
    private Patient patient;
}
