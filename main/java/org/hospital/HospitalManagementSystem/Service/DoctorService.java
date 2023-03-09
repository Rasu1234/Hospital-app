package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.DoctorDao;
import org.hospital.HospitalManagementSystem.dto.Doctor;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DoctorService {
  @Autowired
  private DoctorDao dao;
  
  public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor, int pid) {
		doctor = dao.saveDoctor(doctor, pid);
		ResponseStructure<Doctor> s = new ResponseStructure<Doctor>();

		s.setBody(doctor);
		s.setMessage("Doctor svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Doctor>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(Doctor doctor, int pid) {
		doctor = dao.saveDoctor(doctor, pid);
		ResponseStructure<Doctor> s = new ResponseStructure<Doctor>();

		s.setBody(doctor);
		s.setMessage("Doctor svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Doctor>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Doctor>> getDoctor(int id) {
		ResponseStructure<Doctor> s = new ResponseStructure<Doctor>();
		Doctor doctor = dao.getDoctor(id);
		if (doctor != null) {
			s.setBody(doctor);
			s.setMessage("Doctor is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Doctor>>(s, HttpStatus.FOUND);
		} else {
			s.setBody(doctor);
			s.setMessage("Doctor is Not Found");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Doctor>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteDoctor(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		Doctor doctor = dao.getDoctor(id);
		if (doctor != null) {
			dao.deleteDoctor(id);
			s.setBody("Doctor is Found");
			s.setMessage("Doctor Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Doctor>>> findAll() {
		ResponseStructure<List<Doctor>> doc = new ResponseStructure<List<Doctor>>();
		doc.setBody(dao.findAll());
		doc.setMessage("Found The All Doctor");
		doc.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(doc, HttpStatus.OK);
	}
  
}
