package com.mvcseries.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	// public ModelAndView helloWorld(@PathVariable("countryName") String
	// countryName,
	// @PathVariable("userName") String userName) {
	
	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String, String> pathVars) {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "hello " + pathVars.get("userName") + "," + pathVars.get("countryName"));

		return model;
	}
	
}
