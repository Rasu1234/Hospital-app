package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.HospitalDao;
import org.hospital.HospitalManagementSystem.dto.Hospital;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital Hospital) {
		Hospital = dao.saveHospital(Hospital);
		ResponseStructure<Hospital> s = new ResponseStructure<Hospital>();
		s.setBody(Hospital);
		s.setMessage("Hospital svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital Hospital) {
		ResponseStructure<Hospital> s = new ResponseStructure<Hospital>();
		s.setBody(dao.updateHospital(Hospital));
		s.setMessage("Hospital updated succesfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospital(int id) {
		ResponseStructure<Hospital> s = new ResponseStructure<Hospital>();
		Hospital Hospital = dao.getHospital(id);
		if (Hospital != null) {
			s.setBody(Hospital);
			s.setMessage("Hospital is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		Hospital Hospital = dao.getHospital(id);
		if (Hospital != null) {
			dao.deleteHospital(id);
			s.setBody("Hospital is Found");
			s.setMessage("Hospital Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			s.setBody("Hospital is Not_Found");
			s.setMessage("Hospital Unable to Delete");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<Hospital>>> findAll() {
		ResponseStructure<List<Hospital>> s = new ResponseStructure<List<Hospital>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All Hospital");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(s, HttpStatus.OK);
	}

}
