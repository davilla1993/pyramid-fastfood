<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
	<html>
		<head>
			<title>Pyramid Fastfood | ${item.name}</title>
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
			<link href='http://fonts.googleapis.com/css?family=Holtwood+One+SC' rel='stylesheet' type='text/css'>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
		</head>
		<body>
		  <jsp:directive.include file="header.jsp"/>
         <div class="container admin">
            <div class="row">
               <div class="col-sm-6">
                    <h1><strong>Détails de ${item.name}</strong></h1>
                    <br>
                    <form>
                      <div class="form-group">
                        <label>Nom:</label>${item.name}
                      </div>
                      <div class="form-group">
                        <label>Description:</label>${item.description}
                      </div>
                      <div class="form-group">
                        <label>Prix:</label><fmt:formatNumber type="currency" value="${item.price}" currencySymbol="&euro;"/>
                      </div>
                      <div class="form-group">
                        <label>Catégorie:</label>${item.category.name}
                      </div>
                      <div class="form-group">
                        <label>Image:</label><img src="data:image/jpg;base64,${item.base64Image}" style="width:120px;">
                      </div>
                    </form>
                    <br>
                    <div class="form-actions">
                      <a class="btn btn-primary" href="${pageContext.request.contextPath}"><span class="glyphicon glyphicon-arrow-left"></span> Retour</a>
                    </div>
                </div> 
                <div class="col-sm-6 site">
                    <div class="thumbnail">
                        <img src="data:image/jpg;base64,${item.base64Image}">
                        <div class="price"><fmt:formatNumber type="currency" value="${item.price}" currencySymbol="&euro;"/>
                          <div class="caption">
                            <h4>${item.name}</h4>
                            <p>${item.description}</p>
                            <button id="buttonAddToCart" class="btn btn-order" role="button"><span class="glyphicon glyphicon-shopping-cart"></span>Commander</button>
                          </div>
                    </div>
                </div>
            </div>
        </div> 
      </div>  
	</body>
		
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			$("#buttonAddToCart").click(function(){
				window.location = 'add_to_cart?iditem=' + ${item.iditem};
			});
		});
	</script>
	</html>