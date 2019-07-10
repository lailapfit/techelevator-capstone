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
		
//		String sqlInsertTest = "INSERT INTO park " + 
//				"(parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + 
//				"VALUES " + 
//				"('TEST', 'TestPark', 'Ohio', 999, 555, 1234, 22, 'Tropical', 2019, 9000, 'Being in this park is like being in heaven', 'TuPac', 'This park is the bombdiggity', 42, 333)";
//		jdbcTemplate.update(sqlInsertTest);
	}
	
	 

	@Test
	public void testGetWeatherByParkId() {
		List<Weather> weather = dao.getWeatherByParkId("CVNP");
		Integer size = 5;

		assertEquals(5, weather.size());
		
		
	}

}
