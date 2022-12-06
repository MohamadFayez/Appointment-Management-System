package com.stc.appointment.vm.request;

import com.stc.appointment.type.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
public class CancellationRequest {
    @NotBlank
    private long appointmentId;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private CancellationReason cancellationReason;
}
