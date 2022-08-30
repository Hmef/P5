package com.openclassrooms.api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.api.service.FirestationServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class FirestationControllerTest {
	
	
	@Mock 
	private FirestationServiceImpl firestationservice;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getFireStationsTest_shouldReturnOk() throws Exception {
		when(firestationservice.getAllFirestations()).thenReturn(new ArrayList<>());
		
		mockMvc.perform(get("/firestations")).andExpect(status().isOk());
	}
	

}
