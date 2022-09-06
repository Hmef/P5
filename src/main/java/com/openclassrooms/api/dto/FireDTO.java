package com.openclassrooms.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FireDTO {

	private String firestationNumber;   
	private List<PersonMedicalRecordFireDTO> persons = new ArrayList<PersonMedicalRecordFireDTO>();
	
	public FireDTO() {

	}

	public FireDTO(String firestationNumber, List<PersonMedicalRecordFireDTO> person) {
		this.firestationNumber = firestationNumber;
		this.persons = person;
	}

	public String getFirestationNumber() {
		return firestationNumber;
	}

	public void setFirestationNumber(String firestationNumber) {
		this.firestationNumber = firestationNumber;
	}

	public List<PersonMedicalRecordFireDTO> getListPersonMedicalRecordFireDTO() {
		return persons;
	}

	public void setPersonMedicalRecordFireDTO(List<PersonMedicalRecordFireDTO> person) {
		this.persons = person;
	}

	

}
