package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.AdderssService;
import org.hospital.HospitalManagementSystem.dto.Adderss;
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
public class AdderssController {
	@Autowired
	private AdderssService service;

	@PostMapping("/adderss")
	public ResponseEntity<ResponseStructure<Adderss>> saveAdderss(@RequestBody Adderss adderss) {
		return service.saveAdderss(adderss);
	}

	@PutMapping("/adderss")
	public ResponseEntity<ResponseStructure<Adderss>> updateAdderss(@RequestBody Adderss adderss) {
		return service.updateAdderss(adderss);
	}

	@GetMapping("/adderss/{id}")
	public ResponseEntity<ResponseStructure<Adderss>> getAdderss(@PathVariable int id) {
		return service.getAdderss(id);

	}

	@DeleteMapping("/adderss/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAdderss(@PathVariable int id) {
		return service.deleteAdderss(id);
	}

	@GetMapping("/Adderss")
	public ResponseEntity<ResponseStructure<List<Adderss>>> findAll() {
		return service.findAll();
	}
}
