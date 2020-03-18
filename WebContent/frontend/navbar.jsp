<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<nav class="navbar navbar-light ">
	
		<form class="form-inline">
		 <div class="col-sm-4 col-md-12">
			<input class="form-control" type="search" placeholder="Search" aria-label="Search"/>
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		
		  <c:if test="${loggedCustomer == null}">
		  	<a href="login" style="color:white;">Sign in</a> |
		  	<a href="register" style="color:white;">Register</a> |
		  </c:if>
		
		  <c:if test="${loggedCustomer != null}">
		  	<a href="view_profile" style="color:white;">${loggedCustomer.fullname}</a> |
		  	<a href="view_orders" style="color:white;">My Orders</a> |
		  	<a href="logout" style="color:white;">Logout</a> |
		  </c:if>
		  
		  <a href="view_cart" style="color:white;">Cart</a>
		</div>
		</form>
		
	</nav>
	
	