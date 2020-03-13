<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	   
       <div class="container site">
       
       	<h1 class="text-logo">
			<span class="glyphicon glyphicon-cutlery"></span>Pyramid Fast Food<span class="glyphicon glyphicon-cutlery"></span>
		</h1>		
       </div>
       <div style="margin-left:50px; padding-top:1px;">
       	 <jsp:directive.include file="navbar.jsp"/>
       </div>
	    <nav>
			<ul class="nav nav-pills">
				<c:forEach items="${listCategory}"  var="category" varStatus = "status">
					<li role="presentation"><a href="view_category?id=${category.idcategory}">
					<c:out value="${category.name}" /> </a></li>
				</c:forEach>
			</ul>
		</nav>

		