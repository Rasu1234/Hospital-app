package org.hospital.HospitalManagementSystem.repository;

import org.hospital.HospitalManagementSystem.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends  JpaRepository<Person, Integer> {

}
