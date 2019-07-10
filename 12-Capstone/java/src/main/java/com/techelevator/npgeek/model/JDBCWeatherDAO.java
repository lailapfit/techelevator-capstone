package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.naturalpark.Weather;

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
		weather.setDay(row.getInt("fivedayforecastvalue"));
		weather.setLowTemp(row.getInt("low"));
		weather.setHighTemp(row.getInt("high"));
		weather.setForecast(row.getString("forecast"));
		//weather.setAdvisory("logic goes here");
		
		return weather;
	}
	//do we need to set this? 
//	private String imgWeatherName;
	
}
