package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.DoctorService;
import org.hospital.HospitalManagementSystem.dto.Doctor;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService service;

	@PostMapping("/doctor/{hid}")
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor, @PathVariable int hid) {
		return service.saveDoctor(doctor, hid);
	}

	@PutMapping("/doctor/{hid}")
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(@RequestBody Doctor doctor, @PathVariable int hid) {
		return service.updateDoctor(doctor, hid);
	}

	@GetMapping("/doctor/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> getDoctor(@PathVariable int id) {
		return service.getDoctor(id);

	}

	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteDoctor(@PathVariable int id) {
		return service.deleteDoctor(id);
	}

	@GetMapping("/doctor")
	public ResponseEntity<ResponseStructure<List<Doctor>>> findAll() {
		return service.findAll();
	}

}
