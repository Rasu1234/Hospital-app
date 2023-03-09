package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.MedOrderDao;
import org.hospital.HospitalManagementSystem.dto.MedOrder;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedOrderService {
	@Autowired
	private MedOrderDao dao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder MedOrder, int erid) {
		MedOrder = dao.saveMedOrder(MedOrder, erid);
		ResponseStructure<MedOrder> s = new ResponseStructure<MedOrder>();
		s.setBody(MedOrder);
		s.setMessage("MedOrder svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<MedOrder>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder MedOrder, int erid) {
		ResponseStructure<MedOrder> s = new ResponseStructure<MedOrder>();
		s.setBody(dao.updateMedOrder(MedOrder, erid));
		s.setMessage("MedOrder updated succesfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<MedOrder>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(int id) {
		ResponseStructure<MedOrder> s = new ResponseStructure<MedOrder>();
		MedOrder MedOrder = dao.getMedOrder(id);
		if (MedOrder != null) {
			s.setBody(MedOrder);
			s.setMessage("MedOrder is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<MedOrder>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		MedOrder MedOrder = dao.getMedOrder(id);
		if (MedOrder != null) {
			dao.deleteMedOrder(id);
			s.setBody("MedOrder is Found");
			s.setMessage("MedOrder Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			s.setBody("MedOrder is Not_Found");
			s.setMessage("MedOrder Unable to Delete");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<MedOrder>>> findAll() {
		ResponseStructure<List<MedOrder>> s = new ResponseStructure<List<MedOrder>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All MedOrder");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<MedOrder>>>(s, HttpStatus.OK);
	}
}
