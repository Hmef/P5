package com.openclassrooms.api.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.api.dao.PersonDAO;
import com.openclassrooms.api.model.Person;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {

	
	@InjectMocks 
	private PersonServiceImpl personservice;
	
	@Mock
	private PersonDAO personDao;  // Fake Object
	
	@BeforeEach
	private void setUpPerTest() {

		// Person jonanathan = new Person("Jonanathan", "Marrack", "29 15th St",
		// "Culver", "97451", "841-874-6513", "drk@email.com");;

	}

	@Test
	public void getAllTest(){

		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com");
		
		List<Person> allPerson = new ArrayList<Person>(); 
		allPerson.add(john);
		allPerson.add(jacob); 
		
		when(personDao.getAll()).thenReturn(allPerson);

		int size = personservice.getAll().size();
		assertEquals(2, size); 
	}

	
	@Test
	public void updatePerson() {
		
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");

		List<Person> personlist = new ArrayList<Person>();
		personlist.add(john);
		
		when(personDao.getAll()).thenReturn(personlist);
		
		Person updatedPerson = personservice.updatePerson(john, "John", "Boyd");
		
		//assertEquals("John", updatedPerson.getFirstName());   
		//assertEquals("Boyd", updatedPerson.getLastName());
		assertEquals("jaboyd@email.com", updatedPerson.getEmail());

	}

	@Test
	public void savePersonTest() {

		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		
		List<Person> savedpersonlist = new ArrayList<Person>(); 
		savedpersonlist.add(personservice.savePerson(john));
		int size = savedpersonlist.size();
		
		assertEquals(1, size);
	}

	@Test
	public void deletePersonTest() {
		

		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		
		assertNull(personservice.deletePerson(john.getFirstName(), john.getLastName()));
		
		
	}
		
	@Test
    public void groupedAssertions() {
		
		Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");

        assertAll("person", () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Boyd", person.getLastName()),
                () -> assertEquals("1509 Culver St", person.getAddress()),
                () -> assertEquals("Culver",person.getCity()),
                () -> assertEquals("97451", person.getZip()),
                () -> assertEquals("841-874-6512", person.getPhone()),
                () -> assertEquals("jaboyd@email.com", person.getEmail()));
        
    }
	
	
}
