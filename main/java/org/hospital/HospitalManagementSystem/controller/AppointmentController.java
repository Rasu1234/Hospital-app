package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.AppointmentService;
import org.hospital.HospitalManagementSystem.dto.Appointment;
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
public class AppointmentController {
	@Autowired
	private AppointmentService service;

	@PostMapping("/appointment/{hid}")
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(@RequestBody Appointment appointment,@PathVariable int hid) {
		return service.saveAppointment(appointment, hid);
	}

	@PutMapping("/appointment/{hid}")
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(@RequestBody Appointment Appointment,@PathVariable int hid) {
		return service.updateAppointment(Appointment, hid);
	}

	@GetMapping("/appointment/{id}")
	public ResponseEntity<ResponseStructure<Appointment>> getAppointment(@PathVariable int id) {
		return service.getAppointment(id);

	}

	@DeleteMapping("/Appointment/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAppointment(@PathVariable int id) {
		return service.deleteAppointment(id);
	}

	@GetMapping("/appointment")
	public ResponseEntity<ResponseStructure<List<Appointment>>> findAll() {
		return service.findAll();
	}

}
