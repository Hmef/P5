package com.openclassrooms.api.dto;

import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;

public class DTO {

	
	//String station = "1";
	//Integer stationn = Integer.valueOf(station);   // convert String to Integer 
	
	
	// dans cette classe on doit définit plusieurs méthodes qui utilisent les 3 objets pour arriver 
	// à avoir le résultat voulu, comme une sorte de requete 
	// AFFICHER le dossier médical du patient ( "John" firstName + LastName ) 
	
	private Person person;  
	private Medicalrecord medicalrecord; 
	private Firestation firestation;
	
	
}
