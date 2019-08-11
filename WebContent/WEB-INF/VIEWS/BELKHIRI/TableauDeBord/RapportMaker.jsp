

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestionnaire des permis</title>
	<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/jquery/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/faq.css">
 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/dash.css">
 
 
</head>
<body>
<%@ include file="NavbarTab.jsp" %>  

		<div class="container-fluid" style="background-color:#E3E3E3;">
		<div class="row" >
		
 		<div class="col-md-2" style="background-color:#3A1F35;min-height:650px;padding-left:0px;padding-right:0px;">
      
        <%@ include file="aside.jsp" %>  
		</div>
	 
		
		<div class="col-md-10" style="margin-bottom:50px;">
		<br><br>
		<div class="row" > 
			<div class="col-md-5" >
			
			<form method="get" action="PrintReport" >  
			 
			 <div class="form-group" style="margin-top:35px;">
    				<select name="type" class="browser-default custom-select">
					  <option selected>Type de rapport </option>
					  <option value="1">Tous les permis</option>
					  <option value="2">Les permis révoqués</option>
					  <option value="3">Les permis actifs</option>
					  
					</select>
					</div>
					 <button class="btn btn-primary" type="submit" style="float:right;">Imprimer</button>
					
				</form>
			</div>
			
			<div class="col-md-4" style="margin-top:5px;">
			<h5>Modèle de rapport actuel : </h5>
			<img  src="${pageContext.request.contextPath }/images/modelepermis.jpg" src="" height="550" width="400">
			</div>
				 
			</div>

		</div>
		
		</div>
		</div>
		
		

<%@ include file="footerDash.jsp" %>
</body>
</html>