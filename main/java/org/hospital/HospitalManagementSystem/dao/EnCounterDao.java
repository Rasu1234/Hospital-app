package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.EnCounter;
import org.hospital.HospitalManagementSystem.dto.Person;
import org.hospital.HospitalManagementSystem.repository.EnCounterRepository;
import org.hospital.HospitalManagementSystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EnCounterDao {
	@Autowired
	EnCounterRepository rep;

	@Autowired
	PersonRepository prep;

	public EnCounter saveEnCounter(EnCounter encounter, int P_id) {

		Optional<Person> person = prep.findById(P_id);
		if (person.isEmpty())
			return null;
		else

			person.get().getEncounter().add(encounter);
		return rep.save(encounter);
	}

	public EnCounter updateEnCounter(EnCounter encounter, int p_id) {

		Optional<Person> person = prep.findById(p_id);
		if (person.isEmpty())
			return null;
		else

			person.get().getEncounter().add(encounter);
		return rep.save(encounter);
	}

	public EnCounter getEnCounter(int id) {
		Optional<EnCounter> recen = rep.findById(id);
		if (recen.isEmpty())
			return null;
		else
			return recen.get();

	}

	public void deleteEnCounter(int id) {
		rep.deleteById(id);
	}

	public List<EnCounter> findAll() {
		return rep.findAll();
	}

}
