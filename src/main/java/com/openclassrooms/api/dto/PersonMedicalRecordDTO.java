package com.openclassrooms.api.dto;

import java.util.List;

import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;

public class PersonMedicalRecordDTO {

	private String name;

	private String address;

	private int age;

	private String email;

	private List<String> medications;

	private List<String> allergies;

	public PersonMedicalRecordDTO() { 

	}

	public PersonMedicalRecordDTO(String name, String address, int age, String email, List<String> medications,
			List<String> allergies) {

		this.name = name;
		this.address = address;
		this.age = age;
		this.email = email;
		this.medications = medications;
		this.allergies = allergies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	

}
