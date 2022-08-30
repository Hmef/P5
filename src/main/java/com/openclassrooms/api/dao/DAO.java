package com.openclassrooms.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;


public interface DAO <T>{  // Generic Class 
	
	
	// the DAO interface defines an abstract API that performs CRUD Operation on object of type T  
	
	// Optional<T> get(long id);  
	
	List<T> getAll();
	
	void save(T object);
	
	void delete(T object);

	void update(T object);
	
	
	//Optional<T> get(String param);
	
	//T getByT(String param); 
	
	//Person getNameWithSorting(String field);

	//void update(Person person, String[] params);
	
	
	


}
