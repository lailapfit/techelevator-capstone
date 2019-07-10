package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.naturalpark.Park;
import com.techelevator.naturalpark.Survey;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.SurveyDAO;

@Controller
public class SurveyController {

	@Autowired
	private ParkDAO dao;
	
	@Autowired
	private SurveyDAO sdao;
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey(HttpServletRequest request) {
		List<Park> parks = dao.getAllParks();	
		request.setAttribute("parks", parks);
		
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String addSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult result,
			RedirectAttributes attr) {

		if(result.hasErrors()) {
			return "redirect:/survey";
		}
		
		sdao.save(survey);
		attr.addFlashAttribute("survey", survey);
		return "redirect:/surveyResult";
	}
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String displaySurveyResult() {
		
		return "surveyResult";
	}
	
}
