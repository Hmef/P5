package com.openclassrooms.api.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.dto.ChildAlertDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordDTO;
import com.openclassrooms.api.model.Person;
import com.openclassrooms.api.service.PersonService;
import com.openclassrooms.api.service.ServiceClass;

@RestController
public class PersonController {

	private static Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personservice;

	@Autowired
	private ServiceClass service;

	@GetMapping(value = "/persons")
	public List<Person> getAllPersons() {

		logger.info("Get a List of persons --> http://localhost:9091/persons/ ");

		return personservice.getAll();
	}

	@GetMapping(value = "/communityEmail")
	public List<String> getEmail(String city) {

		logger.info("GET http://localhost:9091/communityEmail?city=<city>");
		
		List<String> emailList = null;
		
		try {
			emailList = service.getEmailByCity(city);
			logger.info(emailList.toString());
			
		}catch (Exception e){
			logger.error("Exception Error : " + e);
		}
		
		return emailList;

	}

	@GetMapping(value = "/personInfo")
	public List<PersonMedicalRecordDTO> getPersonInfo(String firstName, String lastName) throws ParseException {

		logger.info("GET http://localhost:9091/personInfo?firstName=<firstName>&lastName=<lastName> ");
		return service.getPersonInfo(firstName, lastName);
	}

	@GetMapping(value = "/childAlert")
	public List<ChildAlertDTO> getChildByAddress(String address) throws ParseException {

		logger.info("GET http://localhost:9091/childAlert?address=<address>");
		return service.getChildByAddress(address);
	}

	// save operation
	@PostMapping(value = "/persons")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {

		logger.info("Create a person --> post http://localhost:9091/persons/");
		logger.info("body : " + person);

		Person createdperson = personservice.savePerson(person);
		// return "A new person created Successfully";
		if (createdperson == null) {
			logger.error(" Response Not Found ! ");
			return ResponseEntity.notFound().build();
		} else {
			logger.info("Person created Successfully");
			return ResponseEntity.ok().body(createdperson);
		}

	}

	@PutMapping(value = "/persons/{firstName}&{lastName}")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {

		logger.info(" Update Operation ");

		Person updatedPerson = personservice.updatePerson(person, firstName, lastName);

		if (updatedPerson == null) {
			logger.error(" Response Not Found ! ");
			return ResponseEntity.notFound().build();
		} else {

			logger.info("Person updated Successfully");
			return ResponseEntity.ok(updatedPerson);
		}
	}

	@DeleteMapping(value = "/persons/{firstName}&{lastName}")
	public ResponseEntity<Person> deletePerson(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {

		logger.info(" Delete Operation ");
		Person deletedperson = personservice.deletePerson(firstName, lastName);

		if( deletedperson == null ) {
			
			return ResponseEntity.noContent().build();
		}
		
		return null;
		
		// return "Deleted Successfully";

	}

}
