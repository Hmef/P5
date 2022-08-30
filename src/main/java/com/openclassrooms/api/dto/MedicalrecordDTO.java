package com.openclassrooms.api.dto;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicalrecordDTO {
	
	
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String birthdate;
	@JsonProperty
	private List<String> medications;
	@JsonProperty
	private List<String> allergies;


	public MedicalrecordDTO() {
		
	}


	public MedicalrecordDTO(String firstName, String lastName, String birthdate, List<String> medications,
			List<String> allergies) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	
	public List<String> getMedications() {
		return medications;
	}


	public void setMedications(List<String> medications) {
		this.medications = medications;
	}


	public List<String> getAllergies() {
		return allergies;
	}


	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}



}
