package org.hospital.HospitalManagementSystem.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int med_id;
	private String patient_name;
	@CreationTimestamp
	private LocalDateTime med_date;
	@CreationTimestamp
	private LocalDateTime med_time;
	private String med_name;
	private String dosage;
	@OneToMany(mappedBy = "m", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Item> item;
	@ManyToOne
	@JoinColumn
	private EnCounter er;

}
