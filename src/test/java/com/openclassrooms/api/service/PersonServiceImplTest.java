package com.openclassrooms.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.api.dao.PersonDAO;
import com.openclassrooms.api.model.Person;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {

	
	@InjectMocks 
	private PersonServiceImpl personservice;
	
	@Mock
	private PersonDAO personDao;
	
	@Mock
	private ServiceClass service;
	
	@BeforeEach
	private void setUpPerTest() {

		// Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451",
		// "841-874-6512", "jaboyd@email.com");

		// Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver",
		// "97451", "841-874-6512", "jaboyd@email.com");

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
		
		// Vérifier la couverture de cette méthode ( PersonServiceImpl.java )
		
		
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com");
		
		//when(john.getFirstName()).thenReturn("John");
		//when(john.getLastName()).thenReturn("Boyd");
		
		List<Person> personlist = new ArrayList<Person>();
		personlist.add(john);
		
		when(personDao.getAll()).thenReturn(personlist);
		
		List<Person> updatedpersonlistTest = new ArrayList<Person>(); 
		
		String firstName = john.getFirstName();
		String lastName = john.getLastName();
		
		String jacobfirstName = jacob.getFirstName();
		String jaconLastName =jacob.getLastName();
		
		when(firstName.equals(jacobfirstName)).thenReturn(true);
		
		updatedpersonlistTest.add(personservice.updatePerson(john, firstName, lastName));
		
		//assertNotNull(updatedpersonlistTest);
		assertTrue(updatedpersonlistTest.contains(john));
	
	}

	@Test
	public void savePersonTest() {

		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com");
		
		Person savedperson= new Person();
		savedperson.setFirstName(john.getFirstName());
		savedperson.setLastName(john.getLastName());
		savedperson.setAddress(john.getAddress());
		savedperson.setCity(john.getCity());
		savedperson.setZip(john.getZip());
		savedperson.setPhone(john.getPhone());
		savedperson.setEmail(john.getEmail());
		
		List<Person> personlist = new ArrayList<Person>();
		personlist.add(savedperson);
		
		List<Person> savedpersonlistTest = new ArrayList<Person>(); 
		savedpersonlistTest.add(personservice.savePerson(savedperson));
		
	
		System.out.println("savedperson   " + savedperson);
		
		System.out.println("personlist   " + personlist.toString());
		//assertNotNull(savedpersonlistTest);

		//assertTrue(savedpersonlistTest.contains(john));

		//assertNotSame(expected, actual)
		//assertNotSame(savedpersonlistTest, personlist);
		assertEquals(savedpersonlistTest, personlist);
		
		
		
	}

	@Test
	public void deletePersonTest() {
		

		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com");
		
		List<Person> personlist = new ArrayList<Person>();
		personlist.add(john);
		personlist.add(jacob);
		
		List<Person> testlist = new ArrayList<Person>();
		personservice.deletePerson(john.getFirstName(), john.getLastName());
		
		assertNull(personservice.deletePerson(john.getFirstName(), john.getLastName()));
		
		
		//int size = testlist.size();
		//assertEquals(2, size);
		//assertNotEquals(1, size);
		
	}

	
	
}
