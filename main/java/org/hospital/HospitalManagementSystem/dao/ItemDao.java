package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.Item;
import org.hospital.HospitalManagementSystem.dto.MedOrder;
import org.hospital.HospitalManagementSystem.repository.ItemRepository;
import org.hospital.HospitalManagementSystem.repository.MedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ItemDao {
	@Autowired
	ItemRepository rep;
	@Autowired
	MedOrderRepository mrep;

	public Item saveItem(Item item, int mid) {
		Optional<MedOrder> medorder = mrep.findById(mid);
		if (medorder.isEmpty())
			return null;
		else

			medorder.get().getItem().add(null);
		return rep.save(item);
	}

	public Item updateItem(Item item,int mid) {
		Optional<MedOrder> medorder = mrep.findById(mid);
		if (medorder.isEmpty())
			return null;
		else

			medorder.get().getItem().add(null);
		return rep.save(item);
	}

	public Item getItem(int id) {
		Optional<Item> reci = rep.findById(id);
		if (reci.isEmpty())
			return null;
		else
			return reci.get();

	}

	public void deleteItem(int id) {
		rep.deleteById(id);
	}

	public List<Item> findAll() {
		return rep.findAll();
	}

}
