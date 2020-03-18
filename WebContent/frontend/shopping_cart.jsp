<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="uf-8">
			<title>Pyramid fastfood | Shopping cart</title>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
			<link href='http://fonts.googleapis.com/css?family=Holtwood+One+SC' rel='stylesheet' type='text/css'>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styless.css"/>			
		</head>
		<body>
	
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2>Your Cart Details</h2>

		<c:if test="${message != null }">

			<div>
				<h4>${message}</h4>
			</div>
		</c:if>

		<c:set var="cart" value="${sessionScope['cart']}" />

		<c:if test="${cart.totalItems == 0}">
			<h2>Your cart is empty </h2>
		</c:if>

		<c:if test="${cart.totalItems > 0}">
			<form action="update_cart" method="post" id="cartForm">
				<div>
					<table border="1">
						<tr>
							<th>No</th>
							<th colspan="2">Items</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>SubTotal</th>
						</tr>
						<c:forEach items="${cart.items}" var="item" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td><img src="data:image/jpg;base64,${item.key.base64Image}" width="100" height="150"/></td>
								<td><span id="item-name">${item.key.name}</span></td>
								<td align="center">
									<input type="hidden" name="iditem" value="${item.key.iditem}"/>
									<input type="text" name="quantity${status.index + 1}" value="${item.value}" size="5"/>
								</td>
								<td><fmt:formatNumber value="${item.key.price}" type="currency" currencySymbol="&euro;"/></td>
								<td><fmt:formatNumber value="${item.value*item.key.price}" type="currency" currencySymbol="&euro;"/></td>
								<td><a href="remove_from_cart?iditem=${item.key.iditem}">Remove</a></td>
							</tr>
						</c:forEach>

						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><b>${cart.totalQuantity} item(s)</b></td>
							<td>Total:</td>
							<td colspan="2"><b><fmt:formatNumber
										value="${cart.totalAmount}" type="currency" currencySymbol="&euro;"/></b></td>
						</tr>
					</table>
				</div>
				<div>
					<table class="normal">
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td></td>
							<td><button type="submit">Update</button></td>
							<td><input type="button" id="clearCart" value="Clear Cart"/></td>
							<td><a href="${pageContext.request.contextPath }/">Continue Shopping</a></td>
							<td><a href="checkout">Checkout</a></td>
						</tr>
					</table>
				</div>
			</form>
		</c:if>
	</div>

</body>

<script type="text/javascript">
	$(document).ready(function() {
		$("#clearCart").click(function(){
			window.location = 'clear_cart';
			});

		$("#cartForm").validate({
			rules : {
				<c:forEach items="${cart.items}" var="item" varStatus="status">
					quantity${status.index + 1 } : {
						required : true, 
						number : true,
						min : 1
						},
				</c:forEach>
			},

			messages : {
				<c:forEach items="${cart.items}" var="item" varStatus="status">
				quantity${status.index + 1 } : {
					required : "Please enter quantity",
					number : " Quantity must be a number",
					min : "Quantity must be greater than 0"
						},
			</c:forEach>
			}
		});
	});
</script>
</html>