<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="utf-8">
			<title>Pyramid Festfood | Add Item </title>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js" ></script>
        	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>
        	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		</head>
		<body>
			<div align="center">
			
				<h4>The item <i>${item.name}</i> has been added to the order ID <b>${order.idorder}</b></h4>
				<input type="button" class="btn btn-danger" onclick="javascript:self.close();" value="Close">
				
			</div>
		</body>
		
		<script>
			window.onunload = function(){
				window.opener.location.reload(); 
			}
		</script>
		</html>