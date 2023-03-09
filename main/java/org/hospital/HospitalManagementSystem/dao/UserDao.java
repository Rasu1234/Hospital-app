package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.User;
import org.hospital.HospitalManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	UserRepository rep;

	public User saveUser(User user) {
		return rep.save(user);
	}

	public User updateUser(User user) {
		return rep.save(user);
	}
	
	public User getUser(int id) {
		Optional<User> recUser=rep.findById(id);
		if(recUser.isEmpty())
			return null;
		else
			return recUser.get();
		
		
	
		
	}
	
	public void deleteUser(int id) {
		rep.deleteById(id);
	}
	public List<User> findAll(){
		return rep.findAll();
	}

}
