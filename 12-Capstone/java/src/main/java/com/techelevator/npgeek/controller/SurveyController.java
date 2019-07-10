package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.naturalpark.Park;
import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class SurveyController {

	@Autowired
	private ParkDAO dao;
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey(HttpServletRequest request) {
		List<Park> parks = dao.getAllParks();
		
		request.setAttribute("parks", parks);
		
		return "survey";
	}
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String displaySurveyResult() {
		
		return "surveyResult";
	}
	
}
