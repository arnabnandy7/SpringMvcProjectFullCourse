package com.mvcseries.backup.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvcseries.model.Student;

//@Controller
public class StudentAdmissionControllerUsingNormalObj {
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model = new ModelAndView("AdmissionForm");
		model.addObject("headerMessage", "National College of Engineering, India");
		return model;
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)

	public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName") String name,
			@RequestParam("studentHobby") String hobby) {

		Student student1 = new Student();
		student1.setStudentName(name);
		student1.setStudentHobby(hobby);

		ModelAndView model = new ModelAndView("AdmissionSuccess");

		model.addObject("headerMessage", "National College of Engineering, India");
		model.addObject("student1", student1);

		return model;
	}

}
