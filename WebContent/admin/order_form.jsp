<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Pyramid Fastfood | Edit Order</title>
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js" ></script>
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styless.css" />
		</head>
		<body>
			<div class="container grid">
						<div align="center">
							<h4 class="pageheading">Edit Order ID: ${order.idorder}</h4>
						</div>	
						<form action="update_order" method="post" id="orderForm">
						<div align="center">
							<table>
								<tr>
									<td><b>Ordered By:</b></td>
									<td>${order.customer.fullname}</td>
								</tr>
								<tr>
									<td><b>Order Date:</b></td>
									<td>${order.orderDate}</td>
								</tr>
								<tr>
									<td><b>Recipient Name:</b></td>
									<td><input type="text" name="recipientName" value="${order.recipientName}" size="45"/></td>
								</tr>
								<tr>
									<td><b>Recipient Phone:</b></td>
									<td><input type="text" name="recipientPhone" value="${order.recipientPhone}" size="45"/></td>
								</tr>
								<tr>
									<td><b>Ship to:</b></td>
									<td><input type="text" name="shippingAddress" value="${order.shippingAddress}" size="45"/></td>
								</tr>
								<tr>
									<td><b>Payment Method:</b></td>
									<td>
										<select name="paymentMethod">
											<option value="Cash On Delivery">Cash On Delivery</option>
										</select>
									</td>
								</tr>
								<tr>
									<td><b>Order Status:</b></td>
									<td>
										<select name="orderStatus">
											<option value="Processing" <c:if test="${order.status eq 'Processing'}">selected='selected'</c:if> >Processing</option>
											<option value="Shipping"  <c:if test="${order.status eq 'Shipping'}">selected='selected'</c:if> >Shipping</option>
											<option value="Delivered" <c:if test="${order.status eq 'Delivered'}">selected='selected'</c:if> >Delivered</option>
											<option value="Completed" <c:if test="${order.status eq 'Completed'}">selected='selected'</c:if> >Completed</option>
											<option value="Cancelled" <c:if test="${order.status eq 'Cancelled'}">selected='selected'</c:if> >Cancelled</option>
										</select>
									</td>
								</tr>
								
							</table>
						</div>
						<div align="center">
							<h2>Ordered Items</h2>
							<table border="1">
								<tr>
									<th>Index</th>
									<th>Item</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Subtotal</th>
									<th></th>
								</tr>
								<c:forEach items="${order.orderDetails }" var="orderDetail" varStatus="status">
									<tr>
										<td>${status.index + 1}</td>
										<td>${orderDetail.items.name}</td>
										<td>
											<input type="hidden" name="price" value="${orderDetail.items.price}"/>
											<fmt:formatNumber value="${orderDetail.items.price}" type="currency" currencySymbol="&euro;"/>
										</td>
										<td>
											<input type="hidden" name="iditem" value="${orderDetail.items.iditem}"/>
											<input type="text" name="quantity${status.index + 1}" value="${orderDetail.quantity}" size="5"/>
										</td>
										<td><fmt:formatNumber value="${orderDetail.subtotal}" type="currency" currencySymbol="&euro;" /></td>
										<td><a href="remove_item_from_order?id=${orderDetail.items.iditem}" class="btn btn-danger">Remove</a></td>
									</tr>
								</c:forEach>
									<tr>
										<td colspan="4" align="right">
											<b><i>TOTAL:</i></b>
										</td>
										<td>
											<b>${order.itemCopies}</b>
										</td>
										<td>
											<b><fmt:formatNumber value="${order.total}" type="currency" currencySymbol="$" /></b>
										</td>
									</tr>
							</table>
						</div>
						 
						<div align="center">
						<br/>
							<a href="javascript:showAddItemPopup()" class="btn btn-success btn-lg"><b>Add Items</b></a>
								&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-success btn-lg">Save</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-danger btn-lg" onClick="javascript:window.location.href='list_order';">Cancel</button>
						</div>
				</form>		
								
			</div>
			
			<script>
				function showAddItemPopup() {
					var width = 600;
					var height = 250;
					var left = (screen.width - width) / 2;
					var top = (screen.height - height) / 2;
					window.open('add_item_form', '_blank', 'width=' + width + ' , height=' + height + ' , top=' + top + ', left=' + left);
					}

				$(document).ready(function() {

					$("#orderForm").validate({
						rules : {

							recipientName : "required",
							recipientPhone : "required",
							shippingAddress : "required",
							 
							<c:forEach items="${order.orderDetails}" var="item" varStatus="status">
								quantity${status.index + 1 } : {
								required : true, 
								number : true,
								min : 1
								},
							</c:forEach>
						},

						messages : {

							recipientName : "Please, enter recipient name",
							recipientPhone : "Please, enter recipient phone",
							shippingAddress : "Please, enter shipping address",

							<c:forEach items="${order.orderDetails}" var="item" varStatus="status">
								quantity${status.index + 1 } : {
								required : "Please enter quantity",
								number : " Quantity must be a number",
								min : "Quantity must be greater than 0"
								},
							</c:forEach>

						}
					})
				});

			</script>
		</body>
		
</html> 