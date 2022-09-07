package com.openclassrooms.api.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.api.model.Firestation;
import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;
import com.openclassrooms.api.service.FirestationService;
import com.openclassrooms.api.service.FirestationServiceImpl;
import com.openclassrooms.api.service.ServiceClass;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class FirestationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FirestationService firestationservice;
	
	@MockBean
	private ServiceClass service;
	
	@Test
	public void getFireStationsTest_shouldReturnOk() throws Exception {
		
		when(firestationservice.getAllFirestations()).thenReturn(new ArrayList<>());
		
		mockMvc.perform(get("/firestation")).andExpect(status().isOk());
	}
	
	@Test
	public void createFirestationTest() throws Exception {
		
		Firestation culverFirestation = new Firestation("1509 Culver St", "3");
		
		when(firestationservice.save(any())).thenReturn(culverFirestation);  
		
		String requestjson = "{ \"address\": \"1509 Culver St\", \"station\": \"3\" }";
		
		mockMvc.perform(post("/firestation").contentType("application/json").content(requestjson)).andExpect(status().is(200));
		
	}
	
	@Test 
	public void updateFirestationTest() throws Exception {
		
		Firestation culverFirestation = new Firestation("1509 Culver St", "3");
		
		when(firestationservice.updateFirestation(any(), any())).thenReturn(culverFirestation);
		
		String requestjson = "{ \"address\": \"1509 Culver St\", \"station\": \"3\" }";
		
		mockMvc.perform(put("/firestation/address=1509 Culver St").contentType("application/json").content(requestjson)).andExpect(status().is(200));
	}

	@Test
	public void deleteFirestationTest() throws Exception {
		
		when(firestationservice.delete("1509 Culver St")).thenReturn(null);
		
		mockMvc.perform(delete("/firestation/address=1509 Culver St")).andExpect(status().isNoContent());
		
	}
	
	
}
