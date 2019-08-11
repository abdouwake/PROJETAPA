

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
	 
		
		<div class="col-md-10">
		<br><br>
				 
			

		</div>
		
		</div>
		</div>
		
		

<%@ include file="footerDash.jsp" %>
</body>
</html>