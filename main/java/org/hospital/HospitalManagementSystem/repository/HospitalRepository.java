package org.hospital.HospitalManagementSystem.repository;

import org.hospital.HospitalManagementSystem.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends  JpaRepository<Hospital, Integer> {

}
