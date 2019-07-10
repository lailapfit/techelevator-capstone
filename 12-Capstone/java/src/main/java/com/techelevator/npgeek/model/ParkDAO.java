package com.techelevator.npgeek.model;

import java.util.List;
import java.util.Map;

import com.techelevator.naturalpark.Park;

public interface ParkDAO {

	//returns a list containing park objects for every park in the DB
	public List<Park> getAllParks();
	
	//returns information for the specific park selected
	public Park getParkbyId();
	
	
	
}
