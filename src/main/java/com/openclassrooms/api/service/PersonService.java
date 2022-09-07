package com.openclassrooms.api.service;

import java.util.List;

import com.openclassrooms.api.model.Person;

public interface PersonService {

	List<Person> getAll();

	Person updatePerson(Person person, String firstName, String lastName);

	Person savePerson(Person person);

	Person deletePerson(String firstName, String lastName);

}
