package com.openclassrooms.api.ObjectMapper;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class MapperServiceTest {

	
	@InjectMocks
	private MapperService mapperservice;  // class under test 
	
	@Mock
	private ObjectMapper objectmapper;
	
	
	
	
	
}
