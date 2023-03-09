package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.StaffService;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.dto.Staff;
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
public class StaffController {
	@Autowired
	private StaffService service;

	@PostMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return service.saveStaff(staff);
	}

	@PutMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff) {
		return service.updateStaff(staff);
	}

	@GetMapping("/staff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getStaff(@PathVariable int id) {
		return service.getStaff(id);

	}

	@DeleteMapping("/staff/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteStaff(@PathVariable int id) {
		return service.deleteStaff(id);
	}

	@GetMapping("/staff")
	public ResponseEntity<ResponseStructure<List<Staff>>> findAll() {
		return service.findAll();
	}

}
