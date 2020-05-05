package com.mvcseries.controller;

import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mvcseries.model.Student;

@RestController
public class StudentInfoRESTAPIController {

	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE })
	public ArrayList<Student> getStudentsList() {
		Student student1 = new Student();
		student1.setStudentName("The Great Khali");

		Student student2 = new Student();
		student2.setStudentName("The Undertaker");

		Student student3 = new Student();
		student3.setStudentName("John Cena");

		ArrayList<Student> studentsList = new ArrayList<Student>();
		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);

		return studentsList;
	}

	//
	// URI: http://localhost:8080/SpringMvcProjectFullCourse/students/john
	// Response Body : {"student_name":"john","studentHobby":"WWE"}
	//
	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {
		// fetch the student's record using studentName from DB
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("WWE");

		return student;
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateStudent(@PathVariable("name") String studentName, @RequestBody Student student1) {
		ResponseEntity<Void> reOk = new ResponseEntity<Void>(HttpStatus.OK);
		ResponseEntity<Void> reNf = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		ResponseEntity<Void> re = reOk;
		System.out.println("Student Name: " + studentName);
		System.out.println(
				"Student Name: " + student1.getStudentName() + " Student Hobby: " + student1.getStudentHobby());

		// find matching student record using "studentName" from the DB
		// update the matching student record with the information of student sent by
		// the client

		// return true if update is successfully done and return false if update is not
		// done successfully

		// In order to get both response body and status from REST API
		// new ResponseEntity<Student>(student1, HttpStatus.NOT_FOUND);

		// For customizing Response Headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("SampleKey", "SampleValue");
		httpHeaders.add("SampleKey1", "SampleValue1");
		re = new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
		// new ResponseEntity<Student>(student1, httpHeaders, HttpStatus.NOT_FOUND);

		if (false)
			re = reNf;

		return re;
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createStudent(@RequestBody Student student) {
		System.out
				.println("Student Name: " + student.getStudentName() + " Student Hobby: " + student.getStudentHobby());

		// insert the student record into database
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(student.getStudentName()).toUri().toString());

		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.CREATED);
	}
}
