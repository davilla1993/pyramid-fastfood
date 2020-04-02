<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="utf-8">
			<title>Pyramid fastfood | My Order Details</title>
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
					<c:if test="${order == null}">
						<div align="center"><h3 class="pageheading">Sorry, you are not authorized to view this order.</h3></div>
					</c:if>
			
					<c:if test="${order != null}">
						<div align="center"><h2 class="pageheading">Your Order ID: ${order.idorder}</h2>
							<table>
								<tr>
									<td><b>Order Status:</b></td>
									<td>${order.status}</td>
								</tr>
								<tr>
									<td><b>Order Date:</b></td>
									<td>${order.orderDate}</td>
								</tr>
								<tr>
									<td><b> Count of Items:</b></td>
									<td>${order.itemCopies}</td>
								</tr>
								<tr>
									<td><b>Total Amount:</b></td>
									<td><fmt:formatNumber value="${order.total}" type="currency" currencySymbol="&euro;"/></td>
								</tr>
								<tr>
									<td><b>Recipient Name:</b></td>
									<td>${order.recipientName}</td>
								</tr>
								<tr>
									<td><b>Recipient Phone:</b></td>
									<td>${order.recipientPhone}</td>
								</tr>
								<tr>
									<td><b>Ship to:</b></td>
									<td>${order.shippingAddress}</td>
								</tr>
								
							</table>
						</div>  
			
						<div align="center">
							<h2>Ordered Items</h2>
								<table border="1">
									<tr>
										<th>No</th>
										<th>Items</th>
										<th>Name</th>
										<th>Price</th>
										<th>Quantity</th>
										<th>Subtotal</th>
									</tr>
									<c:forEach items="${order.orderDetails }" var="orderDetail" varStatus="status">
										<tr>
											<td>${status.index + 1}</td>
											<td>
												<img style="vertical-align:middle;" src="data:image/jpg;base64,${orderDetail.items.base64Image}" width="48" height="64"/>
												${orderDetail.items.name}
											</td>
											<td>${orderDetail.items.name}</td>
											<td><fmt:formatNumber value="${orderDetail.items.price}" type="currency" currencySymbol="&euro;"/></td>
											<td>${orderDetail.quantity}</td>
											<td><fmt:formatNumber value="${orderDetail.subtotal}" type="currency" currencySymbol="&euro;"/></td>
										</tr>
									</c:forEach>
										<tr>
											<td colspan="4" align="right"><b><i>TOTAL:</i></b></td>
											<td><b>${order.itemCopies}</b></td>
											<td>
												<b><fmt:formatNumber value="${order.total}" type="currency" currencySymbol="&euro;"/></b>
											</td>
										</tr>
								</table>
							</div>
						</c:if>
					</div>
				</body>
			</html>