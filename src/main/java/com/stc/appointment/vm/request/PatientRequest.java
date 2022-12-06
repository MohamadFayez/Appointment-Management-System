package com.stc.appointment.vm.request;

import lombok.*;

import javax.validation.constraints.*;

@Data
public class PatientRequest {
    @NotBlank
    private String patientName;
    @NotBlank
    private String mobileNumber;
}
