package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Staff;
import org.hospital.HospitalManagementSystem.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StaffDao {
	@Autowired
	StaffRepository repstaff;

	public Staff saveStaff(Staff staff) {
		return repstaff.save(staff);
	}

	public Staff updateStaff(Staff staff) {
		return repstaff.save(staff);
	}

	public Staff getStaff(int id) {
		Optional<Staff> recstaff = repstaff.findById(id);
		if (recstaff.isEmpty())
			return null;
		else
			return recstaff.get();

	}

	public void deleteStaff(int id) {
		repstaff.deleteById(id);
	}

	public List<Staff> findAll() {
		return repstaff.findAll();
	}

}
