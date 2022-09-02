package com.openclassrooms.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test; /// 
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.api.dao.MedicalRecordDAO;
import com.openclassrooms.api.dao.PersonDAO;
import com.openclassrooms.api.dto.ChildAlertDTO;
import com.openclassrooms.api.dto.PersonAlertDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordDTO;
import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ServiceClassImplTest {

	private Logger logger  = org.slf4j.LoggerFactory.getLogger(ServiceClassImplTest.class);
	
	@InjectMocks
	private ServiceClassImpl service; // Class Under Test

	@Mock
	private ObjectMapper objectmapper;

	@Mock
	private PersonServiceImpl personservice;
	
	@Mock
	private MedicalRecordServiceImpl medicalrecordservice;
	
	@Mock
	private FirestationServiceImpl firestationservice;
	
	@Mock
	private PersonDAO persondao;
	
	//@Mock 
	//private FirestationDAO firestationdao;
	
	@Mock
	private MedicalRecordDAO medicalrecordDao;

	
	@Test
	public void getEmailByCityTest_SouldReturnListOfEmail() {
		
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com");
		
		List<Person> personlist = new ArrayList<Person>();
		personlist.add(john);
		personlist.add(jacob);
		
		when(persondao.getAll()).thenReturn(personlist);
		
		int actualSize = service.getEmailByCity("Culver").size();
		
		String jacobEmail = service.getEmailByCity("Culver").get(1);
		
		assertEquals(2, actualSize);
		assertEquals("drk@email.com", jacobEmail);
	
	}
	

	@Test
	public void getPersonInfoTest_SouldReturnListOfPersonMedicalRecordInfo_HaveSameName() throws ParseException {

		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person Felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544", "jaboyd@email.com");
		
		Medicalrecord johnMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		Medicalrecord FeliciaMedicalrecord = new Medicalrecord("Felicia", "Boyd", "01/08/1986", Arrays.asList("tetracyclaz:650mg") , Arrays.asList("xilliathal"));

		ArrayList<Person> listperson = new ArrayList<Person>();
		listperson.add(john);
		listperson.add(Felicia);
		
		ArrayList<Medicalrecord> listmedicalrecord = new ArrayList<Medicalrecord>();
		listmedicalrecord.add(johnMedicalrecord);
		listmedicalrecord.add(FeliciaMedicalrecord);
		
		when(persondao.getAll()).thenReturn(listperson);
		when(medicalrecordDao.getAll()).thenReturn(listmedicalrecord);
		
		//when(service.calculteAge(johnMedicalrecord.getBirthdate())).thenReturn(37);  // get exact age after execution 
		
		
		PersonMedicalRecordDTO johninfo = new PersonMedicalRecordDTO("John"+"Boyd", "1509 Culver St", 45, "jaboyd@email.com", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		PersonMedicalRecordDTO Feliciainfo = new PersonMedicalRecordDTO("Felicia"+"Boyd", "1509 Culver St", 45, "jaboyd@email.com", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		
		List<PersonMedicalRecordDTO> expectedlist = new ArrayList<PersonMedicalRecordDTO>();
		//expectedlist.add(johnMedicalrecordInfo);
		
		expectedlist.add(johninfo);
		expectedlist.add(Feliciainfo);
		
		String firstName = "John";
		String lastName = "Boyd";
		
		List<PersonMedicalRecordDTO> actuallist = service.getPersonInfo("Felicia", "Boyd");
		
		System.out.println("Get Person Info : " + service.getPersonInfo(firstName, lastName).toString());
		
		//verify()
		
		//System.out.println(test);

		//assertEquals(expectedlist, actuallist);
		//assertTrue(service.getPersonInfo(firstName, lastName).contains(personinfo));
		//assertNotNull(service.getPersonInfo(firstName, lastName));
		//assertThat(actuallist).size().isGreaterThan(0);
		
	}
	
	@Test
	public void getChildByAddressTest() throws ParseException {
	
		
	}
	
	@Test
	public void getChildByAddress() {
		
		
		ChildAlertDTO child = new ChildAlertDTO("Zach", "Zemicks", 5, null);
		
		PersonAlertDTO person = new PersonAlertDTO("Sophia", "Zemicks", 37);
		
		List<PersonAlertDTO> personlist = new ArrayList<PersonAlertDTO>();
		personlist.add(person);

		//String address
		//List<ChildAlertDTO>
	}

	
	
}
