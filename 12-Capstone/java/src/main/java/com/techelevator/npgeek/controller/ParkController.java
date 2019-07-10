package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.naturalpark.Park;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.WeatherDAO;

@Controller
public class ParkController {

	@Autowired
	private ParkDAO dao;
	
	@Autowired
	private WeatherDAO wdao;
	
	@RequestMapping(path="/homepage", method=RequestMethod.GET)
	public String displayHomepage(HttpServletRequest request) {
		
		List<Park> parks = dao.getAllParks();
		
		request.setAttribute("parks", parks);
		return "homepage";
	}

	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetailPage(HttpServletRequest request) {
		String parkCode = request.getParameter("parkCode");
		Park park = dao.getParkById(parkCode);
		
		request.setAttribute("park", park);
		
		
		return "parkDetail";
	}


}
