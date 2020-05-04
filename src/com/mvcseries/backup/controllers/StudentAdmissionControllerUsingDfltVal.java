package com.mvcseries.backup.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class StudentAdmissionControllerUsingDfltVal {
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model = new ModelAndView("AdmissionForm");
		model.addObject("headerMessage", "National College of Engineering, India");
		return model;
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue = "Mr. XYZ") String name,
			@RequestParam("studentHobby") String hobby) {

		ModelAndView model = new ModelAndView("AdmissionSuccess");

		model.addObject("msg", "Details submitted by you:: Name: " + name + " ,Hobby: " + hobby);

		return model;
	}
}
