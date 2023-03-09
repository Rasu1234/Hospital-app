package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.BranchDao;
import org.hospital.HospitalManagementSystem.dto.Branch;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private BranchDao dao;
	

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch Branch, int hid) {
		Branch = dao.saveBranch(Branch, hid);
		ResponseStructure<Branch> s = new ResponseStructure<Branch>();

		s.setBody(Branch);
		s.setMessage("Branch svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Branch>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch Branch, int hid) {
		ResponseStructure<Branch> s = new ResponseStructure<Branch>();
		s.setBody(dao.saveBranch(Branch, hid));

		s.setMessage("Branch updated succesfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Branch>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranch(int id) {
		ResponseStructure<Branch> s = new ResponseStructure<Branch>();
		Branch Branch = dao.getBranch(id);
		if (Branch != null) {
			s.setBody(Branch);
			s.setMessage("Branch is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Branch>>(s, HttpStatus.FOUND);
		} else {
			s.setBody(Branch);
			s.setMessage("Branch is Not Found");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Branch>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		Branch Branch = dao.getBranch(id);
		if (Branch != null) {
			dao.deleteBranch(id);
			s.setBody("Branch is Found");
			s.setMessage("Branch Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findAll() {
		ResponseStructure<List<Branch>> s = new ResponseStructure<List<Branch>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All Branch");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(s, HttpStatus.OK);
	}

}
