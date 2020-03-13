<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pyramid Fastfood | Create new item</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	  <div class="container">
		<div class="col-lg-10 col-lg-offset-1" style="padding-top:50px">
		<h1 style="text-align:center; font-weight:bold">Create new item</h1>
		
		 <c:if test="${message != null}">
					<div class="alert alert-success alert-dismiss fade=show" role="alert">
						<strong>${message}</strong>
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="rue">&times;</span>
						</button>
					</div>
          </c:if>
              
			<form action="create_item" method="post" id="itemForm" enctype="multipart/form-data">
					<div class="form-group col-md-12">
						<label for="category">Category</label>
						<select name="category" class="form-control" id="category">
							<optgroup>
								<option selected="selected"> </option>
								<c:forEach items="${listCategory}" var="category">
                            	<option value="${category.idcategory}">${category.name}</option>
                            </c:forEach>
							</optgroup>
                       </select>
					</div>
					<div class="form-group col-md-12">
						<label for="name">Name</label> <input type="text" class="form-control" id="name" name="name" placeholder="Name"/>
					</div>

					<div class="form-group col-md-12">
						<label for="description">Description</label> <input type="text" class="form-control" id="description" name="description" placeholder="Description" />
					</div>
					
					<div class="form-group col-md-12">
						<label for="email">Price</label> 
						 <input type="number" step="0.01" class="form-control" id="price" name="price" placeholder="Price">
					</div>
			
					<div class="form-group col-md-12">
						  <input type="file" name="itemImage" id="itemImage" name="20"/><br/>
						  <img id="thumbnail" alt="Image Preview" src="data:image/jpg;base64,${item.base64Image}" style="width:10%; margin-top:5px"/>
					</div>
					
				
				<div class="col-md-6">
					<input type="submit" name="submit" class="btn btn-success" value="Send" style="height:35px"/>
					<a href="item_list.jsp">Cancel</a>
				</div>
			</form>
		</div>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		
		$('#itemImage').change(function(){
			showImageThumbnail(this);
		});
		
		$("#itemForm").validate({
			rules: {
				price : {
					required : true,
					number : true
				},
				
				category: "required",
				name: "required",
				description: "required",
				itemImage: "required"
			},
			
			messages: {
				price: {
					required: "Please, enter the price",
					number: "Only numbers are allowed"
				},
				
				category: "Please, select a category for the item",
				name: "Please, enter the name of item",
				description : "You must enter a small description of the item ",
				itemImage : "You must choose an image of the item"
				
			}
		});
		
	});
	
	$("#cancel").click(function(){
		history.go(-1);
	});
	
	function showImageThumbnail(fileInput){
		var file = fileInput.files[0];
		var reader = new FileReader();
		reader.onload = function(e){
			$('#thumbnail').attr('src', e.target.result);
			
			};

			reader.readAsDataURL(file);
			} 
</script>
</html>