package com.mvcseries.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcseries.model.Student;

@Controller
public class StudentAdmissionController {

	// Validating mobile number to be non numeric
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setDisallowedFields(new String[] { "studentMobile" });
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy*****MM*****dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		// Following is used if we want to use extra class like StudentNameEditor
		// binder.registerCustomEditor(String.class, "studentName", new
		// StudentNameEditor());
		// If we don't want to use an extra class like StudentNameEditor then anonymous
		// class can be implemented
		binder.registerCustomEditor(String.class, "studentName", new PropertyEditorSupport() {
			// When you will submit the admission form -->
			// Spring MVC will run setAsText function of this class -->
			// Before performing data binding task for studentName property of student
			// object
			@Override
			public void setAsText(String studentName) throws IllegalArgumentException {
				if (studentName.contains("Mr.") || studentName.contains("Ms.")) {
					setValue(studentName);
				} else {
					studentName = "Ms." + studentName;
					setValue(studentName); // What every value you will provide to setValue --- spring MVC will use the
											// same value to perform data binding task for studentName property
				}

			}
		});
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleNullPointerException(Exception e) {
		System.out.println("Exception Occured : " + e);
		ModelAndView model = new ModelAndView("Error");
		return model;
	}

	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception {

		ModelAndView model = new ModelAndView("AdmissionForm");
		// model.addObject("headerMessage", "National College of Engineering, India");
		return model;
	}

	// This method getting called first before any other method in this controller
	// due to having ModelAttribute annotation.
	@ModelAttribute
	public void addingCommonObjects(Model model1) {
		model1.addAttribute("headerMessage", "National College of Engineering, India");
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student1, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView modelErr = new ModelAndView("AdmissionForm");
			return modelErr;
		}
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		// model.addObject("headerMessage", "National College of Engineering, India");
		return model;
	}
}
