package org.hospital.HospitalManagementSystem.repository;

import org.hospital.HospitalManagementSystem.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends  JpaRepository<Item, Integer>{

}
