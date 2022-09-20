package com.openclassrooms.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.api.ObjectMapper.MapperService;

@SpringBootApplication
public class ApiApplication {

	private static final Logger logger = LogManager.getLogger("ApiApplication");
	
	
	public static void main(String[] args) {
		
SpringApplication.run(ApiApplication.class, args);
		
		logger.info(" API Application ");
		
		  MapperService mapper = new MapperService();
			
		  mapper.readObjectFromJsonFile();
		  
	}

}
