package com.stc.appointment.controller;

import com.stc.appointment.common.*;
import com.stc.appointment.constant.*;
import com.stc.appointment.entity.*;
import com.stc.appointment.mapper.*;
import com.stc.appointment.service.*;
import com.stc.appointment.vm.request.*;
import com.stc.appointment.vm.response.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@Validated
@RestController
@RequestMapping("${app.config.appointment-management.base-uri}")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientMapper patientMapper;

    @Tag(name = "add patient data")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping(value = "${app.config.appointment-management.api.add-patient}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPatient(@Valid @RequestBody PatientRequest patientRequest) {
        Patient patient = patientMapper.toEntity(patientRequest);
        patient = patientService.addPatient(patient);
        PatientResponse patientResponse = patientMapper.toViewModel(patient);

         return ResponseEntity.ok().body(APIResponse.builder().code(Constants.OK).data(patientResponse).message(Constants.SUCCESS).build());
    }
}
