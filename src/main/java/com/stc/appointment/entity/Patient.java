package com.stc.appointment.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Table(name = "patients")
@Entity
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private Long patientId;
	@Column(name = "patient_name")
	private String patientName;
	@Column(name = "mobile_number")
	private String mobileNumber;
}
