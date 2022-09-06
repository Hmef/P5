package com.openclassrooms.api.dto;

import java.util.List;

public class HomeFloodDTO {

	private String name;
	private String phone;
	private String address;  
	private int age;
	private List<String> medications;
	private List<String> allergies;

	public HomeFloodDTO() {

	}

	public HomeFloodDTO(String name, String phone, String address, int age, List<String> medications,
			List<String> allergies) {
		this.name = name;
		this.phone = phone;
		this.address = address;
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
		return "HomeFloodDTO [name=" + name + ", phone=" + phone + ", address=" + address + ", age=" + age
				+ ", medications=" + medications + ", allergies=" + allergies + "]";
	}

	
	
}
