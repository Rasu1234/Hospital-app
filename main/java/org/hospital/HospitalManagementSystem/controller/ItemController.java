package org.hospital.HospitalManagementSystem.controller;

import java.util.List;


import org.hospital.HospitalManagementSystem.Service.ItemService;
import org.hospital.HospitalManagementSystem.dto.Item;
import org.hospital.HospitalManagementSystem.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	@Autowired
	private ItemService service;

	@PostMapping("/item/{mid}")
	public ResponseEntity<ResponseStructure<Item>> saveItem(@RequestBody Item item, @PathVariable int mid) {
		return service.saveItem(item, mid);
	}

	@PutMapping("/item/{mid}")
	public ResponseEntity<ResponseStructure<Item>> updateItem(@RequestBody Item item, @PathVariable int mid) {
		return service.updateItem(item, mid);
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<ResponseStructure<Item>> getItem(@PathVariable int id) {
		return service.getItem(id);

	}

	@DeleteMapping("/item/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteItem(@PathVariable int id) {
		return service.deleteItem(id);
	}

	@GetMapping("/item")
	public ResponseEntity<ResponseStructure<List<Item>>> findAll() {
		return service.findAll();
	}

}
