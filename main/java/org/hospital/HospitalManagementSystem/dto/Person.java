package org.hospital.HospitalManagementSystem.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nmae;
	private String email;
	private long phone;
	@OneToMany(mappedBy = "p", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnCounter> encounter;
	@OneToMany
	private List<Appointment> app;
	@ManyToMany
	private List<Doctor> doc;
}
