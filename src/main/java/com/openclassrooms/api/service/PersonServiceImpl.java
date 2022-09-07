package com.openclassrooms.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.api.dao.PersonDAO;
import com.openclassrooms.api.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private PersonDAO persondao;

	@Override
	public List<Person> getAll() {

		return persondao.getAll();

	}

	@Override
	public Person savePerson(Person requestedperson) {

		logger.info(" Saved Person ");

		Person newperson = new Person();

		newperson.setFirstName(requestedperson.getFirstName());
		newperson.setLastName(requestedperson.getLastName());
		newperson.setAddress(requestedperson.getAddress());
		newperson.setCity(requestedperson.getCity());
		newperson.setZip(requestedperson.getZip());
		newperson.setEmail(requestedperson.getEmail());
		newperson.setPhone(requestedperson.getPhone());

		persondao.save(newperson);

		return newperson;

	}
	
	
	@Override
	public Person updatePerson(Person requestedperson, String firstName, String lastName) {

		logger.info(" Update Person ");

		List<Person> personlist = persondao.getAll();

		for (Person updatedperson : personlist) {
			if (updatedperson.getFirstName().equals(requestedperson.getFirstName())
					&& updatedperson.getLastName().equals(requestedperson.getLastName())) {

				// person.setFirstName(firstName); // don't change firstName & lastName
				// person.setLastName(lastName);
				updatedperson.setAddress(requestedperson.getAddress());
				updatedperson.setCity(requestedperson.getCity());
				updatedperson.setZip(requestedperson.getZip());
				updatedperson.setEmail(requestedperson.getEmail());
				updatedperson.setPhone(requestedperson.getPhone());
				
				persondao.update(updatedperson);
				
				return updatedperson;
			}
		}

		return null;
	}

	
	@Override
	public Person deletePerson(String firstName, String lastName) {

		logger.info(" Delete Person  ");

		List<Person> personlist = persondao.getAll();

		for (Person person : personlist) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {

				persondao.delete(person);
			}
		}

		return null;
	}


	
}
