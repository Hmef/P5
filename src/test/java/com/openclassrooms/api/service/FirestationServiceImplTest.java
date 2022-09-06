package com.openclassrooms.api.service;

import org.junit.jupiter.api.Test; ///// 

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.openclassrooms.api.dao.FirestationDAO;
import com.openclassrooms.api.model.Firestation;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class FirestationServiceImplTest {

	@InjectMocks
	private FirestationServiceImpl firestationservice;
	
	@Mock
	private FirestationDAO firestationdao;
	
	@Test
	public void getAllFirestationsTest() {


		Firestation firestation = new Firestation("1509 Culver St", "3");
		Firestation firestation2 = new Firestation("29 15th St", "2");
		
		List<Firestation> firestationlist = new ArrayList<Firestation>();
		firestationlist.add(firestation);
		firestationlist.add(firestation2);
		
		when(firestationdao.getAll()).thenReturn(firestationlist);
		
		int size = firestationservice.getAllFirestations().size();
		
		assertEquals(2, size);
		
	}

	@Test
	public void getFirestationTest() {
		// String adress

	}

	@Test
	public void getFirestationByStationTest() {

		Firestation firestation = new Firestation("1509 Culver St", "3");
		Firestation firestation2 = new Firestation("29 15th St", "2");

		
	}

	@Test
	public void updateTest() {

	}

	@Test
	public void saveTest() {

		
	}

	@Test
	public void deleteTest() {

	}

	@Test
	public void groupedAssertions() {

		Firestation firestation = new Firestation("1509 Culver St", "3");

		assertAll("firestation", () -> assertEquals("1509 Culver St", firestation.getAddress()),
				() -> assertEquals("3", firestation.getStation()));
	}

}
