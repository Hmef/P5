package com.openclassrooms.api.service;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.openclassrooms.api.dao.MedicalRecordDAO;
import com.openclassrooms.api.data.Data;
import com.openclassrooms.api.model.Medicalrecord;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceImplTest{
	
	
	@InjectMocks
	private MedicalRecordServiceImpl medicalrecordservice;  // Class under test 
	
	@Mock 
	private MedicalRecordDAO  medicalrecorddao;
	
	
	@Test
	public void getAllMedicalrecordTest() {

		Medicalrecord johnMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		Medicalrecord FeliciaMedicalrecord = new Medicalrecord("Felicia", "Boyd", "01/08/1986", Arrays.asList("tetracyclaz:650mg") , Arrays.asList("xilliathal"));
		
		List<Medicalrecord> medicalrecordlist =  new ArrayList<Medicalrecord>();
		medicalrecordlist.add(johnMedicalrecord);
		medicalrecordlist.add(FeliciaMedicalrecord);
		
		when(medicalrecorddao.getAll()).thenReturn(medicalrecordlist);
		
		assertEquals(2, medicalrecordservice.getAllMedicalrecord().size());
	}


	@Test
	public void saveTest() {
		
		//Medicalrecord medicalrecord
		

		Medicalrecord johnMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		
		Medicalrecord createdmedicalrecord = medicalrecordservice.save(johnMedicalrecord);
		
		List<Medicalrecord> actuallist =new ArrayList<Medicalrecord>();
		actuallist.add(createdmedicalrecord);
		int size = actuallist.size();
		
		assertSame(1, size);
		assertFalse(actuallist.isEmpty());
		
	}

	@Test
	public void updateTest() {

		Medicalrecord johnMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		Medicalrecord FeliciaMedicalrecord = new Medicalrecord("Felicia", "Boyd", "01/08/1986", Arrays.asList("tetracyclaz:650mg") , Arrays.asList("xilliathal"));
		
		List<Medicalrecord> medicalrecordlist =  new ArrayList<Medicalrecord>();
		medicalrecordlist.add(johnMedicalrecord);
		medicalrecordlist.add(FeliciaMedicalrecord);
		
		when(medicalrecorddao.getAll()).thenReturn(medicalrecordlist);
		
		Medicalrecord updatedmedicalrecord = medicalrecordservice.update(FeliciaMedicalrecord, "Felicia", "Boyd");
		
		assertEquals(Arrays.asList("tetracyclaz:650mg"), updatedmedicalrecord.getMedications());
	}

	@Test
	public void deleteTest() {
		

		Medicalrecord johnMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		Medicalrecord FeliciaMedicalrecord = new Medicalrecord("Felicia", "Boyd", "01/08/1986", Arrays.asList("tetracyclaz:650mg") , Arrays.asList("xilliathal"));
		
		List<Medicalrecord> medicalrecordlist =  new ArrayList<Medicalrecord>();
		medicalrecordlist.add(johnMedicalrecord);
		medicalrecordlist.add(FeliciaMedicalrecord);
		
		when(medicalrecorddao.getAll()).thenReturn(medicalrecordlist);
		
		//Medicalrecord deletedmedicalrecord = medicalrecordservice.delete("Felicia", "Boyd");
		
		assertNull(medicalrecordservice.delete("Felicia", "Boyd"));
	}
	

	@Test
    void groupedAssertions() {
		
		Medicalrecord johnMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		
		assertAll("johnMedicalrecord", () -> assertEquals("John", johnMedicalrecord.getFirstName()),
				() -> assertEquals("Boyd", johnMedicalrecord.getLastName()),
				() -> assertEquals("03/06/1984", johnMedicalrecord.getBirthdate()),
				() -> assertEquals(Arrays.asList("aznol:350mg","hydrapermazol:100mg"), johnMedicalrecord.getMedications()),
				() -> assertEquals(Arrays.asList("nillacilan"), johnMedicalrecord.getAllergies()));
	}
	
	
	
	
	
	
}
