package com.stc.appointment.vm.request;

import lombok.*;

import javax.validation.constraints.*;
import java.time.*;

@Data
public class AppointmentRequest {
    @NotBlank
    private LocalDateTime appointmentDate;
    @NotBlank
    private long patientId;
}
