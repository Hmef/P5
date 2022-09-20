package com.openclassrooms.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;


public interface DAO <T>{  
	 
	List<T> getAll();
	
	T save(T object);
	
	T update(T object);
	
	void delete(T object);
	

}
