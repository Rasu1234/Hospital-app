package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Appointment;
import org.hospital.HospitalManagementSystem.dto.Person;
import org.hospital.HospitalManagementSystem.repository.AppointmentRepository;
import org.hospital.HospitalManagementSystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AppointmentDao {
	@Autowired
	AppointmentRepository arep;

	@Autowired
	PersonRepository prep;

	public Appointment saveAppointment(Appointment appo, int pid) {
		Optional<Person> person = prep.findById(pid);

		if (person.isEmpty())
			return null;
		else {

			person.get().getApp().add(appo);
			appo.setP(person.get());
			return arep.save(appo);
		}
	}

	public Appointment updateAppointment(Appointment appo, int pid) {
		Optional<Person> person = prep.findById(pid);

		if (person.isEmpty())
			return null;
		else {

			person.get().getApp().add(appo);
			appo.setP(person.get());
			return arep.save(appo);
		}
	}

	public Appointment getAppointment(int id) {
		Optional<Appointment> reapp = arep.findById(id);
		if (reapp.isEmpty())
			return null;
		else
			return reapp.get();
	}

	public void deleteAppointment(int id) {
		arep.deleteById(id);
	}

	public List<Appointment> findAll() {
		return arep.findAll();
	}

}
