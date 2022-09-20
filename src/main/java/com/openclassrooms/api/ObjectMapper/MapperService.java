package com.openclassrooms.api.ObjectMapper;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.api.data.Data;

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
	

}
