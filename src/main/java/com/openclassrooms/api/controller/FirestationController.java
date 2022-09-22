package com.openclassrooms.api.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

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

import com.openclassrooms.api.dto.CountDTO;
import com.openclassrooms.api.dto.FireDTO;
import com.openclassrooms.api.dto.HomeFloodDTO;
import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.service.FirestationService;
import com.openclassrooms.api.service.ServiceClass;

import io.micrometer.core.ipc.http.HttpSender.Request;

@RestController
public class FirestationController {

	private static Logger logger = LoggerFactory.getLogger(FirestationController.class);

	@Autowired
	private FirestationService firestationservice;

	@Autowired
	private ServiceClass service;

	@GetMapping(value = "/firestation")
	public List<Firestation> getFirestations() {

		logger.info("GET a List of Firestations --> http://localhost:9091/firestation/ ");
		logger.info("" + firestationservice.getAllFirestations());
		//logger.info("get request body" + );
		
		return firestationservice.getAllFirestations();
	}

	@GetMapping(value = "/fire")
	public ResponseEntity<FireDTO> getPersonByStationAdress(String address) throws ParseException {

		logger.info("GET http://localhost:9091/fire?address=<address>");
		logger.info("Get a List of persons Live in this address & NumberStation");

		//return service.getListPersonByAddressStation(address);
		return ResponseEntity.ok(service.getListPersonByAddressStation(address));
	}

	@GetMapping(value = "/flood/stations")
	public Map<String, List<HomeFloodDTO>> getListHomeByCasern(String stationNumber) throws ParseException {

		logger.info("GET http://localhost:9091/flood/stations?stations=<station_numbers>");

		return service.GetListHomeByCasern(stationNumber);

	}

	@GetMapping(value = "/phoneAlert")
	public List<String> getPhoneListByCasern(String firestationNumber) {

		logger.info("GET http://localhost:9091/phoneAlert?firestation=<firestation_number>");
		return service.getPhoneListByCasern(firestationNumber);

	}

	@GetMapping(value = "/firestationCount")
	public CountDTO getCountPersonBystation(String stationNumber) throws ParseException {

		logger.info(" GET http://localhost:9091/firestation?stationNumber=<station_number>");
		return service.getCountPersonBystation(stationNumber);
	}

	@PostMapping("/firestation")
	public ResponseEntity<Firestation> createFirestation(@RequestBody Firestation requestedfirestation){
		
		logger.info("Create Firestation --> post http://localhost:9091/firestation/");
		logger.info("body : " + requestedfirestation);
		
		Firestation createdfirestation = firestationservice.save(requestedfirestation);
		
		if(createdfirestation == null) {
			
			return ResponseEntity.notFound().build();
			
		} else{
			
			return ResponseEntity.ok().body(createdfirestation);
		}
	}
	
	@PutMapping(value = "/firestation/{address}")
	public ResponseEntity<Firestation> updateFirestation(@RequestBody Firestation requestedfirestation, @PathVariable("address") String address) {

		logger.info(" Update Operation ");
		Firestation updatedFirestation = firestationservice.updateFirestation(requestedfirestation, address);

		if (updatedFirestation == null) {

			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(updatedFirestation);
		}

	}
	
	@DeleteMapping(value="/firestation/{address}")
	public ResponseEntity<Firestation> deleteFirestation(@PathVariable String address){
		
		logger.info(" Delete Operation ");
		firestationservice.delete(address);
	
			return ResponseEntity.noContent().build();
		
	}

}
