package com.stc.appointment.service.impl;

import com.stc.appointment.constant.*;
import com.stc.appointment.entity.*;
import com.stc.appointment.exception.*;
import com.stc.appointment.repository.*;
import com.stc.appointment.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void validatePatient(long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (!patientOptional.isPresent()) {
            throw new BusinessException(ErrorCodes.PATIENT_NOT_FOUNT);
        }
    }
}
