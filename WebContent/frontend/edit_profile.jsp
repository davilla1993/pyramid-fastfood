<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pyramid Fastfood | Edit Profile</title>

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
                        <h2 class="form-title">Edit My Profile</h2>
                        
                        <c:if test="${message != null}">
                        	<div class="alert alert-danger alert-dismiss fade=show" role="alert">
								<strong>${message}</strong>
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="rue">&times;</span>
								</button>
							</div>
                        </c:if>
                        <form id="registerForm" method="post" action="update_profile" class="register-form">
                         <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="email" value="${loggedCustomer.email}" readonly="readonly"/>
                                (Cannot be changed)
                            </div>
                            <div class="form-group">
                                <label for="fullname"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="fullname" id="fullname" value="${loggedCustomer.fullname}"/>
                            </div>
 							<div class="form-group">
                                <label for="city"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="city" id="city" value="${loggedCustomer.city}"/>
                            </div>
							<div class="form-group">
                                <label for="address"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="address" id="address" value="${loggedCustomer.address}"/>
                            </div>
 							<div class="form-group">
                                <label for="phone"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="phone" id="phone" value="${loggedCustomer.phone}"/>
                            </div>
                            
                            <div><i>(Leave password fields blank if you don't want to change password)</i></div>&nbsp;
                            
                            <div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="password"/>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="confirmPassword" id="confirmPassword"/>
                            </div>
             
                            <div>
                            	<button type="submit"class="btn btn-success">Log in</button>
                                <a href="${pageContext.request.contextPath}" class="btn btn-warning enabled" aria-disabled="true">Cancel</a>
                            </div>
                            &nbsp;&nbsp;
                            <div>
                            	<a href="login" style="text-decoration: underline;">I am already member</a>
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
				email: {
					required: true,
					email: true
				},
				
				phone : {
					required : true,
					number : true,
					minlength : 6
				},
				
				fullname: "required",
				city : "required",
				address : "required",
				
				confirmPassword: {
					equalTo: "#password"
				},
			},
			
			messages: {
				email: {
					required: "Please, enter your e-mail address",
					email: "Enter a valid e-mail address"
				},
				
			phone : {
				required : "Please, enter your phone number",
				number : "Phone number must be numeric",
				minlength : "Minimum 6 digits are required" 
			},
				
				fullname: "Please, enter your fullname",
				password: "Please, enter your password",
				
				confirmPassword: {
					required: "Please, confirm your password",
					euqalTo: "The two password must be the same"
				}
			}
		});
		
	});
	
	$("#cancel").click(function(){
		history.go(-1);
	})
</script>
</html>