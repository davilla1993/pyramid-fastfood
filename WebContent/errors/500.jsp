<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<head>
	 	<meta charset="utf-8"/>
		<title>Pyramid Fastfood | Internal Server Error</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 		<link href='http://fonts.googleapis.com/css?family=Holtwood+One+SC' rel='stylesheet' type='text/css'>
 		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
 
	</head>
       <body>
       		<h1 class="text-logo"><span class="glyphicon glyphicon-cutlery"></span>PYRAMID FASTFOOD<span class="glyphicon glyphicon-cutlery"></span></h1>
       		<div class="color-line"></div>
  
    <div class="container admin">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
            <div class="col-md-6 col-md-6 col-sm-6 col-xs-12">
                <div class="content-error">
                    <h1>Internal Server Error <span class="counter"> 500</span></h1>
                    <p>The server encountered something unexpected that didn't allow it to complete the request. We apologize.</p>
                </div>
                 <div class="back-link back-backend">
                    <a href="${pageContext.request.contextPath}" class="btn btn-primary text-enter">Return home</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
        </div>&nbsp;&nbsp;&nbsp;&nbsp;
        <div class="row">
            <div class="col-md-12 col-md-12 col-sm-12 col-xs-12 text-center login-footer">
                <p>Copyright © 2020 <a href="#">Pyramid Tech</a> All rights reserved.</p>
            </div>
        </div>
    </div>

		</body>
</html>