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
	public Person savePerson(Person createdperson) {

		logger.info(" Saved Person ");

		Person newperson = new Person();

		newperson.setFirstName(createdperson.getFirstName());
		newperson.setLastName(createdperson.getLastName());
		newperson.setAddress(createdperson.getAddress());
		newperson.setCity(createdperson.getCity());
		newperson.setZip(createdperson.getZip());
		newperson.setEmail(createdperson.getEmail());
		newperson.setPhone(createdperson.getPhone());

		persondao.save(newperson);

		return newperson;

	}

	@Override
	public Person deletePerson(String firstName, String lastName) {

		logger.info(" Delete Person  ");

		List<Person> listperson = persondao.getAll();

		for (Person person : listperson) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {

				persondao.delete(person);
			}
		}

		return null;
	}

	@Override
	public Person updatePerson(Person updatedperson, String firstName, String lastName) {

		logger.info(" Update Person ");

		List<Person> personlist = persondao.getAll();

		for (Person person : personlist) {
			if (person.getFirstName().equals(updatedperson.getFirstName())
					&& person.getLastName().equals(updatedperson.getLastName())) {

				// person.setFirstName(firstName); // don't change firstName & lastName
				// person.setLastName(lastName);
				person.setAddress(updatedperson.getAddress());
				person.setCity(updatedperson.getCity());
				person.setZip(updatedperson.getZip());
				person.setEmail(updatedperson.getEmail());
				person.setPhone(updatedperson.getPhone());

				persondao.update(person);
				return person;
			}
		}
		return null;
	}

}
