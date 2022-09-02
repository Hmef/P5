package com.openclassrooms.api.controller;


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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.api.model.Person;
import com.openclassrooms.api.service.PersonService;
import com.openclassrooms.api.service.ServiceClass;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personservice;
	
	@MockBean
	private ServiceClass service;

	
	
	@Test
	public void getAllPersonsTest_shouldReturnOk() throws Exception {

		when(personservice.getAll()).thenReturn(new ArrayList<>());
		mockMvc.perform(get("/persons")).andExpect(status().isOk());
	}

	
	@Test
	public void getCommunityEmail() throws Exception {
		
		when(service.getEmailByCity("Culver")).thenReturn(new ArrayList<>());
		mockMvc.perform(get("/communityEmail?city=Culver")).andExpect(status().isOk());
	}
	
	@Test
	public void getPersonInfoTest() throws Exception {
	
		when(service.getPersonInfo("John", "Boyd")).thenReturn(new ArrayList<>());
		mockMvc.perform(get("/personInfo?firstName=John&lastName=Boyd")).andExpect(status().isOk());
	}
	
	@Test
	public void getChildByAddressTest() throws Exception {
		
		when(service.getChildByAddress("1509 Culver St")).thenReturn(new ArrayList<>());
		mockMvc.perform(get("/childAlert?address=1509 Culver St")).andExpect(status().isOk());
	}
	
	// Response status expected <200> but was : <405>
	@Test
	public void createPersonTest_shouldReturnisCreated() throws Exception {
		
		Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		
		when(personservice.savePerson(any(Person.class))).thenReturn(person);

		String requestjson = "{ \"firstName\": \"John\",\"lastName\":\"Boyd\",\"address\": \"1509 Culver St\", \"city\": \"Culver\", \"zip\":\"97451\", \"phone\": \"841-874-6512\", \"email\": \"jaboyd@email.com\"}";
		
		mockMvc.perform(post("/persons").contentType("application/json").content(requestjson)).andExpect(status().is(200));
	}

	@Test
	public void updatePersonTest_shouldReturnStatusReturn200() throws Exception {

		Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
		when(personservice.updatePerson(any(Person.class), any(), any())).thenReturn(person);
		String requestjson = "{ \"firstName\": \"John\",\"lastName\":\"Boyd\",\"address\": \"1509 Culver St\", \"city\": \"Culver\", \"zip\":\"97451\", \"phone\": \"841-874-6512\", \"email\": \"jaboyd@email.com\"}";
		
		mockMvc.perform(put("/persons/firstName=John&lastName=Boyd").contentType("application/json").content(requestjson)).andExpect(status().is(200));

	}

	@Test
	public void deletePersonTest_ShouldReturnStatusReturnNoContent() throws Exception {

		when(personservice.deletePerson("Boyd", "John")).thenReturn(null);
		mockMvc.perform(delete("/persons/firstName=John&lastName=Boyd")).andExpect(status().isNoContent());
	}
	
	


}
