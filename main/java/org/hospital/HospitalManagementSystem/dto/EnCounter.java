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
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class EnCounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String encounter_type;
	private String encounter_diagnosis;
	@CreationTimestamp
	private LocalDateTime encounter_time;
	private String encounter_location;
	private String encounter_dispostion;
	@OneToMany
	private List<MedOrder> mo;
	@ManyToOne
	private Branch bra;
	@ManyToOne
	@JoinColumn
	private Person p;
}
