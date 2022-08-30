package com.openclassrooms.api.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.repository.Data;

@Service
public class FirestationDAO implements DAO<Firestation>{

	@Override
	public List<Firestation> getAll() {
		
		return Data.getFirestations();
	}

	@Override
	public void save(Firestation firestation) {
		
		Data.getFirestations().add(firestation);
	}

	@Override
	public void delete(Firestation firestation) {
		
		
		Data.getFirestations().remove(firestation);
	}

	@Override
	public void update(Firestation firestation) {
		
		Data.getFirestations().add(firestation);
		
	}

}
