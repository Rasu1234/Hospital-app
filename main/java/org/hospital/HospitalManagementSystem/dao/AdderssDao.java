package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Adderss;
import org.hospital.HospitalManagementSystem.repository.AdderssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AdderssDao {
	@Autowired
	AdderssRepository rep;

	public Adderss saveAdderss(Adderss Adderss) {
		return rep.save(Adderss);
	}

	public Adderss updateAdderss(Adderss Adderss) {
		return rep.save(Adderss);
	}

	public Adderss getAdderss(int id) {
		Optional<Adderss> recadd=rep.findById(id);
		if(recadd.isEmpty())
			return null;
		else
			return recadd.get();
		
		
	}


	public void deleteAdderss(int id) {
		rep.deleteById(id);
	}

	public List<Adderss> findAll() {
		return rep.findAll();
	}
}
