package com.mvcseries.backup.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class StudentAdmissionControllerUsingMap {
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model = new ModelAndView("AdmissionForm");
		model.addObject("headerMessage", "National College of Engineering, India");
		return model;
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> reqParm) {
		ModelAndView model = new ModelAndView("AdmissionSuccess");

		model.addObject("msg", "Details submitted by you:: Name: " + reqParm.get("studentName") + " , Hobby: "
				+ reqParm.get("studentHobby"));

		return model;
	}
}
