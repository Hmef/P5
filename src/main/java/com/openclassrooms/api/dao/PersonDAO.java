package com.openclassrooms.api.dao;


import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.api.model.Person;
import com.openclassrooms.api.repository.Data;

@Service
public class PersonDAO implements DAO<Person>{

	

	@Override
	public List<Person> getAll() {
		
		return Data.getPersons();
	}

	@Override
	public void save(Person person) {
		
		Data.getPersons().add(person);

	}


	@Override
	public void update(Person person) {

		Data.getPersons().add(person);

		
	}

	@Override
	public void delete(Person person) {
		
		Data.getPersons().remove(person);
		
	}

	
}
