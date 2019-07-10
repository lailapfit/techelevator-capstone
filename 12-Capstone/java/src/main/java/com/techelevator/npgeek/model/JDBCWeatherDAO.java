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


	private Weather mapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		weather.setParkCode(row.getString("parkcode"));
		weather.setDay(getDayString(row.getInt("fivedayforecastvalue")));
		weather.setLowTemp(row.getInt("low"));
		weather.setHighTemp(row.getInt("high"));
		weather.setForecast(row.getString("forecast"));
		weather.setAdvisory(advisory(row.getString("forecast"), row.getInt("low"),row.getInt("high")));
		weather.setImgWeatherName(correctedImgWeatherName(row.getString("forecast")));
		
		return weather;
	}
	
	public String getDayString(Integer day) {
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
			advisoryMessage += " Also bring an extra gallon of water.";
		} else if(lowTemp < 20) {
			advisoryMessage += " Also please be aware of exposure to frigid temperatures.";
		}
		
		if(lowHighTempRange > 20) {
			advisoryMessage += " Also wear breathable layers.";
		}
		
		return advisoryMessage;
	}
	
	private String correctedImgWeatherName(String imgWeatherName) {
		String correctedWeatherName = imgWeatherName.toLowerCase();
		if(imgWeatherName.equals("partly cloudy")) {
			correctedWeatherName = "partlyCloudy";
		}

		return correctedWeatherName;
	}
}
