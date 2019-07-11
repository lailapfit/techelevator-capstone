package com.techelevator.npgeek.model;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

import com.techelevator.naturalpark.Survey;

@Component
public interface SurveyDAO {

	//returns a map containing parks and their associated vote count
	public LinkedHashMap<String, Integer> getParkVotes();
	
	//saves a new survey to the database from what the user inputted on the form page
	public void save(Survey survey);
	
}
