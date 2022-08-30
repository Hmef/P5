package com.openclassrooms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.service.MedicalRecordService;

@RestController
public class MedicalRecordController {

	
	private static Logger logger = LoggerFactory.getLogger(MedicalRecordController.class);
	
	@Autowired
	MedicalRecordService medicalrecordservice;
	
	
	
	@GetMapping(value = "/medicalrecord")
	public List<Medicalrecord> getAllMedicalRecord(){
		
		logger.info(" Get List of Medical Record --> http://localhost:9091/medicalrecord/");
		
		return medicalrecordservice.getAllMedicalrecord();
	}
	
	
	@GetMapping(value = "/medicalrecord/{firstName}")
	public Medicalrecord getMedicalRecord(@PathVariable("firstName") String firstName) {
		
		return medicalrecordservice.getByName(firstName); 
	}
	
	
	@PostMapping(value = "/medicalrecord")
	public void createMedicalRecord(@RequestBody Medicalrecord medicalrecord) {
		
		logger.info(" Create Medical Record --> http://localhost:9091/medicalrecord/");
		logger.info(" body : " + medicalrecord);
		
		medicalrecordservice.save(medicalrecord);
	}
	
	@PutMapping(value = "/medicalrecord/{firstName}")
	public void updateMedicarecord(@RequestBody Medicalrecord medicalrecord, String firstName) {
		
		logger.info(" Update Medical Record --> http://localhost:9091/medicalrecord/{firstName}");
		logger.info(" body : " + medicalrecord);
		
		medicalrecordservice.update(medicalrecord, firstName);
	}
	
	
	@DeleteMapping(value="/medicalrecord/{firstName}")
	public void deleteMedicalrecord(@RequestBody Medicalrecord medicalrecord, String firstName) {
		
		medicalrecordservice.delete(medicalrecord, firstName);
	}

	
	
	
}
