package com.openclassrooms.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.api.dao.FirestationDAO;
import com.openclassrooms.api.dao.PersonDAO;
import com.openclassrooms.api.dto.ChildAlertDTO;
import com.openclassrooms.api.dto.CountDTO;
import com.openclassrooms.api.dto.FireDTO;
import com.openclassrooms.api.dto.FirestationDTO;
import com.openclassrooms.api.dto.FloodDTO;
import com.openclassrooms.api.dto.HomeFloodDTO;
import com.openclassrooms.api.dto.PersonCountDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordFireDTO;
import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;
import com.openclassrooms.api.repository.Data;

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
		
		/*

		Firestation createdfirestation = new Firestation();

		createdfirestation.setAddress(requestedFirestation.getAddress());
		createdfirestation.setStation(requestedFirestation.getStation());

		firestationdao.save(createdfirestation);

		return createdfirestation;
		*/
		return null;

	}

	public void delete(String address, String station) {

		/*
		for (Firestation firestation : firestationdao.getAll()) {
			if (firestation.getAddress().equals(address) && firestation.getStation().equals(station)) {

				firestationdao.delete(firestation);
			}
		}
		*/
	}

	
	@Override
	public void update(Firestation requestedfirestation, String address) {

		for (Firestation updatedfirestation : firestationdao.getAll()) {
			if (updatedfirestation.getAddress().equals(address)) {

				updatedfirestation.setStation(requestedfirestation.getStation());
			}
		}

	}

}
