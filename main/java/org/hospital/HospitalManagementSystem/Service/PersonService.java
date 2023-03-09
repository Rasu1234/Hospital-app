package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.PersonDao;
import org.hospital.HospitalManagementSystem.dto.Person;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
    private PersonDao dao;
    public ResponseEntity<ResponseStructure<Person>> savePerson(Person Person,int eid) {
   	 Person=dao.savePerson(Person,eid);
   	 ResponseStructure<Person> s=new ResponseStructure<Person>();
   	 s.setBody(Person);
   	 s.setMessage("Person svae sucessfully");
   	 s.setCode(HttpStatus.ACCEPTED.value());
   	 return new ResponseEntity<ResponseStructure<Person>>(s,HttpStatus.ACCEPTED);	
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person Person,int eid) {
		ResponseStructure<Person> s=new ResponseStructure<Person>();
  	 s.setBody(dao.updatePerson(Person,eid));
  	 s.setMessage("Person updated succesfully");
  	 s.setCode(HttpStatus.ACCEPTED.value());
	return new ResponseEntity<ResponseStructure<Person>>(s,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Person>> getPerson(int id) {
		ResponseStructure<Person> s=new ResponseStructure<Person>();
		Person Person=dao.getPerson(id);
		if(Person!=null) {
			 s.setBody(Person);
		   	 s.setMessage("Person is Found");
		   	 s.setCode(HttpStatus.FOUND.value());
		   	 return new ResponseEntity<ResponseStructure<Person>>(s,HttpStatus.FOUND);
		}
		else {
			throw new idNotFoundException();
		}
		
		
	}
	
	public ResponseEntity<ResponseStructure<String>> deletePerson(int id) {
		ResponseStructure<String> s=new ResponseStructure<>();
		Person Person=dao.getPerson(id);
		if(Person!=null) {
			dao.deletePerson(id);
			s.setBody("Person is Found");
			s.setMessage("Person Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.FOUND);
		}
		else {
			s.setBody("Person is Not_Found");
			s.setMessage("Person Unable to Delete");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.NOT_FOUND);
		}
		
	}
	public ResponseEntity<ResponseStructure<List<Person>>> findAll(){
		ResponseStructure<List<Person>> s=new  ResponseStructure<List<Person>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All Person");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Person>>>(s,HttpStatus.OK) ;
	}
}
