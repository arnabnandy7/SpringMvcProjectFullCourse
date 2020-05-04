<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Alert</title>
</head>
<body>
	<h1>${headerMessage}</h1>

	<h1>Congratulations!! the Engineering college has processed your Application form successfully</h1>
	
	<h2>Details submitted by you:: </h2>
	
	<table>
		<tr>
			<td>Student Name :</td>
			<td>${student1.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby :</td>
			<td>${student1.studentHobby}</td>
		</tr>
		<tr>
			<td>Student Mobile :</td>
			<td>${student1.studentMobile}</td>
		</tr>
		<tr>
			<td>Student DOB :</td>
			<td>${student1.studentDOB}</td>
		</tr>
		<tr>
			<td>Student Skills :</td>
			<td>${student1.studentSkills}</td>
		</tr>
		<tr>
			<td>Student Address :<br><br><br><br></td>
			<td>Country: ${student1.studentAddress.country}<br>
				City: ${student1.studentAddress.city}<br>
				Street: ${student1.studentAddress.street}<br>
				Pincode: ${student1.studentAddress.pincode}
			</td>
		</tr>
	</table>
	
</body>
</html>