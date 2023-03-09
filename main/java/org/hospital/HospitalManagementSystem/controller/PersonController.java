package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.PersonService;
import org.hospital.HospitalManagementSystem.dto.Person;
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
public class PersonController {
	@Autowired
	private PersonService service;

	@PostMapping("/person/{eid}")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person, @PathVariable int eid) {
		return service.savePerson(person, eid);
	}

	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person, @PathVariable int eid) {
		return service.updatePerson(person, eid);
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<Person>> getPerson(@PathVariable int id) {
		return service.getPerson(id);

	}

	@DeleteMapping("/Person/{id}")
	public ResponseEntity<ResponseStructure<String>> deletePerson(@PathVariable int id) {
		return service.deletePerson(id);
	}

	@GetMapping("/Person")
	public ResponseEntity<ResponseStructure<List<Person>>> findAll() {
		return service.findAll();
	}

}
