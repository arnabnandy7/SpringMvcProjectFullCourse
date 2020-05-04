package com.mvcseries.backup.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcseries.model.Student;

//@Controller
public class StudentAdmissionControllerUsingMdlAttr {
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model = new ModelAndView("AdmissionForm");
		model.addObject("headerMessage", "National College of Engineering, India");
		return model;
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1) {

		ModelAndView model = new ModelAndView("AdmissionSuccess");

		model.addObject("headerMessage", "National College of Engineering, India");

		return model;
	}
}
