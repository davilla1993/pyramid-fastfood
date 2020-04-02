<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="utf-8">
			<title>Pyramid Fastfood | Checkout</title>
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styless.css" />
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" />
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
			<link href='http://fonts.googleapis.com/css?family=Holtwood+One+SC' rel='stylesheet' type='text/css'>
		</head>
		<body>
		
			<jsp:directive.include file="header.jsp" />
		
			<div align="center" class=" container admin">
				<c:if test="${message != null }">
					<div>
						<h4>${message}</h4>
					</div>
				</c:if>
				<c:set var="cart" value="${sessionScope['cart']}" />
				
				<c:if test="${cart.totalItems == 0}">
					<h2>There is no items in your cart</h2>
				</c:if>
				
				<c:if test="${cart.totalItems > 0}">
					<div>
						<h4>Review Your Order Details <u><a href="view_cart">Edit</a></u></h4>
					<table border="1">
					<tr>
						<th>No</th>
						<th colspan="2">Items</th>
						<th>Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>SubTotal</th>
					</tr>
					<c:forEach items="${cart.items}" var="item" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td><img src="data:image/jpg;base64,${item.key.base64Image}" width="100" height="150" /></td>
							<td><span id="item-name">${item.key.name}</span></td>
							<td>${item.key.name}</td>
							<td><fmt:formatNumber value="${item.key.price}" type="currency" currencySymbol="&euro;"/></td>
							<td align="center"><input type="text" name="quantity${status.index + 1}" value="${item.value}" size="5" readonly="readonly" /></td>
							<td><fmt:formatNumber value="${item.value*item.key.price}" type="currency" currencySymbol="&euro;"/></td>
						</tr>
					</c:forEach>

					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td><b>${cart.totalQuantity} item(s)</b></td>
						<td>Total:</td>
						<td colspan="2"><b><fmt:formatNumber value="${cart.totalAmount}" type="currency" currencySymbol="&euro;"/></b></td>
					</tr>
				</table>
				<h2>Your Shipping Information</h2>
				<form id="orderForm" action="place_order" method="post">
					<table>
						<tr>
							<td>Recipient Name:</td>
							<td><input type="text" name="recipientName" value="${loggedCustomer.fullname}" /></td>
						</tr>
						<tr>
							<td>Address:</td>
							<td><input type="text" name="address" value="${loggedCustomer.address}" /></td>
						</tr>
						<tr>
							<td>City:</td>
							<td><input type="text" name="city"
								value="${loggedCustomer.city}" /></td>
						</tr>
						<tr>
							<td>Phone:</td>
							<td><input type="text" name="recipientPhone"
								value="${loggedCustomer.phone}" /></td>
						</tr>
						
					</table>
					<div>
						<h4>Payment</h4>
						Choose your payment method: &nbsp;&nbsp;&nbsp; <select
							name="paymentMethod">
							<option value="Cash On Delivery">Cash On Delivery</option>
						</select>
					</div>
					<div>
						<table class="normal">
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td></td>
								<td><button type="submit" class="btn btn-success">Place Order</button></td>
								<td><a href="${pageContext.request.contextPath}/" class="btn btn-primary">Continue Shipping</a></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</c:if>
		</div>
	</body>
</html>