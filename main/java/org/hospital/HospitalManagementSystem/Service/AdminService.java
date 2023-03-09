package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.AdminDao;
import org.hospital.HospitalManagementSystem.dto.Admin;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.hospital.HospitalManagementSystem.util.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class AdminService {
	@Autowired
	private AdminDao dao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		String enPassword = AES.encrypt(admin.getPassword());
		admin.setPassword(enPassword);
		admin = dao.saveAdmin(admin);
		ResponseStructure<Admin> s = new ResponseStructure<Admin>();
		s.setBody(admin);
		s.setMessage("Admin svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		ResponseStructure<Admin> s = new ResponseStructure<Admin>();
		s.setBody(dao.updateAdmin(admin));
		s.setMessage("Admin updated succesfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdmin(int id) {
		ResponseStructure<Admin> s = new ResponseStructure<Admin>();
		Admin Admin = dao.getAdmin(id);
//		String decPassword = AES.decrypt(Admin.getPassword());
//		Admin.setPassword(decPassword);
		
		if (Admin != null) {
			s.setBody(Admin);
			s.setMessage("Admin is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Admin>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteAdmin(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		Admin Admin = dao.getAdmin(id);
		if (Admin != null) {
			dao.deleteAdmin(id);
			s.setBody("Admin is Found");
			s.setMessage("Admin Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			s.setBody("Admin is Not_Found");
			s.setMessage("Admin Unable to Delete");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<Admin>>> findAll() {
		ResponseStructure<List<Admin>> s = new ResponseStructure<List<Admin>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All Admin");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Admin>>>(s, HttpStatus.OK);
	}

}
