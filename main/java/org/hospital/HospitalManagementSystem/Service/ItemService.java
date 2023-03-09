package org.hospital.HospitalManagementSystem.Service;

import java.util.List;

import org.hospital.HospitalManagementSystem.dao.ItemDao;
import org.hospital.HospitalManagementSystem.dto.Item;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.hospital.HospitalManagementSystem.exception.idNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	private ItemDao dao;

	public ResponseEntity<ResponseStructure<Item>> saveItem(Item item, int mid) {
		Item it =dao.saveItem(item, mid);
		ResponseStructure<Item> s = new ResponseStructure<Item>();
		s.setBody(item);
		s.setMessage("Item svae sucessfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Item>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Item>> updateItem(Item item, int mid) {
		ResponseStructure<Item> s = new ResponseStructure<Item>();
		s.setBody(dao.updateItem(item, mid));
		s.setMessage("Item updated succesfully");
		s.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Item>>(s, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Item>> getItem(int id) {
		ResponseStructure<Item> s = new ResponseStructure<Item>();
		Item it = dao.getItem(id);
		if (it != null) {
			s.setBody(it);
			s.setMessage("Item is Found");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Item>>(s, HttpStatus.FOUND);
		} else {
			throw new idNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteItem(int id) {
		ResponseStructure<String> s = new ResponseStructure<>();
		Item Item = dao.getItem(id);
		if (Item != null) {
			dao.deleteItem(id);
			s.setBody("Item is Found");
			s.setMessage("Item Delete Succesfully");
			s.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.FOUND);
		} else {
			s.setBody("Item is Not_Found");
			s.setMessage("Item Unable to Delete");
			s.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(s, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<Item>>> findAll() {
		ResponseStructure<List<Item>> s = new ResponseStructure<List<Item>>();
		s.setBody(dao.findAll());
		s.setMessage("Found The All Item");
		s.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Item>>>(s, HttpStatus.OK);
	}

}
