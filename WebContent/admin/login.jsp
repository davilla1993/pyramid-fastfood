<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pyramid Fastfood | Admin Login</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

    <div class="main">
    
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                 <div class="signin-image">
                        <figure><img src="${pageContext.request.contextPath}/images/signin-image.jpg" alt="sing up image"></figure>
                    </div>
                    <div class="signin-form">
                        <h2 class="form-title">Admin Login</h2>
                        <c:if test="${message != null}">
                       		<div class="alert alert-danger alert-dismiss fade=show" role="alert">
								<strong>${message}</strong>
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="rue">&times;</span>
								</button>
							</div>
                        </c:if>
                        <form method="post" action="login" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your email"/>
                            </div>
                            <div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="password" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form>
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
	$(document).ready(function() {
		$("#login-form").validate({
			rules : {
				email : {
					required : true,
					email : true
				},

				password : "required",

			},

			messages : {
				email : {
					required : "Please, enter your e-mail address",
					email : "Enter a valid e-mail address"
				},

				password : "Please, enter your password"

			}
		});

	});
</script>
</html>