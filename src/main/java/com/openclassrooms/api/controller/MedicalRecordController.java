package com.openclassrooms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public List<Medicalrecord> getAllMedicalRecord() {

		logger.info(" Get a List of Medical Records --> http://localhost:9091/medicalrecord/");

		return medicalrecordservice.getAllMedicalrecord();
	}

	@PostMapping(value = "/medicalrecord")
	public ResponseEntity<Medicalrecord> createMedicalRecord(@RequestBody Medicalrecord medicalrecord) {

		logger.info(" Create Medical Record --> post http://localhost:9091/medicalrecord/");
		logger.info(" body : " + medicalrecord);

		Medicalrecord createdmedicalrecord = medicalrecordservice.save(medicalrecord);

		if (createdmedicalrecord == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(createdmedicalrecord);
		}
	}

	@PutMapping(value = "/medicalrecord/{firstName}&{lastName}")
	public ResponseEntity<Medicalrecord> updateMedicarecord(@RequestBody Medicalrecord medicalrecord,
			@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {

		logger.info(" Update Medical Record --> put http://localhost:9091/medicalrecord/{firstName}&{lastName}");
		//logger.info(" body : " + medicalrecord);

		Medicalrecord updatedmedicalrecord = medicalrecordservice.update(medicalrecord, firstName, lastName);
		if(updatedmedicalrecord == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(updatedmedicalrecord);
		}
		
	}

	@DeleteMapping(value = "/medicalrecord/{firstName}&{lastName}")
	public ResponseEntity<Medicalrecord> deleteMedicalrecord(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {

		medicalrecordservice.delete(firstName, lastName);

		return ResponseEntity.noContent().build();
	}

}
