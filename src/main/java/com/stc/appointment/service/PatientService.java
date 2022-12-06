package com.stc.appointment.service;

import com.stc.appointment.entity.*;
import com.stc.appointment.vm.response.*;
import org.springframework.stereotype.*;

public interface PatientService {
    Patient addPatient(Patient patient);

    void validatePatient(long patientId);
}
