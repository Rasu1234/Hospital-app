package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.EnCounterService;
import org.hospital.HospitalManagementSystem.dto.EnCounter;
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
public class EnCounterController {
	@Autowired
	private EnCounterService service;

	@PostMapping("/encounter/{p_id}")
	public ResponseEntity<ResponseStructure<EnCounter>> saveEnCounter(@RequestBody EnCounter e,
			@PathVariable int p_id) {
		return service.saveEnCounter(e, p_id);
	}

	@PutMapping("/encounter/{p_id}")
	public ResponseEntity<ResponseStructure<EnCounter>> updateEnCounter(@RequestBody EnCounter e,
			@PathVariable int p_id) {
		return service.updateEnCounter(e, p_id);
	}

	@GetMapping("/encounter/{id}")
	public ResponseEntity<ResponseStructure<EnCounter>> getEnCounter(@PathVariable int id) {
		return service.getEnCounter(id);

	}

	@DeleteMapping("/encounter/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEnCounter(@PathVariable int id) {
		return service.deleteEnCounter(id);
	}

	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<List<EnCounter>>> findAll() {
		return service.findAll();
	}

}
