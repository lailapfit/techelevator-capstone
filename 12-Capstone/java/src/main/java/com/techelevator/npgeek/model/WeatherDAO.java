package com.techelevator.npgeek.model;

import com.techelevator.naturalpark.Weather;

public interface WeatherDAO {

	
	//returns 5 weather objects for the selected park
	public Weather getWeatherByParkId();
	
	
	
}
