package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.naturalpark.Park;
import com.techelevator.naturalpark.Survey;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//we still need to order alphabetically and limit results to 5
	@Override
	public Map<String, Integer> getParkVotes() {
		
		Map<String, Integer> surveyMap = new HashMap<>();
		
		String sqlSelectAllVotes = "SELECT park.parkname, COUNT (*) " + 
				"FROM survey_result " + 
				"JOIN park on park.parkcode = survey_result.parkcode " + 
				"GROUP BY park.parkname";
	
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllVotes);
		while (results.next()) {
			surveyMap.put(results.getString("parkname"), results.getInt("count"));
		}
		return surveyMap;
		}
		
		
	@Override
	public void save(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result "+
		        "(parkcode, emailaddress, state, activitylevel) "+
		        "VALUES "+
		                "(?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
		

	}

 

}
