package com.openclassrooms.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.api.dao.MedicalRecordDAO;
import com.openclassrooms.api.model.Medicalrecord;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

	@Autowired
	private MedicalRecordDAO medicalrecordDao;

	public List<Medicalrecord> getAllMedicalrecord() {

		return medicalrecordDao.getAll();
	}

	public Medicalrecord save(Medicalrecord requestedmedicalrecord) {

		Medicalrecord createdmedicalrecord = new Medicalrecord();
		
		createdmedicalrecord.setFirstName(requestedmedicalrecord.getFirstName());
		createdmedicalrecord.setLastName(requestedmedicalrecord.getLastName());
		createdmedicalrecord.setBirthdate(requestedmedicalrecord.getBirthdate());
		createdmedicalrecord.setAllergies(requestedmedicalrecord.getAllergies());
		createdmedicalrecord.setMedications(requestedmedicalrecord.getMedications());

		medicalrecordDao.save(createdmedicalrecord);

		return createdmedicalrecord;

	}

	public Medicalrecord update(Medicalrecord requestedmedicalrecord, String firstName, String lastName) {

		List<Medicalrecord> medicalrecordlist = medicalrecordDao.getAll();

		for (Medicalrecord updatedmedicalrecord : medicalrecordlist) {
			if (updatedmedicalrecord.getFirstName().equals(requestedmedicalrecord.getFirstName())
					&& updatedmedicalrecord.getLastName().equals(requestedmedicalrecord.getLastName())) {

				updatedmedicalrecord.setBirthdate(requestedmedicalrecord.getBirthdate());
				updatedmedicalrecord.setAllergies(requestedmedicalrecord.getAllergies());
				updatedmedicalrecord.setMedications(requestedmedicalrecord.getMedications());

				medicalrecordDao.update(updatedmedicalrecord);
				return updatedmedicalrecord;
			}
		}

		return null;
	}

	public Medicalrecord delete(String firstName, String lastName) {

		List<Medicalrecord> medicalrecordlist = medicalrecordDao.getAll();

		for (Medicalrecord medicalrecord : medicalrecordlist) {
			if (medicalrecord.getFirstName().equals(firstName)
					&& medicalrecord.getLastName().equals(lastName)) {

				medicalrecordDao.delete(medicalrecord);
			}

		}

		return null;
	}


}
