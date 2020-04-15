<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<!DOCTYPE html>
		<html>
			<head>
				<meta charset="utf-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
				<meta name="description" content="">
				<meta name="author" content="">
				<title>Pyramid Fastfood | List Of Orders</title>
				<link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
				<link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
				<link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">
					  
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
				<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
				<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js" ></script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>
			</head>
			
		   <body id="page-top">
		   
		  	 	<!-- header -->
				<jsp:directive.include file="header.jsp" />
	
  		  	<div id="wrapper">
  		  	
    			<!-- Sidebar -->
   				<jsp:directive.include file="sidebar.jsp" />

   		  		<div id="content-wrapper">

               		<div class="container-fluid">
               		
        				<!-- Breadcrumbs-->
        				<jsp:directive.include file="breadcrumb.jsp" />

				        <!-- Users data table -->
				     	<div class="card mb-3">
				          	<div class="card-header">List Of Orders </div>
				          		<div class="card-body">
				            		<div class="table-responsive">
				             			<c:if test="${message != null}">
				             				<div class="alert alert-success alert-dismiss fade=show" role="alert" role="alert">
												<strong>${message}</strong>
													<button type="button" class="close" data-dismiss="alert" aria-label="Close">
														<span aria-hidden="rue">&times;</span>
													</button>
											</div>
				              			</c:if>
				              			<table class="table table-bordered" id="dataTable">
				                			<thead>
				                  				<tr>
				                    				<th>ID</th>
				                    				<th>Order ID</th>
				                    				<th>Ordered By</th>
				                    				<th>Quantity</th>
				                    				<th>Total</th>
				                    				<th>Status</th>
				                    				<th>Order Date</th>
				                    				<th>Actions</th>
				                  				</tr>
				                			</thead>
				               				 <tbody>
				                				<c:forEach items="${listOrder}" var="order" varStatus ="status">
				                  					<tr>
				                    					<td>${status.index+1}</td>
				                    					<td>${order.idorder}</td>
				                    					<td>${order.customer.fullname}</td>
				                    					<td>${order.itemCopies}</td>
				                    					<td><fmt:formatNumber value="${order.total}" type="currency" currencySymbol="&euro;" /></td>	
				                    					<td>${order.status}</td>
				                				        <td>${order.orderDate}</td>
														<td>
															<a class="btn btn-primary" href="view_order?id=${order.idorder}"><span class="glyphicon glyphicon-info-sign"></span>Details</a>
															<a class="btn btn-primary" href="edit_order?id=${order.idorder}"><span class="glyphicon glyphicon-pencil"></span>Edit</a> 
															<a class="btn btn-danger deleteLink" href="javascript:void(0);" id="${order.idorder}"><span class="glyphicon glyphicon-remove"></span> Delete</a>
														</td>
													</tr>
				                				</c:forEach>
				                			</tbody>
				              			</table>
				            		</div>
				          		</div>
				        	</div>
      					</div>
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
      				<footer class="sticky-footer">
        				<div class="container my-auto">
          					<div class="copyright text-center my-auto">
            					<span>Copyright © Pyramid Tech Agency  2019</span>
          					</div>
        				</div>
      				</footer>
    			</div>
  			</div>
  <!-- /#wrapper -->

  <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>
  <script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>
  <script src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script>

</body>
<script>
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click" , function(){
				idorder = $(this).attr("id");
				if(confirm('Are you sure you want to delete this order ?')){
					window.location = 'delete_order?id=' + idorder;
				}
			});
		});
	});
		
</script>
</html>