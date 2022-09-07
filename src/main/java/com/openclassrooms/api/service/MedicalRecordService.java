package com.openclassrooms.api.service;


import java.util.List;

import com.openclassrooms.api.model.Medicalrecord;


public interface MedicalRecordService {
	
	
	List<Medicalrecord> getAllMedicalrecord();
	
	Medicalrecord save(Medicalrecord medicalrecord);
	
	Medicalrecord update(Medicalrecord medicalrecord, String firstName, String lastName);
	
	Medicalrecord delete(String firstName, String lastName);
	
	
	

}
