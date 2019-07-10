package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParkController {

	@RequestMapping(path="/homepage", method=RequestMethod.GET)
	public String displayHomepage() {
		return "homepage";
	}

	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetailPage() {
		//@RequestMapping
		
		
		return "parkDetail";
	}


}
