package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.StaffDao;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.dto.Staff;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.hospital.HospitalManagementSystem.util.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StaffService {
    @Autowired
    private StaffDao dao;
    
   

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		String enPassword = AES.encrypt(staff.getPassword());
		staff.setPassword(enPassword);
		staff = dao.saveStaff(staff);
		ResponseStructure<Staff> s = new ResponseStructure<Staff>();
		s.setBody(staff);
		s.setMessage("Staff svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Staff>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff) {
		ResponseStructure<Staff> s = new ResponseStructure<Staff>();
		s.setBody(dao.updateStaff(staff));
		s.setMessage("Staff updated succesfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Staff>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Staff>> getStaff(int id) {
		ResponseStructure<Staff> s = new ResponseStructure<Staff>();
		Staff Staff = dao.getStaff(id);
//		String decPassword = AES.decrypt(Staff.getPassword());
//		Staff.setPassword(decPassword);
		
		if (Staff != null) {
			s.setBody(Staff);
			s.setMessage("Staff is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Staff>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteStaff(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		Staff Staff = dao.getStaff(id);
		if (Staff != null) {
			dao.deleteStaff(id);
			s.setBody("Staff is Found");
			s.setMessage("Staff Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			s.setBody("Staff is Not_Found");
			s.setMessage("Staff Unable to Delete");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<Staff>>> findAll() {
		ResponseStructure<List<Staff>> s = new ResponseStructure<List<Staff>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All Staff");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(s, HttpStatus.OK);
	}
}
