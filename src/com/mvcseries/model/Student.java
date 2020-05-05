package com.mvcseries.model;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mvcseries.custom.annotation.IsValidHobby;

// Properties get excluded from JSON response if found NULL using following annotation
@JsonInclude(JsonInclude.Include.NON_NULL)
// Properties gets excluded from JSON response using following annotation
@JsonIgnoreProperties({ "studentSkills" })
// Properties in JSON response are sorted in following order
@JsonPropertyOrder({ "studentDOB", "student_name", "studentMobile", "studentAddress", "studentHobby", "studentSkills" })
// There are validation annotations used which are @Pattern, @Size, @Max and @Past.
// The user-defined validation annotation @IsValidHobby added for validations not provided.
public class Student {
	// This property in JSON response to be renamed as student_name from
	// 'studentName'
	@JsonProperty("student_name")
	@Pattern(regexp = "[^0-9]*")
	private String studentName;

	// @Size(min=2, max=30, message="Please enter student's hobby value between
	// {min} to {max} characters")
	@Size(min = 2, max = 30)
	@IsValidHobby(listOfValidHobbies = "Music|Football|Cricket|Hockey")
	private String studentHobby;

	@Max(9999999999L)
	private Long studentMobile;

	@Past
	private Date studentDOB;

	private ArrayList<String> studentSkills;

	private Address studentAddress;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentHobby() {
		return studentHobby;
	}

	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}

	public Long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
}
