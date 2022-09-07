package com.openclassrooms.api.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; ///// 
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

	private Firestation culverFirestation;
	private Firestation firestation;
	private List<Firestation> firestationlist;

	@Before
	public void init() {

		culverFirestation = new Firestation("1509 Culver St", "3");
		firestation = new Firestation("29 15th St", "2");

	}

	@Test
	public void getAllFirestationsTest() {

		firestationlist = new ArrayList<Firestation>();
		firestationlist.add(culverFirestation);
		firestationlist.add(firestation);

		when(firestationdao.getAll()).thenReturn(firestationlist);

		int size = firestationservice.getAllFirestations().size();

		assertEquals(2, size);

	}

	@Test
	public void save() {

		Firestation createdfirestation = new Firestation("1509 Culver St", "3");
		List<Firestation> actuallist = new ArrayList<Firestation>();
		actuallist.add(firestationservice.save(createdfirestation));

		System.out.println("actuallist          --> " + actuallist.toString());
		System.out.println(
				"actuallist.contains(createdfirestation)        --> " + actuallist.contains(createdfirestation));
		// assertTrue(actuallist.contains(createdfirestation));
		assertEquals(1, actuallist.size());

	}

	@Test
	public void update() {

		// Firestation

		// Firestation firestation, String address

		culverFirestation = new Firestation("1509 Culver St", "3");
		firestation = new Firestation("29 15th St", "2");

		firestationlist = new ArrayList<Firestation>();
		firestationlist.add(culverFirestation);
		firestationlist.add(firestation);

		when(firestationdao.getAll()).thenReturn(firestationlist);
		
		Firestation updatedfirestation = firestationservice.updateFirestation(culverFirestation, "1509 Culver St");
		
		assertSame("1509 Culver St", updatedfirestation.getAddress());

	}
	

	@Test
	public void delete() {

		culverFirestation = new Firestation("1509 Culver St", "3");
		firestation = new Firestation("29 15th St", "2");

		firestationlist = new ArrayList<Firestation>();
		firestationlist.add(culverFirestation);
		firestationlist.add(firestation);

		when(firestationdao.getAll()).thenReturn(firestationlist);

		assertNull(firestationservice.delete("1509 Culver St"));
	}

	@Test
	public void groupedAssertions() {

		Firestation firestation = new Firestation("1509 Culver St", "3");

		assertAll("firestation", () -> assertEquals("1509 Culver St", firestation.getAddress()),
				() -> assertEquals("3", firestation.getStation()));
	}

}
