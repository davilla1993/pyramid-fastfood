<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="utf-8"/>
			<title>Pyramid Fastfood</title>
        	<meta name="viewport" content="width=device-width, initial-scale=1">
        	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 			<link href='http://fonts.googleapis.com/css?family=Holtwood+One+SC' rel='stylesheet' type='text/css'>
        	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
		</head>
		<body>
			<jsp:directive.include file="header.jsp" />	
			<div class="container admin">	
				<div class="container col-md-4">
					<div class="${type}" style="margin:120px, color:green;"> 
						${message}
					</div>		
				</div>
			</div>
		</body>
	</html>