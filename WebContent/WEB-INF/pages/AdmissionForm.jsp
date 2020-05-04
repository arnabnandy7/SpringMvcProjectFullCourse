<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entry Form</title>
</head>
<body>
	<link rel="stylesheet" href="<spring:theme code='styleSheet' text=''/>" type="text/css" />
	
	<a href="/SpringMvcProjectFullCourse/admissionForm.html?siteTheme=green">Green</a>|
	<a href="/SpringMvcProjectFullCourse/admissionForm.html?siteTheme=red">Red</a>
	<br>
	<a href="/SpringMvcProjectFullCourse/admissionForm.html?siteLanguage=en">English</a>|
	<a href="/SpringMvcProjectFullCourse/admissionForm.html?siteLanguage=fr">French</a>
	
	<h1><spring:message code="label.headerMessage" /></h1>

	<h1><spring:message code="label.admissionForm" /></h1>
	
	<marquee><form:errors path="student1.*" /></marquee>
	
	<form action="/SpringMvcProjectFullCourse/submitAdmissionForm.html" method="post">
		<table>
			<tr>
				<td><spring:message code="label.studentName" /></td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentHobby" /></td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentMobile" /></td>
				<td><input type="tel" name="studentMobile" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentDOB" /></td>
				<td><input type="text" name="studentDOB" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentSkills" /></td>
				<td><select name="studentSkills" multiple>
				<option><spring:message code="label.java.core" /></option>
				<option><spring:message code="label.spring.core" /></option>
				<option><spring:message code="label.spring.mvc" /></option>
				</select></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><spring:message code="label.studentAddress" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.country" /><input type="text" name="studentAddress.country"/></td>
				<td><spring:message code="label.city" /><input type="text" name="studentAddress.city"/></td>
				<td><spring:message code="label.street" /><input type="text" name="studentAddress.street"/></td>
				<td><spring:message code="label.pincode" /><input type="text" name="studentAddress.pincode"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="<spring:message code="label.submit.admissionForm" />"/></td>
			</tr>
		</table>
	</form>	

</body>
</html>