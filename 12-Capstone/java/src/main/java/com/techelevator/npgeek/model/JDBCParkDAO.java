package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.naturalpark.Park;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies "
				+ "FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	@Override
	public Park getParkById(String parkCode) {
		Park park = new Park();
		String sqlSelectParkById = "SELECT parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies " + 
				"FROM park " + 
				"WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkById, parkCode);
		if (results.next()) {
			park = mapRowToPark(results);
		}
		return park;
	}

	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkCode(row.getString("parkcode"));
		park.setParkName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevation(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getFloat("milesoftrail"));
		park.setCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitorCount(row.getInt("annualvisitorcount"));
		park.setQuote(row.getString("inspirationalquote"));
		park.setQuoteSource(row.getString("inspirationalquotesource"));
		park.setDescription(row.getString("parkdescription"));
		park.setEntreeFee(row.getInt("entryfee"));
		park.setAnimalSpecies(row.getInt("numberofanimalspecies"));
		return park;
	}

}
