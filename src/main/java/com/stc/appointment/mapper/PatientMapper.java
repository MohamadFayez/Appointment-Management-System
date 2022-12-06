package com.stc.appointment.mapper;

import com.stc.appointment.entity.*;
import com.stc.appointment.vm.request.*;
import com.stc.appointment.vm.response.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {

     PatientResponse toViewModel(Patient patient);

     Patient toEntity(PatientRequest patientRequest);
}
