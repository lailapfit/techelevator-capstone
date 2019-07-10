package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {

	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey() {
		
		return "survey";
	}
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String displaySurveyResult() {
		
		return "surveyResult";
	}
	
}
