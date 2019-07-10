package com.techelevator.npgeek.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.naturalpark.Park;

@Component
public interface ParkDAO {

	//returns a list containing park objects for every park in the DB
	public List<Park> getAllParks();
	
	//returns information for the specific park selected
	public Park getParkById(String parkCode);
	
	
	
}
