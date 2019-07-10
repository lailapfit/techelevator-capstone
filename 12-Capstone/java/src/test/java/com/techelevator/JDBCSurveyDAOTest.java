package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.naturalpark.Park;
import com.techelevator.naturalpark.Survey;
import com.techelevator.npgeek.model.JDBCSurveyDAO;



public class JDBCSurveyDAOTest extends DAOIntegrationTest {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
	private JDBCSurveyDAO dao = new JDBCSurveyDAO(this.getDataSource());



	@Before
	public void setUp() throws Exception {
		
		String sqlInsertTest = "INSERT INTO survey_result " + 
				"(parkcode, emailaddress, state, activitylevel) " + 
				"VALUES " + 
				"('ENP', 'hienp@test.com', 'Florida', 'active')";
		
				
	jdbcTemplate.update(sqlInsertTest);
	}

	@Test
	public void testGetAllVotes() {
		Map<String, Integer> allVotes = dao.getParkVotes();
		Integer size = 2;

		assertEquals(size, allVotes.get("Cuyahoga Valley National Park"));
		assertEquals(2, allVotes.size());
		
	}

}
