package org.hospital.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.hospital.HospitalManagementSystem.dto.EnCounter;
import org.hospital.HospitalManagementSystem.dto.MedOrder;
import org.hospital.HospitalManagementSystem.repository.EnCounterRepository;
import org.hospital.HospitalManagementSystem.repository.ItemRepository;
import org.hospital.HospitalManagementSystem.repository.MedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MedOrderDao {
	@Autowired
	MedOrderRepository rep;
	@Autowired
	EnCounterRepository erep;
	@Autowired
	ItemRepository irep;

	public MedOrder saveMedOrder(MedOrder medorder, int erid) {

		Optional<EnCounter> encounter = erep.findById(erid);

		if (encounter.isEmpty())
			return null;
		else

			encounter.get().getMo().add(medorder);

		return rep.save(medorder);

	}

	public MedOrder updateMedOrder(MedOrder medorder, int erid) {
		Optional<EnCounter> encounter = erep.findById(erid);

		if (encounter.isEmpty())
			return null;
		else

			encounter.get().getMo();

		return rep.save(medorder);

	}

	public MedOrder getMedOrder(int id) {
		Optional<MedOrder> recm = rep.findById(id);
		if (recm.isEmpty())
			return null;
		else
			return recm.get();

	}

	public void deleteMedOrder(int id) {
		rep.deleteById(id);
	}

	public List<MedOrder> findAll() {
		return rep.findAll();
	}

}
