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
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styless.css" />
		</head>
		<body>
			<jsp:directive.include file="header.jsp" />

			<div align="center">
				<h2 style="color: white">Your Cart Details</h2>
					<c:if test="${message != null }">
						<div>
							<h4>${message}</h4>
						</div>
					</c:if>
						<c:set var="cart" value="${sessionScope['cart']}" />
						
						<c:if test="${cart.totalItems == 0}">
							<h2 style="color: white">Your cart is empty</h2>
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
											<th>Action</th>
										</tr>
										<c:forEach items="${cart.items}" var="item" varStatus="status">
											<tr>
												<td><span style="color: white">${status.index + 1}</span></td>
												<td><img src="data:image/jpg;base64,${item.key.base64Image}" width="100" height="150" /></td>
												<td><span id="item-name" style="color: white">${item.key.name}</span></td>
												<td align="center"><input type="hidden" name="iditem" value="${item.key.iditem}" /> 
												<input type="text" name="quantity${status.index + 1}" value="${item.value}" size="5" /></td>
												<td><span style="color: white"><fmt:formatNumber value="${item.key.price}" type="currency" currencySymbol="&euro;" /></span></td>
												<td><span style="color: white"><fmt:formatNumber value="${item.value*item.key.price}" type="currency" currencySymbol="&euro;" /></span></td>
												<td><a href="remove_from_cart?iditem=${item.key.iditem}"><span class="glyphicon glyphicon-trash" style="font-size: 30px; color: red"></span></a></td>
											</tr>
										</c:forEach>

											<tr>
												<td></td>
												<td></td>
												<td></td>
												<td><span style="color: white"><b>${cart.totalQuantity} item(s)</b></span></td>
												<td><span style="color: white">Total:</span></td>
												<td colspan="2"><span style="color: white"><b><fmt:formatNumber value="${cart.totalAmount}" type="currency" currencySymbol="&euro;" /></b></span></td>
											</tr>
										</table>
										</div>
											<div>
												<button type="submit" class="btn btn-info">Update</button>
												<button class="btn btn-danger" id="clearCart">Clear cart</button>
												<a href="${pageContext.request.contextPath }/" class="btn btn-success">Continue Shopping</a> 
												<a href="checkout" class="btn btn-warning">Checkout</a>
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