package com.openclassrooms.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openclassrooms.api.data.Data;
import com.openclassrooms.api.model.Firestation;

@Repository 
public class FirestationDAO implements DAO<Firestation>{

	@Override
	public List<Firestation> getAll() {
		
		return Data.getFirestations();
	}

	@Override
	public Firestation save(Firestation firestation) {
		
		Data.getFirestations().add(firestation);
		
		return firestation;
	}

	@Override
	public void delete(Firestation firestation) {
		
		
		Data.getFirestations().remove(firestation);
	}

	@Override
	public Firestation update(Firestation firestation) {
		
		Data.getFirestations().add(firestation);
		
		return firestation;
		
	}

}
