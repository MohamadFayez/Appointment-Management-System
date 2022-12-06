package com.stc.appointment.vm.response;

import com.fasterxml.jackson.annotation.*;
import com.stc.appointment.entity.*;
import com.stc.appointment.type.*;
import lombok.*;

import java.time.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentResponse {

    private long appointmentId;
    private LocalDateTime appointmentDate;
    private Status status;
    private CancellationReason cancellationReason;
    private long patientId;
    private Patient patient;
}
