package com.openclassrooms.api.ObjectMapper;

import java.io.File;
import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.api.repository.Data;


@Configuration
public class MapperService {

	public void readObjectFromJsonFile() {

		ObjectMapper mapper = new ObjectMapper();

		try {

			Data data = mapper.readValue(new File("src/main/resources/dataa.json"), Data.class);

		} catch (StreamReadException e) {

			System.out.println(" StreamRead Exception ! ");

			e.printStackTrace();
		} catch (DatabindException e) {

			System.out.println(" Databind Exception ! ");

			e.printStackTrace();
		} catch (IOException e) {

			System.out.println(" IO Exception ! ");

			e.printStackTrace();
		}

	}
	
	
	/*
	public void WriteJavaObjectInJsonObject(Data data) {
		
		
		ObjectMapper objectmapper = new ObjectMapper();
		
		
			
		 try {
			 
			objectmapper.writeValue(new File("src/main/resources/test.json"), Data.class);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	*/

}
