package com.techelevator.npgeek.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.naturalpark.Weather;

@Component
public interface WeatherDAO {

	
	//returns 5 weather objects for the selected park
	public List<Weather> getWeatherByParkId(String parkCode);
	
	
	
}
