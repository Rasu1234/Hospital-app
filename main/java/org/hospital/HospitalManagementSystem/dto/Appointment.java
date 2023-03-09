package org.hospital.HospitalManagementSystem.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDateTime appointmentTimestamp;
	private boolean stared;
	private boolean ended;
	private String reason;

	@ManyToOne
	private Person p;
	@ManyToOne
	private Doctor doctors;
	

}
