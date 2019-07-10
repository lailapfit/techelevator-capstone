package com.techelevator.npgeek.model;

import java.util.Map;

import com.techelevator.naturalpark.Park;
import com.techelevator.naturalpark.Survey;

public interface SurveyDAO {

	//returns a map containing parks and their associated vote count
	public Map<String, Integer> getParkVotes();
	
	//saves a new survey to the database from what the user inputted on the form page
	public void save(Survey survey);
	
}
