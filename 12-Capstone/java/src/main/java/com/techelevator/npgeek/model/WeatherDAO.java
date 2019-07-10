package com.techelevator.npgeek.model;

import java.util.List;

import com.techelevator.naturalpark.Weather;

public interface WeatherDAO {

	
	//returns 5 weather objects for the selected park
	public List<Weather> getWeatherByParkId(String parkCode);
	
	
	
}
