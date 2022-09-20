package com.openclassrooms.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.api.dao.FirestationDAO;
import com.openclassrooms.api.dao.MedicalRecordDAO;
import com.openclassrooms.api.dao.PersonDAO;
import com.openclassrooms.api.dto.ChildAlertDTO;
import com.openclassrooms.api.dto.CountDTO;
import com.openclassrooms.api.dto.FireDTO;
import com.openclassrooms.api.dto.HomeFloodDTO;
import com.openclassrooms.api.dto.PersonAlertDTO;
import com.openclassrooms.api.dto.PersonCountDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordFireDTO;
import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;

@Service
public class ServiceClassImpl implements ServiceClass {

	private Logger logger = LoggerFactory.getLogger(ServiceClassImpl.class);

	@Autowired
	private PersonDAO persondao;

	@Autowired
	private MedicalRecordDAO medicalrecorddao;

	@Autowired
	private FirestationDAO firestationdao;

	@Override
	public List<PersonMedicalRecordDTO> getPersonInfo(String firstName, String lastName) throws ParseException {

		logger.info("getPersonInfo service ");

		List<PersonMedicalRecordDTO> personmedicalrecordDto = new ArrayList<PersonMedicalRecordDTO>();

		for (Person person : persondao.getAll()) {

			if (person.getLastName().equals(lastName)) {

				PersonMedicalRecordDTO pmDto = new PersonMedicalRecordDTO();
				pmDto.setName(person.getFirstName() + " " + person.getLastName());
				pmDto.setAddress(person.getAddress());
				pmDto.setEmail(person.getEmail());

				for (Medicalrecord medicalrecord : medicalrecorddao.getAll()) {

					if (medicalrecord.getFirstName().equals(person.getFirstName())) {

						pmDto.setAge(calculteAge(medicalrecord.getBirthdate()));
						pmDto.setAllergies(medicalrecord.getAllergies());
						pmDto.setMedications(medicalrecord.getMedications());

					} // End if
				}

				personmedicalrecordDto.add(pmDto);
			}

		}

		return personmedicalrecordDto;

	}

	@Override
	public List<String> getEmailByCity(String city) {

		logger.info("Get Email By City ");

		List<String> emailList = new ArrayList<>();

		for (Person person : persondao.getAll()) {

			if (person.getCity().equals(city)) {

				emailList.add(person.getEmail());

			}
		}

		return emailList;

	}

	@Override
	public List<ChildAlertDTO> getChildByAddress(String address) throws ParseException {

		logger.info(" ChildAlert EndPoint");
		logger.info(" Get the list of the child live in this addresse" + address);

		List<ChildAlertDTO> childlist = new ArrayList<ChildAlertDTO>();

		List<PersonAlertDTO> personalertlist = new ArrayList<PersonAlertDTO>();

		for (Person person : persondao.getAll()) {

			if (person.getAddress().equals(address)) {

				for (Medicalrecord medicalrecord : medicalrecorddao.getAll()) {

					if (medicalrecord.getFirstName().equals(person.getFirstName())
							&& medicalrecord.getLastName().equals(person.getLastName())) {

						int age = calculteAge(medicalrecord.getBirthdate());

						System.out.println(" Age : " + age);

						if (age > 18) {

							PersonAlertDTO personalertdto = new PersonAlertDTO();
							personalertdto.setFirstname(person.getFirstName());
							personalertdto.setLastname(person.getLastName());
							personalertdto.setAge(age);

							personalertlist.add(personalertdto);
						}

						if (age <= 18) {

							ChildAlertDTO child = new ChildAlertDTO();
							child.setFirstname(person.getFirstName());
							child.setLastname(person.getLastName());
							child.setAge(age);

							child.setPersonalert(personalertlist);
							childlist.add(child);
						}
					}
				}
			}
		}

		return childlist;
	}

	// Flood
	@Override
	public Map<String, List<HomeFloodDTO>> GetListHomeByCasern(String firestationNum) throws ParseException {

		List<HomeFloodDTO> homeFloodlist = new ArrayList<HomeFloodDTO>();
		List<String> addresslist = new ArrayList<String>();

		for (Firestation firestation : firestationdao.getAll()) {
			if (firestation.getStation().equals(firestationNum)) {

				addresslist.add(firestation.getAddress());
			}
		}
		for (String address : addresslist) {
			for (Person person : persondao.getAll()) {

				if (person.getAddress().equals(address)) {

					HomeFloodDTO homeFlood = new HomeFloodDTO();

					homeFlood.setName(person.getFirstName() + " " + person.getLastName());
					homeFlood.setPhone(person.getPhone());
					homeFlood.setAddress(person.getAddress());
					
					for(Medicalrecord medicalrecord : medicalrecorddao.getAll()) {
						if(medicalrecord.getFirstName().equals(person.getFirstName())) {
							
							int age = calculteAge(medicalrecord.getBirthdate());
							homeFlood.setAge(age);
							homeFlood.setAllergies(medicalrecord.getAllergies());
							homeFlood.setMedications(medicalrecord.getMedications());
						}
					}

					homeFloodlist.add(homeFlood); 

				} // End if
			} // for person
		} // for address

		/*
		 * Map Solution
		 */

		Map<String, List<HomeFloodDTO>> personByAddressMap = new HashMap<>();

		for (HomeFloodDTO homeFlood : homeFloodlist) {
			if (!personByAddressMap.containsKey(homeFlood.getAddress())) {

				personByAddressMap.put(homeFlood.getAddress(), new ArrayList<>());
			}
			personByAddressMap.get(homeFlood.getAddress()).add(homeFlood);
		}
	
		return personByAddressMap;
	}

	@Override
	public List<String> getPhoneListByCasern(String numberFirestation) {

		logger.info(" PhoneAlert Endpoint ");
		logger.info(" Get the phone List coverd by this station's number : " + numberFirestation);
		List<String> phoneList = new ArrayList<>();
		for (Firestation firestation : firestationdao.getAll()) {

			for (Person person : persondao.getAll()) {

				if (firestation.getStation().equals(numberFirestation)
						&& person.getAddress().equals(firestation.getAddress())) {

					phoneList.add(person.getPhone());
				}
			}
		}

		return phoneList;
	}

	@Override
	public FireDTO getListPersonByAddressStation(String address) throws ParseException {
		
		logger.info(" Fire EndPoint ");
		logger.info(
				" Get the list of the persons live in this address " + address + "and covered by this number station ");

		FireDTO fireDto = new FireDTO();

		List<PersonMedicalRecordFireDTO> pmrfDtoList = new ArrayList<PersonMedicalRecordFireDTO>();

		for (Person person : persondao.getAll()) {

			if (person.getAddress().equals(address)) {

				PersonMedicalRecordFireDTO pmrfDto = new PersonMedicalRecordFireDTO();

				pmrfDto.setName(person.getFirstName() + " " + person.getLastName());
				pmrfDto.setPhone(person.getPhone());

				for (Medicalrecord medicalrecord : medicalrecorddao.getAll()) {
					if (medicalrecord.getFirstName().equals(person.getFirstName())) {

						pmrfDto.setAge(calculteAge(medicalrecord.getBirthdate()));
						pmrfDto.setAllergies(medicalrecord.getAllergies());
						pmrfDto.setMedications(medicalrecord.getMedications());
					}
				}
				if (fireDto.getFirestationNumber() == null) {

					for (Firestation firestation : firestationdao.getAll()) {

						if (firestation.getAddress().equals(address)) {

							fireDto.setFirestationNumber(firestation.getStation());
						}
					}
				}

				pmrfDtoList.add(pmrfDto);
			}
		} // End For

		fireDto.setPersonMedicalRecordFireDTO(pmrfDtoList);
		return fireDto;
	}


	@Override
	public CountDTO getCountPersonBystation(String stationNumber) throws ParseException {

		logger.info(" http://localhost:8080/firestation?stationNumber=<station_number> ");
		logger.info("Get the COUNT of persons by station : " + stationNumber);

		List<PersonCountDTO> personlist = new ArrayList<PersonCountDTO>();
		List<PersonCountDTO> personcountlistAll = new ArrayList<PersonCountDTO>();
		List<String> addresslist = new ArrayList<String>();
		List<Person> addressPersonlistt = new ArrayList<Person>();
		List<Person> addressPersonlist = new ArrayList<Person>();

		List<PersonCountDTO> childlist = new ArrayList<PersonCountDTO>();

		CountDTO countDto = new CountDTO();

		for (Firestation firestation : firestationdao.getAll()) {
			if (firestation.getStation().equals(stationNumber)) {
				String address = firestation.getAddress();
				addresslist.add(address);
			}
		}
		for (String address : addresslist) {

			for (Person person : persondao.getAll()) {
				if (person.getAddress().equals(address)) {

					addressPersonlistt.add(person);
				}
			}
		}
		addressPersonlist.addAll(addressPersonlistt); // //////

		for (Person person : addressPersonlist) {

			PersonCountDTO personcount = new PersonCountDTO();
			personcount.setFirstname(person.getFirstName());
			personcount.setLastname(person.getLastName());
			personcount.setPhone(person.getPhone());
			personcount.setAddress(person.getAddress());

			for (Medicalrecord medicalrecord : medicalrecorddao.getAll()) {
				if (person.getFirstName().equals(medicalrecord.getFirstName())
						&& person.getLastName().equals(medicalrecord.getLastName())) {

					int age = calculteAge(medicalrecord.getBirthdate());
					personcount.setAge(age);
				}
			}
			if (personcount.getAge() <= 18) {

				childlist.add(personcount);
			}

			if (personcount.getAge() > 18) {

				personlist.add(personcount);
			}
		}

		personcountlistAll.addAll(childlist); 
		personcountlistAll.addAll(personlist);

		countDto.setSizechild(childlist.size());
		countDto.setSizeperson(personlist.size());
		countDto.setPersonList(personcountlistAll);


		return countDto;
	}


	
	@Override
	public int calculteAge(String birthdate) throws ParseException {

		logger.info("Calculate Age for this Birthdate : " + birthdate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		LocalDate today = LocalDate.now();

		LocalDate birthDate = dateFormat.parse(birthdate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		int age = Period.between(birthDate, today).getYears();

		return age;

	}

}
