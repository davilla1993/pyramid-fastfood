<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Pyramid Fastfood | Home</title>
		<meta charset="utf-8" />
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
						<c:forEach var="item" items="${listItems}" varStatus="status">
							<%-- <c:if test="${status.first}">
								<div class="tab-pane active" id="#${categories.id}"></div>
							</c:if>
							<c:if test="not ${status.first}"> --%>
								<div class="tab-pane" id="#${categories.id}" ></div>
							<%-- </c:if> --%>
							
								<div class="col-sm-6 col-md-4">
									<div class="thumbnail">
											<img src="data:image/jpg;base64,${item.base64Image}">										
											<div class="price"><fmt:formatNumber type="currency" value="${item.price}" currencySymbol="&euro;"/></div>
										<div class="caption">
											<h4>${item.name}</h4>
												<p>${item.description}</p>
												<a href="#" class="btn btn-order" role="button"><span class="glyphicon glyphicon-shopping-cart"></span>Commander</a>
										</div>
									</div>
								</div>
							
						</c:forEach>
					
				</div>
		</div>
	</body>
</html>


