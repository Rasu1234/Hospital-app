package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.UserDao;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.dto.User;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.hospital.HospitalManagementSystem.util.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserSerivce {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		String enPassword = AES.encrypt(user.getPassword());
		user.setPassword(enPassword);
		user = dao.saveUser(user);
		ResponseStructure<User> s = new ResponseStructure<User>();
		s.setBody(user);
		s.setMessage("user svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> s = new ResponseStructure<User>();
		s.setBody(dao.updateUser(user));
		s.setMessage("user updated succesfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> getUser(int id) {
		ResponseStructure<User> s = new ResponseStructure<User>();
		User user = dao.getUser(id);
//		String decPassword = AES.decrypt(user.getPassword());
//		user.setPassword(decPassword);
		
		if (user != null) {
			s.setBody(user);
			s.setMessage("user is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		User user = dao.getUser(id);
		if (user != null) {
			dao.deleteUser(id);
			s.setBody("User is Found");
			s.setMessage("user Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			s.setBody("User is Not_Found");
			s.setMessage("user Unable to Delete");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		ResponseStructure<List<User>> s = new ResponseStructure<List<User>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All User");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(s, HttpStatus.OK);
	}
}
