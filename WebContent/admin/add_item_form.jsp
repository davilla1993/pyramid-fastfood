<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Pyramid Fastfood | Add item to order</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js" ></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div align="center">
		<h2>Add Item to Order ID: ${order.idorder}</h2>
		<form action="add_item_to_order" method="post">
		
			<table>
				<tr>
					<td>Select a item : </td>
					<td>
						<select name="iditem">
							<c:forEach items="${listItems}" var="item" varStatus="status">
								<option value="${item.iditem}">${item.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>Number of Copies</td>
					<td>
						<select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>	
						</select>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success">Add</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn btn-danger" onClick="javascript:self.close();">Cancel</button>
					</td>
				</tr>
			</table>	
		</form>
	</div>
	</body>
</html>