package com.openclassrooms.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.api.model.Medicalrecord;


@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
public class MedicalRecordControllerTest {
	
	

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void getAllMedicalRecordTest() throws Exception {
		
		mockMvc.perform(get("/medicalrecord")).andExpect(status().isOk());
	}
	
	@Test
	public void createMedicalRecordTest() throws Exception {
		
		Medicalrecord medicalrecord = new Medicalrecord();
		medicalrecord.setFirstName("John");
		medicalrecord.setLastName("Boyd");
		medicalrecord.setBirthdate("03/06/1984");
		medicalrecord.setMedications(Arrays.asList("aznol:350mg","hydrapermazol:100mg"));
		medicalrecord.setAllergies(Arrays.asList("nillacilan"));
		
		List<Medicalrecord> medicalrecordlist = new ArrayList<Medicalrecord>();
		medicalrecordlist.add(medicalrecord);
		
		mockMvc.perform(get("/medicalrecord")).andExpect(status().isCreated());
	}
	
	@Test
	public void updateMedicarecordTest() {
		
		
	}
	
	@Test
	public void deleteMedicalrecordTest() {
		
	}

}
