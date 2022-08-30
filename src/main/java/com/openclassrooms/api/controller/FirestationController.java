package com.openclassrooms.api.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

import com.openclassrooms.api.dto.CountDTO;
import com.openclassrooms.api.dto.FireDTO;
import com.openclassrooms.api.dto.FirestationDTO;
import com.openclassrooms.api.dto.FloodDTO;
import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.service.FirestationService;
import com.openclassrooms.api.service.ServiceClass;

@RestController
public class FirestationController {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger("");

	@Autowired
	private FirestationService firestationservice;


	@Autowired
	private ServiceClass service;

	@GetMapping(value = "/firestations")
	public List<Firestation> getFirestations(){
		
		
		return firestationservice.getAllFirestations();
	}
	
	
	@GetMapping(value = "/firestation")
	public Firestation getFirestation(String address) {
		
		return service.getFirestation(address); 
	}
	
	
	@GetMapping(value = "/fire")
	public FireDTO getPersonByStationAdress(String address) throws ParseException{
		
		logger.info("Get http://localhost:8080/fire?address=<address>");
		logger.info("Get a List of persons Live in this address & NumberStation");
		
		return service.getListPersonByAddressStation(address); 
				
	}

	
	@GetMapping(value="/flood/stations")
	public List<FloodDTO> getListHomeByCasern(String stationNumberList) throws ParseException{ 
		
		logger.info("Get http://localhost:8080/flood/stations?stations=<a list of station_numbers>");
		
			return service.GetListHomeByCasernnn(stationNumberList);

	}
	
	
	@GetMapping(value="/phoneAlert")
	public List<String> getPhoneListByCasern( String firestationNumber){

		return  service.getPhoneListByCasern(firestationNumber);
		
	}
	
	@GetMapping(value="/personAddressByStation")
	public List<FirestationDTO> getPersonByStationAddress(String address) throws ParseException{
		
		
		return service.getPersonByStationAddress(address);
	}
	
	@GetMapping(value="/firestationCount")
	public List<CountDTO> getCountPersonBystation(String stationNumber) throws ParseException{
		
		return service.getCountPersonBystation(stationNumber);
	}

	
	

}
