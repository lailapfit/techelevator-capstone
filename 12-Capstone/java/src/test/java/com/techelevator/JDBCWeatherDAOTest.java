package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.naturalpark.Weather;
import com.techelevator.npgeek.model.JDBCWeatherDAO;

public class JDBCWeatherDAOTest extends DAOIntegrationTest {

	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
	private JDBCWeatherDAO dao = new JDBCWeatherDAO(this.getDataSource());

	@Before
	public void setUp() throws Exception {
		
		String sqlInsertTest = "INSERT INTO weather " + 
				"(parkcode, fivedayforecastvalue, low, high, forecast) " + 
				"VALUES ('CVNP', '6', '20', '80', 'sunny')";
		jdbcTemplate.update(sqlInsertTest);
	}
	
	 

	@Test
	public void testGetWeatherByParkId() {
		List<Weather> weather = dao.getWeatherByParkId("CVNP");
		Integer weatherListSize = weather.size();
		Integer lowTempTest = 20;
		Integer highTempTest = 80;
		String forecastTest = "sunny";
		
		assertEquals(6, weather.size());
		assertEquals(lowTempTest, weather.get(weatherListSize - 1).getLowTemp());
		assertEquals(highTempTest, weather.get(weatherListSize - 1).getHighTemp());
		assertEquals(forecastTest, weather.get(weatherListSize - 1).getForecast());
	
	}
	
	@Test
	public void advisoryTest() {
		String forecast = "sunny";
		Integer lowTemp = 20;
		Integer highTemp = 80;
		
		String result = "Pack sunblock. Also bring an extra gallon of water. Also wear breathable layers.";
		String advisoryTest = dao.advisory(forecast, lowTemp, highTemp);
		
		assertEquals(result, advisoryTest);
		
	}

}
