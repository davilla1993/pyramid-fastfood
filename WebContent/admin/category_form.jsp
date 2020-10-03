<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pyramid Fastfood | Create new category</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Create new category</h2>
                        
                        <c:if test="${message != null}">
                     		<div class="alert alert-danger alert-dismiss fade=show" role="alert">
								<strong>${message}</strong>
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="rue">&times;</span>
								</button>
							</div>
                        </c:if>
                        <form id="registerForm" method="post" action="create_category" class="register-form">
                            <div class="form-group">
                                <label for="name"></label>
                                <input type="text" name="name" id="name" placeholder="Category Name"/>
                            </div>
                    
                            <div class="form-group form-button">
                                <input type="submit" class="form-submit" value="Register"/>
                                <a  id="cancel" class="form-submit" style ="background : red;">Cancel</a>  
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                    	<figure><img src="${pageContext.request.contextPath}/images/signup-image.jpg" alt="sing up image"></figure>
                    </div>
                </div>
            </div>
        </section>
    </div>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		$("#registerForm").validate({
			rules: {
				
				name: "required"
			},
			
			messages: {
				
				name: "Please, enter category name"
				
			}
		});
		
	});
	
	$("#cancel").click(function(){
		history.go(-1);
	})
</script>
</html>