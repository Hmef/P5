package com.openclassrooms.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.api.model.Medicalrecord;
import com.openclassrooms.api.model.Person;
import com.openclassrooms.api.service.MedicalRecordService;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MedicalRecordControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MedicalRecordService medicalrecordservice;

	@Test
	public void getAllMedicalRecordTest_shouldReturnOk() throws Exception {

		when(medicalrecordservice.getAllMedicalrecord()).thenReturn(new ArrayList<>());
		mockMvc.perform(get("/medicalrecord")).andExpect(status().isOk());
	}

	@Test
	public void createMedicalRecordTest() throws Exception {

		Medicalrecord rogerMedicalrecord = new Medicalrecord("Roger", "Boyd", "09/06/2017", Arrays.asList(" "), Arrays.asList(" "));
		
		when(medicalrecordservice.save(any(Medicalrecord.class))).thenReturn(rogerMedicalrecord); 

		String requestjson = "{ \"firstName\": \"Roger\",\"lastName\":\"Boyd\",\"birthdate\": \"09/06/2017\", \"medications\":[], \"allergies\":[] \"}";

		//mockMvc.perform(post("/medicalrecord").contentType("application/json").content(requestjson)).andExpect(status().is(200));
		
	}

	@Test
	public void updateMedicarecordTest_shouldReturnStatus200() throws Exception {

		Medicalrecord rogerMedicalrecord = new Medicalrecord("Roger", "Boyd", "09/06/2017", Arrays.asList(" "), Arrays.asList(" "));
		
		when(medicalrecordservice.update(any(Medicalrecord.class), any(), any())).thenReturn(rogerMedicalrecord);  
		
		String requestjson = "{ \"firstName\": \"Roger\",\"lastName\":\"Boyd\",\"birthdate\": \"09/06/2017\", \"medications\":[], \"allergies\":[] \"}";

		//mockMvc.perform(put("/medicalrecord/firstName=Roger&lastName=Boyd").contentType("application/json").content(requestjson)).andExpect(status().is(200));

	}

	@Test
	public void deleteMedicalrecordTest() throws Exception {

		when(medicalrecordservice.delete("Roger", "Boyd")).thenReturn(null);
		mockMvc.perform(delete("/medicalrecord/firstName=Roger&lastName=Boyd")).andExpect(status().isNoContent());
	
	}

}
