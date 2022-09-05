package com.openclassrooms.api.service;

import java.util.List;

import com.openclassrooms.api.model.Firestation;


public interface FirestationService {
	
	
	List<Firestation> getAllFirestations();
	
	Firestation save(Firestation firestation);
	
	Firestation delete(String address, String station);
	
	Firestation update(Firestation firestation, String address);

}
