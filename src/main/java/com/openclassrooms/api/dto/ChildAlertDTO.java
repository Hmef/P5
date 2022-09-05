package com.openclassrooms.api.dto;

import java.util.ArrayList;
import java.util.List;

public class ChildAlertDTO {


	private String firstname;
	private String lastname;
	private int age;
	
	List<PersonAlertDTO> personalert = new ArrayList<PersonAlertDTO>();
	
	public ChildAlertDTO() {
		
	}
	
	public ChildAlertDTO(String firstname, String lastname, int age, List<PersonAlertDTO> personalert) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.personalert = personalert;
	}
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<PersonAlertDTO> getPersonalert() {
		return personalert;
	}

	public void setPersonalert(List<PersonAlertDTO> personalert) {
		this.personalert = personalert;
	}

	@Override
	public String toString() {
		return "ChildAlertDTO [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", personalert="
				+ personalert + "]";
	}  
	
	
	
}
