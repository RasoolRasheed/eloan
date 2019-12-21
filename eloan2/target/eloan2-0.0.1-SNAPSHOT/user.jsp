<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User</title>
</head>
<body>
	<table class="table table-hover">
		<tr>
			<th width="80">Student_ID</th>
			<th width="120">firstName</th>
			<th width="120">lastName</th>
			<th width="60">Grade</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${viewUser}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<%-- <td>${student.lastName}</td>
				<td>${student.grade.description}</td>
				<td><a  path="studentId" href="<c:url value='/edit/${student.studentId}.ru' />" >Edit</a></td>
				<td><a path="studentId" href="<c:url value='/remove/${student.studentId}.ru' />" >Delete</a></td> --%>
			</tr>
		</c:forEach>
	</table>
</body>
</html>