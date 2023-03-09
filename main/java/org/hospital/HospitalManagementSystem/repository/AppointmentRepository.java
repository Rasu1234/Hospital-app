package org.hospital.HospitalManagementSystem.repository;


import org.hospital.HospitalManagementSystem.dto.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}
