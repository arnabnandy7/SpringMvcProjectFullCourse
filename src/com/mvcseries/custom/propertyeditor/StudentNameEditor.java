package com.mvcseries.custom.propertyeditor;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {

	// When you will submit the admission form -->
	// Spring MVC will run setAsText function of this class -->
	// Before performing data binding task for studentName property of student
	// object

	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {
		System.out.println("inside setAsText");
		if (studentName.contains("Mr.") || studentName.contains("Ms.")) {
			setValue(studentName);
		} else {
			studentName = "Ms." + studentName;
			setValue(studentName); // What every value you will provide to setValue --- spring MVC will use the
									// same value to perform data binding task for studentName property
		}

	}
}
