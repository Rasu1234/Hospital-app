package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Hospital;
import org.hospital.HospitalManagementSystem.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class HospitalDao {
	@Autowired
	HospitalRepository rep;

	public Hospital saveHospital(Hospital Hospital) {
		return rep.save(Hospital);
	}

	public Hospital updateHospital(Hospital Hospital) {
		return rep.save(Hospital);
	}
	
	public Hospital getHospital(int id) {
		Optional<Hospital> rechos=rep.findById(id);
		if(rechos.isEmpty())
			return null;
		else
			return rechos.get();
		
		
		
	}
	
	public void deleteHospital(int id) {
		rep.deleteById(id);
	}
	public List<Hospital> findAll(){
		return rep.findAll();
	}

}
