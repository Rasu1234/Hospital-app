package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.AppointmentDao;
import org.hospital.HospitalManagementSystem.dto.Appointment;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentDao dao;

	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(Appointment appointment, int pid) {
		appointment = dao.saveAppointment(appointment, pid);
		ResponseStructure<Appointment> s = new ResponseStructure<Appointment>();

		s.setBody(appointment);
		s.setMessage("Appointment svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Appointment>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(Appointment appointment, int pid) {
		appointment = dao.saveAppointment(appointment, pid);
		ResponseStructure<Appointment> s = new ResponseStructure<Appointment>();

		s.setBody(appointment);
		s.setMessage("Appointment svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Appointment>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Appointment>> getAppointment(int id) {
		ResponseStructure<Appointment> s = new ResponseStructure<Appointment>();
		Appointment appointment = dao.getAppointment(id);
		if (appointment != null) {
			s.setBody(appointment);
			s.setMessage("Appointment is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(s, HttpStatus.FOUND);
		} else {
			s.setBody(appointment);
			s.setMessage("Appointment is Not Found");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteAppointment(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		Appointment appointment = dao.getAppointment(id);
		if (appointment != null) {
			dao.deleteAppointment(id);
			s.setBody("Appointment is Found");
			s.setMessage("Appointment Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Appointment>>> findAll() {
		ResponseStructure<List<Appointment>> appo = new ResponseStructure<List<Appointment>>();
		appo.setBody(dao.findAll());
		appo.setMessage("Found The All Appointment");
		appo.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(appo, HttpStatus.OK);
	}

}
