package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.naturalpark.Park;
import com.techelevator.naturalpark.Weather;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.WeatherDAO;

@Controller
@SessionAttributes({"parkCode", "park", "temperatureChoice"})
public class ParkController {

	@Autowired
	private ParkDAO dao;
	
	@Autowired
	private WeatherDAO wdao;
	
	
	@RequestMapping("/")
	public String displayHomepageAtRoot() {

		return "redirect:/homepage";
	}
	//we check if the map contains a temperature choice, if not we assign a default. 
	//we populate a list of all parks from our parkDAO
	@RequestMapping(path="/homepage", method=RequestMethod.GET)
	public String displayHomepage(HttpServletRequest request, ModelMap map) {
		
		if (!map.containsAttribute("temperatureChoice")) {
			map.addAttribute("temperatureChoice", false);
		}
		
		List<Park> parks = dao.getAllParks();
		
		request.setAttribute("parks", parks);
		return "homepage";
	}

	
	//we grab the user's selected park object and add it to our session. 
	//we use this park selection to populate weather objects for this park.
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetailPage(HttpServletRequest request, ModelMap map) {
	
		String parkCode = request.getParameter("parkCode");
		Park park = dao.getParkById(parkCode);
		List<Weather> weatherList = wdao.getWeatherByParkId(parkCode);
		map.addAttribute("park", park);
		request.setAttribute("weather", weatherList);
		map.addAttribute("parkCode", parkCode);
		return "parkDetail";
	}
	
	//this is a post redirect get in order to allow the user to switch temperature scales
	 @RequestMapping(path="/parkDetail", method=RequestMethod.POST)
	 public String addTemperatureChange(@RequestParam boolean temperatureChoice,
			  ModelMap map) {
		
		map.addAttribute("temperatureChoice", temperatureChoice);
		 
		 return "redirect:/parkDetail";
	 }


}
