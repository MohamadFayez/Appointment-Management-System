package com.stc.appointment.mapper;

import com.stc.appointment.entity.*;
import com.stc.appointment.vm.request.*;
import com.stc.appointment.vm.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppointmentMapper {

    AppointmentResponse toViewModel(Appointment appointment);
    List<AppointmentResponse> toViewModel(List<Appointment> appointments);

    Appointment toEntity(AppointmentRequest appointmentRequest);
}
