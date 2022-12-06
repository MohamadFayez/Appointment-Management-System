package com.stc.appointment.controller;

import com.stc.appointment.common.*;
import com.stc.appointment.constant.*;
import com.stc.appointment.entity.*;
import com.stc.appointment.mapper.*;
import com.stc.appointment.service.*;
import com.stc.appointment.vm.request.*;
import com.stc.appointment.vm.response.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@Validated
@RestController
@RequestMapping("${app.config.appointment-management.base-uri}")
public class AppointmentController {


    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private AppointmentService appointmentService;

    @Tag(name = "today appointment for all patient")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping(value = "${app.config.appointment-management.api.today-appointments}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity todayAppointments() {
        List<Appointment> appointments = appointmentService.todayAppointments();
        List<AppointmentResponse> appointmentResponses = appointmentMapper.toViewModel(appointments);

        return ResponseEntity.ok().body(APIResponse.builder().code(Constants.OK).data(appointmentResponses).message(Constants.SUCCESS).build());
    }

    @Tag(name = "add appointment for patient")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping(value = "${app.config.appointment-management.api.add-appointment}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAppointment(@Valid @RequestBody AppointmentRequest appointmentRequest) {
        Appointment appointment = appointmentMapper.toEntity(appointmentRequest);
        appointment = appointmentService.addAppointment(appointment);
        AppointmentResponse appointmentResponse = appointmentMapper.toViewModel(appointment);

        return ResponseEntity.ok().body(APIResponse.builder().code(Constants.OK).data(appointmentResponse).message(Constants.SUCCESS).build());
    }

    @Tag(name = "cancel appointment for patient")
    @ApiResponse(responseCode = "200", description = "Success")
    @PutMapping(value = "${app.config.appointment-management.api.cancel-appointment}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cancelAppointment(@Valid @RequestBody CancellationRequest cancellationRequest) {
        Appointment appointment = appointmentService.cancelAppointment(cancellationRequest.getAppointmentId(), cancellationRequest.getCancellationReason());
        AppointmentResponse appointmentResponse = appointmentMapper.toViewModel(appointment);

        return ResponseEntity.ok().body(APIResponse.builder().code(Constants.OK).data(appointmentResponse).message(Constants.SUCCESS).build());
    }

    @Tag(name = "filter appointments by start and end dates and patient name")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping(value = "${app.config.appointment-management.api.filter-appointments}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity filterAppointments(@Valid @RequestBody FiltrationRequest filtrationRequest) {
        List<Appointment> appointments = appointmentService.filterAppointments(filtrationRequest.getFromDate(), filtrationRequest.getToDate(), filtrationRequest.getPatientName());
        List<AppointmentResponse> appointmentResponses = appointmentMapper.toViewModel(appointments);

        return ResponseEntity.ok().body(APIResponse.builder().code(Constants.OK).data(appointmentResponses).message(Constants.SUCCESS).build());
    }

}
