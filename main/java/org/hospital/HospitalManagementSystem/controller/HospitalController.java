package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.HospitalService;
import org.hospital.HospitalManagementSystem.dto.Hospital;
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
public class HospitalController {
	@Autowired
	private HospitalService service;

	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}

	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital) {
		return service.updateHospital(hospital);
	}

	@GetMapping("/hospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(@PathVariable int id) {
		return service.getHospital(id);

	}

	@DeleteMapping("/hospital/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteHospital(@PathVariable int id) {
		return service.deleteHospital(id);
	}

	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAll() {
		return service.findAll();
	}

}
