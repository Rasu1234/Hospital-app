package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Admin;
import org.hospital.HospitalManagementSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminDao {
	@Autowired
	AdminRepository repadmin;
	
	public Admin saveAdmin (Admin admin) {
		return repadmin.save(admin) ;
	}

	public Admin updateAdmin(Admin admin) {
		return repadmin.save(admin) ;
	}
	
	public Admin getAdmin(int id) {
		Optional<Admin> recadmin=repadmin.findById(id);
		if(recadmin.isEmpty())
			return null;
		else
			return recadmin.get();
		
		
	
		
	}
	
	public void deleteAdmin(int id) {
		repadmin.deleteById(id);
	}
	public List<Admin> findAll(){
		return repadmin.findAll();
	}


}
