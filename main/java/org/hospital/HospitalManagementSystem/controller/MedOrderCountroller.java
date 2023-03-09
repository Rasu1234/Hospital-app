package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.MedOrderService;
import org.hospital.HospitalManagementSystem.dto.MedOrder;
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
public class MedOrderCountroller {
	@Autowired
	private MedOrderService service;

	@PostMapping("/medorder/{erid}")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medorder,
			@PathVariable int erid) {
		return service.saveMedOrder(medorder, erid);
	}

	@PutMapping("/medorder/{erid}")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medorder,
			@PathVariable int erid) {
		return service.updateMedOrder(medorder, erid);
	}

	@GetMapping("/medorder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(@PathVariable int id) {
		return service.getMedOrder(id);

	}

	@DeleteMapping("/medorder/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@PathVariable int id) {
		return service.deleteMedOrder(id);
	}

	@GetMapping("/medorder")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> findAll() {
		return service.findAll();
	}

}
