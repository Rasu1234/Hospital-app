package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.AdderssDao;
import org.hospital.HospitalManagementSystem.dto.Adderss;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdderssService {
	@Autowired
	private AdderssDao dao;

	public ResponseEntity<ResponseStructure<Adderss>> saveAdderss(Adderss Adderss) {
		Adderss = dao.saveAdderss(Adderss);
		ResponseStructure<Adderss> s = new ResponseStructure<Adderss>();
		s.setBody(Adderss);
		s.setMessage("Adderss svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Adderss>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Adderss>> updateAdderss(Adderss Adderss) {
		ResponseStructure<Adderss> s = new ResponseStructure<Adderss>();
		s.setBody(dao.updateAdderss(Adderss));
		s.setMessage("Adderss updated succesfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Adderss>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Adderss>> getAdderss(int id) {
		ResponseStructure<Adderss> s = new ResponseStructure<Adderss>();
		Adderss Adderss = dao.getAdderss(id);
		if (Adderss != null) {
			s.setBody(Adderss);
			s.setMessage("Adderss is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Adderss>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteAdderss(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		Adderss Adderss = dao.getAdderss(id);
		if (Adderss != null) {
			dao.deleteAdderss(id);
			s.setBody("Adderss is Found");
			s.setMessage("Adderss Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			s.setBody("Adderss is Not_Found");
			s.setMessage("Adderss Unable to Delete");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<Adderss>>> findAll() {
		ResponseStructure<List<Adderss>> s = new ResponseStructure<List<Adderss>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All Adderss");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Adderss>>>(s, HttpStatus.OK);
	}

}
