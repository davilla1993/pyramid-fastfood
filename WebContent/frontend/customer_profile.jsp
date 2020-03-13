<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<title>Pyramid Fastfood | My Profile</title>
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
			<link href='http://fonts.googleapis.com/css?family=Holtwood+One+SC' rel='stylesheet' type='text/css'>
        	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        	
		</head>
		<body>
			<div class="container site">
				<jsp:directive.include file="header.jsp" />
			</div>
			<div class="container">
				<div class="jumbotron">
					<div class="mx-auto" style="text-align:center;" >
						<h2><u>My Profile</u></h2>
							<table class="table table stripped">
								<tr><td>Name:</td>
									<td>${loggedCustomer.fullname}</td>
								</tr>
								<tr><td>Email:</td>
									<td>${loggedCustomer.email}</td>
								</tr>
								<tr><td>City:</td>
									<td>${loggedCustomer.city}</td>
								</tr>
								<tr><td>Address:</td>
									<td>${loggedCustomer.address}</td>
								</tr>
								<tr><td>Phone:</td>
									<td>${loggedCustomer.phone}</td>
								</tr>
								<tr><td>Register Date:</td>
									<td>${loggedCustomer.registerDate}</td>
								</tr>
							</table>&nbsp;&nbsp;&nbsp;&nbsp;				
							<p><a class="btn btn-primary btn-sm" href="edit_profile" role="button">Edit profile</a></p>
					</div>
				</div>
		</div>
	</body>
</html>