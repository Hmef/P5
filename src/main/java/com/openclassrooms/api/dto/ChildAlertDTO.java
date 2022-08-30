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
	
	
	
	
	// GET  http://localhost:8080/childAlert?address=<address> 
	
	//Cette url doit retourner une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant à cette adresse.
	
	// Afficher La liste doit comprendre le prénom et le nom de famille de chaque enfant, 
	//son âge et une liste des autres membres du foyer. 
	//S'il n'y a pas d'enfant, cette url peut renvoyer une chaîne vide.
	
	
	// Service:
	
	// if( age <= 18 )
	// person.getLastName.equal(child.getLastname())
	// si il n y a pas d'enfant, on fait pas return null, mais return une liste vide 
	
}
