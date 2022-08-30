package com.openclassrooms.api.service;

import java.util.List;

import com.openclassrooms.api.model.Firestation;


public interface FirestationService {
	
	
	List<Firestation> getAllFirestations();
	
	void update(Firestation firestation);
	
	void save(Firestation firestation);
	
	void delete(Firestation firestation);
	
	void updateP(Firestation object, String firstname, String lastname);

}
