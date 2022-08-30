package com.openclassrooms.api.service;

import java.text.ParseException;
import java.util.List;

import com.openclassrooms.api.dto.ChildAlertDTO;
import com.openclassrooms.api.dto.CountDTO;
import com.openclassrooms.api.dto.FireDTO;
import com.openclassrooms.api.dto.FirestationDTO;
import com.openclassrooms.api.dto.FloodDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordDTO;
import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.model.Person;

public interface ServiceClass {

	
	 List<PersonMedicalRecordDTO> getPersonInfo(String firstName, String lastName) throws ParseException;
	 
	 List<String> getEmailByCity(String city);
	 
	 //Person getByName(String firstName, String lastName);
	 
	 List<ChildAlertDTO> getChildByAddress(String address) throws ParseException;
	 
	 List<FloodDTO> GetListHomeByCasernnn(String firestationNum) throws ParseException;
	 
	 Firestation getFirestationByStation(String station);
	 
	 List<String> getPhoneListByCasern(String numberFirestation);
	 
	 FireDTO getListPersonByAddressStation(String address) throws ParseException ;
	 
	 List<FirestationDTO> getPersonByStationAddress(String address) throws ParseException;
	 
	 List<CountDTO> getCountPersonBystation(String stationNumber) throws ParseException;
	 
	 Firestation getFirestation(String address);
	 
	 List<Person> getAddressPerson(String address);
	 
	 int calculteAge(String birthdate) throws ParseException;
	 
	 
}
