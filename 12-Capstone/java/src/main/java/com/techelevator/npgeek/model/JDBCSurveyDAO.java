package com.techelevator.npgeek.model;

import java.util.LinkedHashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.naturalpark.Survey;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//returns a map containing parks and their associated vote count
	@Override
	public LinkedHashMap<String, Integer> getParkVotes() {
		
		LinkedHashMap<String, Integer> surveyMap = new LinkedHashMap<>();
		
		String sqlSelectAllVotes = "SELECT park.parkname, COUNT (*) " + 
				"FROM survey_result " + 
				"JOIN park on park.parkcode = survey_result.parkcode " + 
				"GROUP BY park.parkname " + 
				"ORDER BY count DESC, parkname ASC " +
				"LIMIT 5";
	
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllVotes);
		while (results.next()) {
			surveyMap.put(results.getString("parkname"), results.getInt("count"));
		}
		return surveyMap;
		}
		
	//saves a new survey to the database from what the user input on the form page
	@Override
	public void save(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result "+
		        "(parkcode, emailaddress, state, activitylevel) "+
		        "VALUES "+
		                "(?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
		}

}
