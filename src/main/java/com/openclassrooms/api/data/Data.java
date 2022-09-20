package com.openclassrooms.api.data;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	@JsonProperty("persons")
	public static List<Person> persons = new ArrayList<Person>();

	@JsonProperty("medicalrecords")
	public static List<Medicalrecord> medicalrecords = new ArrayList<Medicalrecord>();

	@JsonProperty("firestations")
	public static List<Firestation> firestations = new ArrayList<Firestation>(); 



	public static List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		Data.persons = persons;
	}

	public static List<Medicalrecord> getMedicalrecords() {
		return medicalrecords;
	}

	public void setMedicalrecords(List<Medicalrecord> medicalrecords) {
		Data.medicalrecords = medicalrecords;
	}

	public static List<Firestation> getFirestations() {
		return firestations;
	}

	public void setFirestations(List<Firestation> firestations) {
		Data.firestations = firestations;
	}

	
	

}
