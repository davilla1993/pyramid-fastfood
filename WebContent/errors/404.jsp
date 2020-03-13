<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<head>
	 	<meta charset="utf-8"/>
		<title>Pyramid Fastfood | Page Not Found Error</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 		<link href='http://fonts.googleapis.com/css?family=Holtwood+One+SC' rel='stylesheet' type='text/css'>
	</head>
     <body>
			<div class="container">
        		<h1 class="display-1 text-center">404</h1>
        		<p class="lead text-center">Page not found. You can
          		<a href="javascript:history.back()">go back</a> to the previous page, or
          		<a href="${pageContext.request.contextPath}">return home</a>.</p>
			</div>&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="row">
        	<div class="col-md-12 col-md-12 col-sm-12 col-xs-12 text-center login-footer">
                <p>Copyright © 2020 <a href="#">Pyramid Tech</a> All rights reserved.</p>
            </div>
         </div>
	</body>
</html>