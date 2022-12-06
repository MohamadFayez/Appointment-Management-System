package com.stc.appointment.repository;

import com.stc.appointment.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
