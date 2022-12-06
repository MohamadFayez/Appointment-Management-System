package com.stc.appointment.vm.request;

import lombok.*;

import java.time.*;

@Data
public class FiltrationRequest {
    private LocalDateTime fromDate = LocalDateTime.MIN;
    private LocalDateTime toDate = LocalDateTime.MAX;
    private String patientName;

}
