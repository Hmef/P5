package com.openclassrooms.api.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.repository.Data;

@Service
public class MedicalRecordDAO implements DAO<Medicalrecord>{

	@Override
	public List<Medicalrecord> getAll() {
		
		return Data.getMedicalrecords();
	}

	@Override
	public Medicalrecord save(Medicalrecord medicalrecord) {
		
		Data.getMedicalrecords().add(medicalrecord);
		
		return medicalrecord;
		
	}

	@Override
	public void delete(Medicalrecord medicalrecord) {
		
		Data.getMedicalrecords().remove(medicalrecord);
		
	}

	@Override
	public Medicalrecord update(Medicalrecord medicalrecord) {
		
		Data.getMedicalrecords().add(medicalrecord);
		
		return medicalrecord;
	}

	
}
