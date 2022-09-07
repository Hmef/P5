package com.openclassrooms.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.api.dao.FirestationDAO;
import com.openclassrooms.api.model.Firestation;

@Service
public class FirestationServiceImpl implements FirestationService {

	private Logger logger = LoggerFactory.getLogger(FirestationServiceImpl.class);

	@Autowired
	private FirestationDAO firestationdao;

	public List<Firestation> getAllFirestations() {

		logger.info("Get All Firestations ");

		return firestationdao.getAll();
	}

	public Firestation save(Firestation requestedFirestation) {

		Firestation createdfirestation = new Firestation();

		createdfirestation.setAddress(requestedFirestation.getAddress());
		createdfirestation.setStation(requestedFirestation.getStation());

		firestationdao.save(createdfirestation);

		return createdfirestation;

	}

	@Override
	public Firestation updateFirestation(Firestation requestedfirestation, String address) {

		List<Firestation> firestationlist = firestationdao.getAll();
		
		for (Firestation updatedfirestation : firestationlist) {
			if (updatedfirestation.getAddress().equals(address)) {

				updatedfirestation.setAddress(requestedfirestation.getAddress());
				updatedfirestation.setStation(requestedfirestation.getStation());
				
				firestationdao.update(updatedfirestation);
				
				return updatedfirestation;
			}
		}

		return null;
	}
	
	
	public Firestation delete(String address) {

		List<Firestation> firestationlist = firestationdao.getAll();
		
		for (Firestation firestation : firestationlist) {
			if (firestation.getAddress().equals(address)) {

				firestationdao.delete(firestation);
			}
		}
		return null;  	
	}

	
}
