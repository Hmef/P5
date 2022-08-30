package com.openclassrooms.api.dto;

import java.util.List;

public class PersonnnDTO {
	

	private String firstName;
	
	private String lastName;

	private String address;

	private String birthdate;

	private String email;

	private List<String> medications;  // Medicalrecord

	private List<String> allergies;   // Medicalrecord
	
	private String station;  // Station 

	
	
	public PersonnnDTO() {
		
		
	}
	

	public PersonnnDTO(String firstName, String lastName, String address, String birthdate, String email,
			List<String> medications, List<String> allergies, String station) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthdate = birthdate;
		this.email = email;
		this.medications = medications;
		this.allergies = allergies;
		this.station = station;
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



	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getStation() {
		return station;
	}


	public void setStation(String station) {
		this.station = station;
	}
	
	


}
