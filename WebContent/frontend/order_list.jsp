<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<!DOCTYPE html>
		<html>
			<head>
				<meta charset="utf-8">
				<title>Pyramid fastfood | My Order History</title>
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
				<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
				<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
				<link href='http://fonts.googleapis.com/css?family=Holtwood+One+SC' rel='stylesheet' type='text/css'>
				<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
				<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styless.css" />
			</head>
			<body>
				<jsp:directive.include file="header.jsp"/>
					<div class="container admin">
						<div align="center"><u><h3 class="pageheading">My Order History</h3></u></div>
						<c:if test="${fn:length(listOrders) == 0}">
							<h4>You have not placed any orders.</h4>
						</c:if>
					
						<c:if test="${fn:length(listOrders) > 0}">
							<div align="center">
								<table class="table table-bordered">
									<thead class="thead-light">
										<tr>
											<th scope="col">Index</th>
											<th scope="col">Order ID</th>
											<th scope="col">Quantity</th>
											<th scope="col">Total Amount</th>
											<th scope="col">Order Date</th>
											<th scope="col">Status</th>
											<th scope="col">Actions</th>
										</tr>
									</thead>
										<c:forEach var="order" items="${listOrders}" varStatus="status">
											<tbody>
												<tr>
													<td>${status.index +1}</td>
													<td>${order.idorder}</td>
													<td>${order.itemCopies}</td>
													<td><fmt:formatNumber value="${order.total}" type="currency" currencySymbol="&euro;" /></td>
													<td>${order.orderDate}</td>
													<td>${order.status}</td>
													<td><a href="show_order_detail?id=${order.idorder}">Details</a> &nbsp;</td>	
												</tr>
											</tbody>
										</c:forEach>
								</table>	
							</div>
						</c:if>
					</div>
				</body>
			</html>