package org.hospital.HospitalManagementSystem.repository;

import org.hospital.HospitalManagementSystem.dto.MedOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedOrderRepository extends  JpaRepository<MedOrder, Integer>{

}
