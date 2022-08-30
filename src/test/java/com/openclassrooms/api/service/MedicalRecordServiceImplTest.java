package com.openclassrooms.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.repository.Data;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceImplTest{
	
	
	@InjectMocks
	private MedicalRecordServiceImpl medicalrecordservice;  // Class under test 
	
	
	@BeforeEach
	public void setUpPerTest() {
		
		//Medicalrecord johnsMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		
		//List<Medicalrecord> medicalrecordlist =  new ArrayList<Medicalrecord>();
		
		//medicalrecordlist.add(johnsMedicalrecord);
		
		//when(data.getMedicalrecords()).thenReturn(medicalrecordlist);
		
		
	}
	
	@Test
	public void getAllMedicalrecordTest() {
		
		
		Medicalrecord johnsMedicalrecord = new Medicalrecord("John", "Boyd", "03/06/1984", Arrays.asList("aznol:350mg","hydrapermazol:100mg") , Arrays.asList("nillacilan"));
		
		List<Medicalrecord> medicalrecordlist =  new ArrayList<Medicalrecord>();
		
		medicalrecordlist.add(johnsMedicalrecord);
		
		//List<Medicalrecord> expectedMedicalrecordList = medicalrecordlist;
		
		//List<Medicalrecord> resultMedicalrecordlist = medicalrecordservice.getAllMedicalrecord();
		
		List<Medicalrecord> resultMedicalrecordlist = medicalrecordservice.getAllMedicalrecord();
		

		System.out.println(" List MedicalRecords : " + resultMedicalrecordlist.toString());

		//when(resultMedicalrecordlist.size()).thenReturn(23);
		

		
		int resultSize = medicalrecordservice.getAllMedicalrecord().size();
		
		int expectedSize = 1;     // int expectedSize = 23;
		
		System.out.println("result size : " + resultSize);
		
		
		assertEquals(expectedSize, resultSize);
	}
	
	
	
	
	@Test 
	public void save() {
		
	}

	
	
	public Medicalrecord getByName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void saveTest(Medicalrecord medicalrecord) {
		// TODO Auto-generated method stub
		
	}

	
	public void updateTest(Medicalrecord medicalrecord) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteTest(Medicalrecord medicalrecord) {
		// TODO Auto-generated method stub
		
	}

	
	public void updatePTest(Medicalrecord object, String firstname, String lastname) {
		// TODO Auto-generated method stub
		
	}
	
}
