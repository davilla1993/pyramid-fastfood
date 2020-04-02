<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<head>
	 	<meta charset="utf-8"/>
		<title>Pyramid Fastfood | Home</title>
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
				<div class="tab-content">
					<c:forEach var="item" items="${listFirstCategoryItems}" varStatus="status">
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<img src="data:image/jpg;base64,${item.base64Image}">										
									<div class="price"><fmt:formatNumber value="${item.price}" type="currency" currencySymbol="&euro;"/></div>
								<div class="caption">
									<h4>${item.name}</h4>
									<p>${item.description}</p>
									<a href="view_item?id=${item.iditem}" class="btn btn-order" role="button" ><span class="glyphicon glyphicon-info-sign"></span> VOIR DETAILS</a>
								</div>
							</div>
						</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>