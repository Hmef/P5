package com.openclassrooms.api.dto;

import java.util.List;

public class PersonMedicalRecordFireDTO {
	
	private String name;
	private String phone;
	private int age;
	private List<String> medications;
	private List<String> allergies;

	public PersonMedicalRecordFireDTO() {
		
	}

	public PersonMedicalRecordFireDTO(String name, String phone, int age, List<String> medications,
			List<String> allergies) {
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	@Override
	public String toString() {
		return "PersonMedicalRecordFireDTO [name=" + name + ", phone=" + phone + ", age=" + age + ", medications="
				+ medications + ", allergies=" + allergies + "]";
	}
	
	

}
