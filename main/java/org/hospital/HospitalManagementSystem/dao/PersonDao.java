package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Person;
import org.hospital.HospitalManagementSystem.repository.EnCounterRepository;
import org.hospital.HospitalManagementSystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class PersonDao {
	@Autowired
	PersonRepository rep;
	@Autowired
	EnCounterRepository erep;

	public Person savePerson(Person person, int eid) {

		return rep.save(person);
	}

	public Person updatePerson(Person person, int eid) {
		return rep.save(person);
	}

	public Person getPerson(int id) {
		Optional<Person> recp = rep.findById(id);
		if (recp.isEmpty())
			return null;
		else
			return recp.get();

	}

	public void deletePerson(int id) {
		rep.deleteById(id);
	}

	public List<Person> findAll() {
		return rep.findAll();
	}

}
