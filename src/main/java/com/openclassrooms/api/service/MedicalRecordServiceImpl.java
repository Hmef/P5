package com.openclassrooms.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.api.dao.MedicalRecordDAO;
import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.repository.Data;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {


	@Autowired
	private MedicalRecordDAO medicalrecordDao;
	
	public List<Medicalrecord> getAllMedicalrecord() {

		return medicalrecordDao.getAll();
	}

	public void save(Medicalrecord medicalrecord) {

		//Data.getMedicalrecords().add(medicalrecord);

	}

	public void update(Medicalrecord medicalrecord, String firstName) {

		

	}

	public void delete(Medicalrecord medicalrecord, String firstName) {

	}

	public Medicalrecord getByName(String firstName) {

		for (Medicalrecord medicalrecord : Data.getMedicalrecords()) {

			if (medicalrecord.getFirstName().equals(firstName)) {

				return medicalrecord;
			}
		}
		
		return null;
	}


}
