package com.techelevator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.naturalpark.Park;
import com.techelevator.npgeek.model.JDBCParkDAO;

public class JDBCParkDAOTest extends DAOIntegrationTest {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
	private JDBCParkDAO dao = new JDBCParkDAO(this.getDataSource());

	@Before
	public void setUp() throws Exception {
		Park park = new Park();
		String sqlInsertTest = "INSERT INTO park " + 
				"(parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + 
				"VALUES " + 
				"('TEST', 'TestPark', 'Ohio', 999, 555, 1234, 22, 'Tropical', 2019, 9000, 'Being in this park is like being in heaven', 'TuPac', 'This park is the bombdiggity', 42, 333)";
		jdbcTemplate.update(sqlInsertTest);
	}

	@Test
	public void getAllParksTest() {
		List<Park> allParks = dao.getAllParks();
		Integer acre = 999;
		assertEquals(11, allParks.size());
		assertEquals("TestPark", allParks.get(10).getParkName());
		assertEquals("Ohio", allParks.get(10).getState());
		assertEquals(acre, allParks.get(10).getAcreage());

	}
	
	@Test
	public void getParkByIdTest() {
		Park park = dao.getParkById("TEST");
		Integer acre = 999;
		assertEquals("TestPark", park.getParkName());
		assertEquals("Ohio", park.getState());
		assertEquals(acre, park.getAcreage());
		
	}

}
