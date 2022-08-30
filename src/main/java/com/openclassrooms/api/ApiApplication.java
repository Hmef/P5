package com.openclassrooms.api;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.api.ObjectMapper.MapperService;
import com.openclassrooms.api.repository.Data;

@SpringBootApplication
public class ApiApplication {

	private static final Logger logger = LogManager.getLogger("ApiApplication");
	
	public static void main(String[] args) {
		
		SpringApplication.run(ApiApplication.class, args);
		
		logger.info(" API Application ");
		
		/*
		  ObjectMapper mapper = new ObjectMapper();
		
		try {

			//Data data = mapper.readValue(new File("src/main/resources/dataa.json"), Data.class);
			
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
		
		*/
		
		 
		  MapperService mapper = new MapperService();
			
		  mapper.readObjectFromJsonFile();
			
		 //mapper.WriteJavaObjectInJsonObject();

		
		// on doit ajouter directement le conenu de la méthode 
		// une fois qu'on exécute le projet, la lecture se fait automatiquement --> c'est ce qu'elle fait la méthode non ???
		// à avoir après 
	}

}
