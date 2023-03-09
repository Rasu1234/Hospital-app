package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Doctor;
import org.hospital.HospitalManagementSystem.dto.Person;
import org.hospital.HospitalManagementSystem.repository.DoctorRepository;
import org.hospital.HospitalManagementSystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class DoctorDao {
	@Autowired
	DoctorRepository drep;

	@Autowired
	PersonRepository prep;

	public Doctor saveDoctor(Doctor doctor, int pid) {
		Optional<Person> person = prep.findById(pid);

		if (person.isEmpty())
			return null;
		else {
			person.get().getDoc().add(doctor);
//			doctor.setPerson(person.get());;
			return drep.save(doctor);
		}
	}

	public Doctor updateDoctor(Doctor doctor, int pid) {
		Optional<Person> person = prep.findById(pid);

		if (person.isEmpty())
			return null;
		else {
			person.get().getDoc().add(doctor);
//			doctor.setPerson(person.get());;
			return drep.save(doctor);
		}
	}

	public Doctor getDoctor(int id) {
		Optional<Doctor> recdoc = drep.findById(id);
		if (recdoc.isEmpty())
			return null;
		else
			return recdoc.get();
	}
	
	public void deleteDoctor(int id) {
		drep.deleteById(id);
	}
	public List<Doctor> findAll(){
		return drep.findAll();
		
	}

}
