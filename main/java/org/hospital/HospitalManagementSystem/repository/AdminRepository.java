package org.hospital.HospitalManagementSystem.repository;

import org.hospital.HospitalManagementSystem.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

public interface AdminRepository extends    JpaRepository<Admin, Integer> {

}
