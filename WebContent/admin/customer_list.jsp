<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Pyramid Fastfood | List Of Customers</title>
  <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  

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
          <div class="card-header">
            List Of Customers </div>
          <div class="card-body">
            <div class="table-responsive">
             <c:if test="${message != null}">
					<div class="alert alert-success alert-dismiss fade=show" role="alert">
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
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>City</th>
                    <th>Address</th>
                  	<th>Phone</th>
                    <th>Register Date</th>
                    <th style="width:200px;">Actions</th>
                  </tr>
                </thead>
                
                <tbody>
                <c:forEach items="${listCustomers}" var="customer" varStatus = "status">
                  <tr>
                    <td>${customer.idcustomer}</td>
                    <td>${customer.fullname}</td>
                    <td>${customer.email}</td>
                    <td>${customer.city}</td>
                    <td>${customer.address}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.registerDate}</td>
                    
					<td>
						<a class="btn btn-primary" href="edit_customer?id=${customer.idcustomer}"><span class="glyphicon glyphicon-pencil"></span>Update</a> 
						<a class="btn btn-danger deleteLink" href="javascript:void(0)" id="${customer.idcustomer}"><span class="glyphicon glyphicon-remove"></span> Delete</a>
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
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

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
			$(this).on("click", function(){
				customerId = $(this).attr("id");
				if(confirm('Are you sure you want delete this customer?')){
					window.location = 'delete_customer?id=' + customerId;
				}
			});
		});
	});
</script>
</html>

