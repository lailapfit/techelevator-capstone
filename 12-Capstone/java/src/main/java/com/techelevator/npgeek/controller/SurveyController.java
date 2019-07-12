package com.techelevator.npgeek.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.naturalpark.Park;
import com.techelevator.naturalpark.Survey;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.SurveyDAO;

@Controller
@SessionAttributes({"dailySurvey"})
public class SurveyController {

	@Autowired
	private ParkDAO dao;
	
	@Autowired
	private SurveyDAO sdao;
	
	//we grab all parks and put them in a list to populate our user daily survey
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey(ModelMap map) {
		List<Park> parks = dao.getAllParks();	
		map.addAttribute("dailySurvey", parks);
		
		if(! map.containsAttribute("survey")) {
			map.addAttribute("survey", new Survey());
		}
		
		return "survey";
	}
	
	//we perform a post redirect get to make sure the user data is valid with the model attribute
	//we use flash to direct user to the survey results page
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String addSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult result,
			RedirectAttributes attr) {

		if(result.hasErrors()) {
			return "survey";
		}
		
		sdao.save(survey);
		attr.addFlashAttribute("survey", survey);
		return "redirect:/surveyResult";
	}
	
	//we call the survey DAO to query the vote totals and put them in a linkedhashmap
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String displaySurveyResult(HttpServletRequest request) {

		LinkedHashMap<String, Integer> surveys = sdao.getParkVotes();
		
		request.setAttribute("surveys", surveys);
		
		return "surveyResult";
	}
	
}
