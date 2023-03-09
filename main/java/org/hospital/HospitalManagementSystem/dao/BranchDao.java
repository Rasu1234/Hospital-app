package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Branch;
import org.hospital.HospitalManagementSystem.dto.Hospital;
import org.hospital.HospitalManagementSystem.repository.BranchRepository;
import org.hospital.HospitalManagementSystem.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BranchDao {
	@Autowired
	BranchRepository rep;
	@Autowired
	HospitalRepository repo;
	

	public Branch saveBranch(Branch branch, int hid) {
		Optional<Hospital> hospital = repo.findById(hid);
		

		if (hospital.isEmpty())
			return null;
		else {
			hospital.get().getBr().add(branch);
			
			
			branch.setH(hospital.get());
			
			return rep.save(branch);
		}
	}



	public Branch updateBranch(Branch branch, int hid) {
		Optional<Hospital> hospital = repo.findById(hid);
		

		if (hospital.isEmpty())
			return null;
		else {
			hospital.get().getBr().add(branch);
			
			
			branch.setH(hospital.get());
			
			return rep.save(branch);
		}
	}

	public Branch getBranch(int id) {
		Optional<Branch> recbr = rep.findById(id);
		if (recbr.isEmpty())
			return null;
		else
			return recbr.get();

	}

	public void deleteBranch(int id) {
		rep.deleteById(id);
	}

	public List<Branch> findAll() {
		return rep.findAll();
	}
}
