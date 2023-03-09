package org.hospital.HospitalManagementSystem.controller;

import java.util.List;

import org.hospital.HospitalManagementSystem.Service.BranchService;
import org.hospital.HospitalManagementSystem.dto.Branch;
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
public class BranchController {
	@Autowired
	private BranchService service;

	@PostMapping("/branch/{hid}")
	public ResponseEntity<ResponseStructure<Branch>> savebranch(@RequestBody Branch branch,@PathVariable int hid) {
		return service.saveBranch(branch, hid);
	}

	@PutMapping("/branch/{hid}")
	public ResponseEntity<ResponseStructure<Branch>> updatebranch(@RequestBody Branch branch,@PathVariable int hid) {
		return service.updateBranch(branch, hid);
	}

	@GetMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getbranch(@PathVariable int id) {
		return service.getBranch(id);

	}

	@DeleteMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<String>> deletebranch(@PathVariable int id) {
		return service.deleteBranch(id);
	}

	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAll() {
		return service.findAll();
	}
}
