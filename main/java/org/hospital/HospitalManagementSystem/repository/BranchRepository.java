package org.hospital.HospitalManagementSystem.repository;

import org.hospital.HospitalManagementSystem.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends  JpaRepository<Branch, Integer> {

}
