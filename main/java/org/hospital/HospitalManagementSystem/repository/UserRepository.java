package org.hospital.HospitalManagementSystem.repository;

import org.hospital.HospitalManagementSystem.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends  JpaRepository<User, Integer> {

}
