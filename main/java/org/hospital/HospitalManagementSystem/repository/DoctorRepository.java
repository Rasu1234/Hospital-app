package org.hospital.HospitalManagementSystem.repository;

import org.hospital.HospitalManagementSystem.dto.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository  extends  JpaRepository<Doctor, Integer>{

}
