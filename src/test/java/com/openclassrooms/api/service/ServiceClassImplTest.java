package com.openclassrooms.api.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.api.dao.FirestationDAO;
import com.openclassrooms.api.dao.MedicalRecordDAO;
import com.openclassrooms.api.dao.PersonDAO;
import com.openclassrooms.api.dto.ChildAlertDTO;
import com.openclassrooms.api.dto.CountDTO;
import com.openclassrooms.api.dto.FireDTO;
import com.openclassrooms.api.dto.PersonAlertDTO;
import com.openclassrooms.api.dto.PersonCountDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordDTO;
import com.openclassrooms.api.dto.PersonMedicalRecordFireDTO;
import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ServiceClassImplTest {

	private Logger logger  = LoggerFactory.getLogger(ServiceClassImplTest.class);
	
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
	
	@Mock 
	private FirestationDAO firestationdao;
	
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
	public void getPersonInfoTest_SouldReturnListOfPersonMedicalRecordInfo_ShouldHaveSameName() throws ParseException {

		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person Felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544", "jaboyd@email.com");
		
		Medicalrecord johnMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		Medicalrecord FeliciaMedicalrecord = new Medicalrecord("Felicia", "Boyd", "01/08/1986", Arrays.asList("tetracyclaz:650mg") , Arrays.asList("xilliathal"));

		ArrayList<Person> personlist = new ArrayList<Person>();
		personlist.add(john);
		personlist.add(Felicia);
		
		ArrayList<Medicalrecord> medicalrecordlist = new ArrayList<Medicalrecord>();
		medicalrecordlist.add(johnMedicalrecord);
		medicalrecordlist.add(FeliciaMedicalrecord);
		
		when(persondao.getAll()).thenReturn(personlist);
		when(medicalrecordDao.getAll()).thenReturn(medicalrecordlist);
	
		PersonMedicalRecordDTO johninfo = new PersonMedicalRecordDTO("John"+" "+"Boyd", "1509 Culver St", 38, "jaboyd@email.com", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		PersonMedicalRecordDTO Feliciainfo = new PersonMedicalRecordDTO("Felicia"+" "+"Boyd", "1509 Culver St", 36, "jaboyd@email.com", Arrays.asList("tetracyclaz:650mg") , Arrays.asList("xilliathal"));
		
		List<PersonMedicalRecordDTO> expectedPersoninfolist = new ArrayList<PersonMedicalRecordDTO>();
		
		expectedPersoninfolist.add(johninfo);
		expectedPersoninfolist.add(Feliciainfo);
		
		List<PersonMedicalRecordDTO> actualPersoninfolist = service.getPersonInfo("Felicia", "Boyd");
		
		//assertTrue(service.getPersonInfo("Felicia", "Boyd").contains(Feliciainfo)); 
		assertEquals(expectedPersoninfolist.get(1).getName(), actualPersoninfolist.get(1).getName());
		assertTrue(actualPersoninfolist.size() > 0);
		assertNotNull(service.getPersonInfo("Felicia", "Boyd"));
		
		
		
	}
	
	@Test
	public void getChildByAddressTest_ShouldReturnListOfChildrenAndFamilyMember() throws ParseException {
		
		Person Sophia = new Person("Sophia", "Zemicks", "892 Downing Ct", "Culver", "97451", "841-874-7878", "soph@email.com");
		Person Warren = new Person("Warren", "Zemicks", "892 Downing Ct", "Culver", "97451", "841-874-7512", "ward@email.com");
		
		Person ZachChild = new Person("Zach", "Zemicks",  "892 Downing Ct", "Culver", "97451", "841-874-7512", "zarc@email.com");
	
		Medicalrecord SophiaMedicalrecord = new Medicalrecord("Sophia", "Zemicks", "03/06/1988", Arrays.asList("aznol:60mg","hydrapermazol:900mg","pharmacol:5000mg","terazine:500mg") , Arrays.asList("peanut","shellfish","aznol"));
		Medicalrecord WarrenMedicalrecord = new Medicalrecord("Warren", "Zemicks", "03/06/1985", Arrays.asList("") , Arrays.asList(""));
		Medicalrecord ZachChildMedicalrecord = new Medicalrecord("Zach", "Zemicks", "03/06/2017", Arrays.asList(""), Arrays.asList("")); 
		
		ArrayList<Person> personlist = new ArrayList<Person>();
		personlist.add(Sophia);
		personlist.add(Warren);
		personlist.add(ZachChild);
		
		ArrayList<Medicalrecord> medicalrecordlist = new ArrayList<Medicalrecord>();
		medicalrecordlist.add(SophiaMedicalrecord);
		medicalrecordlist.add(WarrenMedicalrecord);
		medicalrecordlist.add(ZachChildMedicalrecord);

		when(persondao.getAll()).thenReturn(personlist);
		when(medicalrecordDao.getAll()).thenReturn(medicalrecordlist);

		//int sophiaAge = service.calculteAge(SophiaMedicalrecord.getBirthdate());
		int sophiaAge = 34;
		PersonAlertDTO memberAlert = new PersonAlertDTO();
		memberAlert.setFirstname(Sophia.getFirstName());
		memberAlert.setLastname(Sophia.getLastName());
		memberAlert.setAge(sophiaAge);
		
		
		//int warrenAge = service.calculteAge(WarrenMedicalrecord.getBirthdate());
		int warrenAge = 37;
		PersonAlertDTO secondMemberAlert = new PersonAlertDTO("Warren", "Zemicks", warrenAge);
		
		List<PersonAlertDTO> memberAlertList = new ArrayList<PersonAlertDTO>();
		memberAlertList.add(memberAlert);
		memberAlertList.add(secondMemberAlert);
		
		//ChildAlertDTO childAlert = new ChildAlertDTO("Zach", "Zemicks", 5, memberAlertList);
		
		ChildAlertDTO childAlert = new ChildAlertDTO();
		childAlert.setFirstname(ZachChild.getFirstName());
		childAlert.setLastname(ZachChild.getLastName());
		childAlert.setAge(5);
		childAlert.setPersonalert(memberAlertList);
		
		List<ChildAlertDTO> expectedChildAlertList = new ArrayList<ChildAlertDTO>();
		expectedChildAlertList.add(childAlert);
		
		String address = "892 Downing Ct"; 
		List<ChildAlertDTO> actualChildAlertList = service.getChildByAddress(address);
		int size = service.getChildByAddress(address).size();
		ChildAlertDTO childAlertt = service.getChildByAddress(address).get(0);
		
		assertNotNull(size);
		assertTrue(childAlertt.getAge() == 5);
		assertSame(expectedChildAlertList.get(0).getFirstname(), actualChildAlertList.get(0).getFirstname());
		
	}



	@Test
	public void GetListHomeByCasern()  {
		
		// String firestationNum
		//List<FloodDTO>
		
	}


	@Test
	public void getFirestationByStation() {
		// Firestation
		//String station
		
	}


	@Test
	public void getPhoneListByCasern_ShouldReturnListOfResidentsPhoneByCasern() {
		
		Firestation firestation = new Firestation("1509 Culver St", "3");
		
		List<Firestation> firestationlist = new ArrayList<Firestation>();
		firestationlist.add(firestation);
		
		when(firestationdao.getAll()).thenReturn(firestationlist);
		
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person Felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544", "jaboyd@email.com");
		// add more persons for this address : "29 15th St"
		
		List<Person> residentlist = new ArrayList<Person>();
		residentlist.add(john);
		residentlist.add(Felicia);
		
		when(persondao.getAll()).thenReturn(residentlist);
		
		List<String> phoneListExpected = new ArrayList<>();
		phoneListExpected.add(residentlist.get(0).getPhone());
		phoneListExpected.add(residentlist.get(1).getPhone());
		
		String numberFirestation = "3";
		service.getPhoneListByCasern(numberFirestation);
		
		
		List<String> phoneListActual = service.getPhoneListByCasern(numberFirestation);
		
		assertFalse(phoneListActual.isEmpty());
		
		assertEquals(phoneListExpected, phoneListActual);
		

	}


	@Test
	public void getListPersonByAddressStation_ShouldReturnListOfResidentLiveInThisAddressAndFirestationNumber() throws ParseException {
	
		Firestation firestation = new Firestation("1509 Culver St", "3");
		
		List<Firestation> firestationlist = new ArrayList<Firestation>();
		firestationlist.add(firestation);
		
		when(firestationdao.getAll()).thenReturn(firestationlist);
		
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		Person Felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544", "jaboyd@email.com");
		
		Medicalrecord johnMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		Medicalrecord FeliciaMedicalrecord = new Medicalrecord("Felicia", "Boyd", "01/08/1986", Arrays.asList("tetracyclaz:650mg") , Arrays.asList("xilliathal"));

		ArrayList<Person> personlist = new ArrayList<Person>();
		personlist.add(john);
		personlist.add(Felicia);
		
		ArrayList<Medicalrecord> medicalrecordlist = new ArrayList<Medicalrecord>();
		medicalrecordlist.add(johnMedicalrecord);
		medicalrecordlist.add(FeliciaMedicalrecord);
		
		when(persondao.getAll()).thenReturn(personlist);
		when(medicalrecordDao.getAll()).thenReturn(medicalrecordlist);
		
		PersonMedicalRecordFireDTO pmrf = new PersonMedicalRecordFireDTO("John" +" "+ "Boyd", "841-874-6512", 38, Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		PersonMedicalRecordFireDTO pmrff = new PersonMedicalRecordFireDTO("Felicia" +" "+ "Boyd", "841-874-6544", 36, Arrays.asList("tetracyclaz:650mg"), Arrays.asList("xilliathal"));
		
		List<PersonMedicalRecordFireDTO> pmrfList = new ArrayList<PersonMedicalRecordFireDTO>(); 
		pmrfList.add(pmrf);
		pmrfList.add(pmrff);
		
		String firestationNumber = "3";
		
		FireDTO expectedFire = new FireDTO(firestationNumber, pmrfList);
		
		String address = "1509 Culver St";
		
		FireDTO actualFire = service.getListPersonByAddressStation(address);
		
		assertNotNull(actualFire);
		assertTrue(expectedFire.getFirestationNumber().equals(actualFire.getFirestationNumber()));
		
	}


	@Test
	public void getPersonByStationAddress() {
		
		// List<FirestationDTO>
		//String address
		
	}


	@Test
	public void getCountPersonBystation_ShouldReturnCountOfAdultAndChildNumberAndListOfPersonByStationNumber() throws ParseException {
		
		Firestation firestation = new Firestation("892 Downing Ct", "2");
		Firestation firestationn = new Firestation("951 LoneTree Rd", "2");
		
		List<Firestation> firestationlist = new ArrayList<Firestation>();
		firestationlist.add(firestation);
		firestationlist.add(firestationn);
		
		when(firestationdao.getAll()).thenReturn(firestationlist);
		
		Person Sophia = new Person("Sophia", "Zemicks", "892 Downing Ct", "Culver", "97451", "841-874-7878", "soph@email.com");
		Person Warren = new Person("Warren", "Zemicks", "892 Downing Ct", "Culver", "97451", "841-874-7512", "ward@email.com");
		Person Eric = new Person("Eric", "Cadigan", "951 LoneTree Rd", "Culver", "97451", "841-874-7458", "gramps@email.com");
	
		Person ZachChild = new Person("Zach", "Zemicks",  "892 Downing Ct", "Culver", "97451", "841-874-7512", "zarc@email.com");
	
		Medicalrecord SophiaMedicalrecord = new Medicalrecord("Sophia", "Zemicks", "03/06/1988", Arrays.asList("aznol:60mg","hydrapermazol:900mg","pharmacol:5000mg","terazine:500mg") , Arrays.asList("peanut","shellfish","aznol"));
		Medicalrecord WarrenMedicalrecord = new Medicalrecord("Warren", "Zemicks", "03/06/1985", Arrays.asList("") , Arrays.asList(""));
		Medicalrecord EricMedicalrecord = new Medicalrecord("Eric", "Cadigan", "08/06/1945", Arrays.asList("") , Arrays.asList(""));
		
		Medicalrecord ZachChildMedicalrecord = new Medicalrecord("Zach", "Zemicks", "03/06/2017", Arrays.asList("tradoxidine:400mg"), Arrays.asList("")); 
		
		ArrayList<Person> personlist = new ArrayList<Person>();
		personlist.add(Sophia);
		personlist.add(Warren);
		personlist.add(Eric);
		personlist.add(ZachChild);
		
		ArrayList<Medicalrecord> medicalrecordlist = new ArrayList<Medicalrecord>();
		medicalrecordlist.add(SophiaMedicalrecord);
		medicalrecordlist.add(WarrenMedicalrecord);
		medicalrecordlist.add(EricMedicalrecord);
		medicalrecordlist.add(ZachChildMedicalrecord);

		when(persondao.getAll()).thenReturn(personlist);
		when(medicalrecordDao.getAll()).thenReturn(medicalrecordlist);
		
		PersonCountDTO zachcountchild = new PersonCountDTO("Zach", "Zemicks", "841-874-7512", "892 Downing Ct", 5);
		PersonCountDTO sophiacount = new PersonCountDTO("Sophia", "Zemicks", "841-874-7878", "892 Downing Ct", 34);
		PersonCountDTO warrencount = new PersonCountDTO("Warren", "Zemicks", "841-874-7512", "892 Downing Ct", 37);
		PersonCountDTO ericcount = new PersonCountDTO("Eric", "Cadigan", "841-874-7458", "951 LoneTree Rd", 77);
		
		List<PersonCountDTO> childCountlist = new ArrayList<PersonCountDTO>();
		childCountlist.add(zachcountchild);
		
		List<PersonCountDTO> personCountlist = new ArrayList<PersonCountDTO>();
		personCountlist.add(sophiacount);
		personCountlist.add(warrencount);
		personCountlist.add(ericcount);

		int sizechild = childCountlist.size();
		int sizeperson = personCountlist.size();
		
		List<PersonCountDTO> personchildCountlist = new ArrayList<PersonCountDTO>();
		personchildCountlist.addAll(childCountlist);
		personchildCountlist.addAll(personCountlist);

		CountDTO expectedCount = new CountDTO(sizechild, sizeperson, personchildCountlist);
		
		String stationNumber =  "2";
		
		CountDTO actualCount = service.getCountPersonBystation(stationNumber);
		
		int actualPersonCount = actualCount.getSizeperson();  // 3 adults 
		int actualChildCount = actualCount.getSizechild(); // 1 child
		
		int actualPersonAge = actualCount.getPersonList().get(3).getAge();  // 77 ans 
		int actualChildAge = actualCount.getPersonList().get(0).getAge();  // 5 ans 
	
		assertSame(77, actualPersonAge);
		assertEquals(1 , actualChildCount);
		assertEquals(3, actualPersonCount);
		assertTrue(actualPersonAge > 18);
		assertTrue(actualChildAge < 18);
	}


	
	
}
