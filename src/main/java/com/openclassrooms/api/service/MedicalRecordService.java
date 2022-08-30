package com.openclassrooms.api.service;


import java.util.List;

import com.openclassrooms.api.model.Medicalrecord;


public interface MedicalRecordService {
	
	
	List<Medicalrecord> getAllMedicalrecord();
	
	void save(Medicalrecord medicalrecord);
	
	void update(Medicalrecord medicalrecord, String firstName);
	
	void delete(Medicalrecord medicalrecord, String firstName);
	
	Medicalrecord getByName(String firstName);
	
	//void updateP(Medicalrecord object, String firstname, String lastname);
	
	

}
