<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pyramid Fastfood | Update customer</title>

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
                        <h2 class="form-title">Update customer</h2>
                        <c:if test="${message != null}">
                       		<div class="alert alert-danger alert-dismiss fade=show" role="alert">
								<strong>${message}</strong>
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="rue">&times;</span>
								</button>
							</div>
                        </c:if>
                        <form id="registerForm" method="post" action="update_customer" class="register-form">
                        <input type="hidden" name="idcustomer" value="${customer.idcustomer}">
                            <div class="form-group">
                                <label for="fullname"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="fullname" id="fullname" value="${customer.fullname}" placeholder="Your Full Name"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" value="${customer.email}" placeholder="Your Email"/>
                            </div>
 							<div class="form-group">
                                <label for="city"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="city" id="city" value="${customer.city}" placeholder="Your city"/>
                            </div>
							<div class="form-group">
                                <label for="address"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="address" id="address" value="${customer.address}" placeholder="Your address"/>
                            </div>
 							<div class="form-group">
                                <label for="phone"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="phone" id="phone" value="${customer.phone}" placeholder="Your phone number"/>
                            </div>
                            <div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="password" value="${customer.password}" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="confirmPassword" id="confirmPassword" value="${customer.password}" placeholder="Confirm your password"/>
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
				password: "required",
				
				confirmPassword: {
					required: true,
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