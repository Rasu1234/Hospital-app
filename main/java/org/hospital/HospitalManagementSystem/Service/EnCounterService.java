package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.EnCounterDao;
import org.hospital.HospitalManagementSystem.dto.EnCounter;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnCounterService {
	@Autowired
    private EnCounterDao dao;
    public ResponseEntity<ResponseStructure<EnCounter>> saveEnCounter(EnCounter EnCounter,int p_id) {
   	 EnCounter=dao.saveEnCounter(EnCounter,p_id);
   	 ResponseStructure<EnCounter> s=new ResponseStructure<EnCounter>();
   	 s.setBody(EnCounter);
   	 s.setMessage("EnCounter svae sucessfully");
   	 s.setCode(HttpStatus.ACCEPTED.value());
   	 return new ResponseEntity<ResponseStructure<EnCounter>>(s,HttpStatus.ACCEPTED);	
	}

	public ResponseEntity<ResponseStructure<EnCounter>> updateEnCounter(EnCounter EnCounter,int p_id) {
		ResponseStructure<EnCounter> s=new ResponseStructure<EnCounter>();
  	 s.setBody(dao.updateEnCounter(EnCounter,p_id));
  	 s.setMessage("EnCounter updated succesfully");
  	 s.setCode(HttpStatus.ACCEPTED.value());
	return new ResponseEntity<ResponseStructure<EnCounter>>(s,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<EnCounter>> getEnCounter(int id) {
		ResponseStructure<EnCounter> s=new ResponseStructure<EnCounter>();
		EnCounter EnCounter=dao.getEnCounter(id);
		if(EnCounter!=null) {
			 s.setBody(EnCounter);
		   	 s.setMessage("EnCounter is Found");
		   	 s.setCode(HttpStatus.FOUND.value());
		   	 return new ResponseEntity<ResponseStructure<EnCounter>>(s,HttpStatus.FOUND);
		}
		else {
			s.setBody(EnCounter);
		   	 s.setMessage("EnCounter is Not Found");
		   	 s.setCode(HttpStatus.NOT_FOUND.value());
		   	 return new ResponseEntity<ResponseStructure<EnCounter>>(s,HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteEnCounter(int id) {
		ResponseStructure<String> s=new ResponseStructure<>();
		EnCounter EnCounter=dao.getEnCounter(id);
		if(EnCounter!=null) {
			dao.deleteEnCounter(id);
			s.setBody("EnCounter is Found");
			s.setMessage("EnCounter Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.FOUND);
		}
		else {
			throw new idNotFoundException();
		}
		
	}
	public ResponseEntity<ResponseStructure<List<EnCounter>>> findAll(){
		ResponseStructure<List<EnCounter>> s=new  ResponseStructure<List<EnCounter>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All EnCounter");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<EnCounter>>>(s,HttpStatus.OK) ;
	}
	

}
