package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.naturalpark.Weather;

@Component
public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//returns 5 weather objects for the selected park in a list
	@Override
	public List<Weather> getWeatherByParkId(String parkCode) {
		List<Weather> weather = new ArrayList<Weather>();
		String sqlSelectWeatherByParkId = "SELECT parkcode, fivedayforecastvalue, low, high, forecast " + 
				"FROM weather " + 
				"WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByParkId, parkCode);
		while (results.next()) {
			weather.add(mapRowToWeather(results));
		}
		return weather;
	}

	//this takes sql results and maps them to new weather objects
	private Weather mapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		weather.setParkCode(row.getString("parkcode"));
		weather.setDay(getDayString(row.getInt("fivedayforecastvalue")));
		weather.setLowTemp(row.getInt("low"));
		weather.setHighTemp(row.getInt("high"));
		weather.setLowTempC(celciusConverter(row.getInt("low")));
		weather.setHighTempC(celciusConverter(row.getInt("high")));
		weather.setForecast(row.getString("forecast").toUpperCase());
		weather.setAdvisory(advisory(row.getString("forecast"), row.getInt("low"),row.getInt("high")));
		weather.setImgWeatherName(correctedImgWeatherName(row.getString("forecast")));
		
		return weather;
	}
	
	//calculation to add celcius to our weather objects
	private Integer celciusConverter(int temp) {
		Double celciusTemp = (double) ((temp-32) * 0.5555555555555555555);
		
		Integer celciusTempInt =  celciusTemp.intValue();
		
		return celciusTempInt;
	}
	
	//this method maps day names to replace the numbers in the sql results
	private String getDayString(Integer day) {
		String answer = ""; 
		switch(day) {
		case 1: 
			answer = "Monday";
			break;
		case 2:
			answer = "Tuesday";
			break;
		case 3: 
			answer = "Wednesday";
			break;
		case 4: 
			answer = "Thursday";
			break;
		case 5: 
			answer = "Friday";
			break;
		}
			
		return answer;
	}
	
	//this method returns a clear sentence for the advisory message (public to allow testing)
	public String advisory(String forecast, Integer lowTemp, Integer highTemp) {
		String advisoryMessage = "";
		Integer lowHighTempRange = highTemp - lowTemp;
		
		if(forecast.contains("snow")) {
			advisoryMessage = "Pack snowshoes.";
		} else if(forecast.contains("rain")) {
			advisoryMessage = "Pack rain gear and wear waterproof shoes.";
		} else if(forecast.contains("thunderstorms")) {
			advisoryMessage = "Seek shelter and avoid hiking on exposed ridges.";
		} else if(forecast.contains("sunny")) {
			advisoryMessage = "Pack sunblock.";
		} 
		
		if(highTemp > 75) {
			advisoryMessage += " Bring an extra gallon of water.";
		} else if(lowTemp < 20) {
			advisoryMessage += " Please be aware of exposure to frigid temperatures.";
		}
		
		if(lowHighTempRange > 20) {
			advisoryMessage += " Wear breathable layers.";
		}
		
		return advisoryMessage;
	}
	
	//this method makes sure our sql results line up with the image naming convention
	private String correctedImgWeatherName(String imgWeatherName) {
		String correctedWeatherName = imgWeatherName.toLowerCase();
		if(imgWeatherName.equals("partly cloudy")) {
			correctedWeatherName = "partlyCloudy";
		}

		return correctedWeatherName;
	}
}
