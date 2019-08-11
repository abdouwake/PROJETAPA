

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tableau de bord</title>
	<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/jquery/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/faq.css">
 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/dash.css">
 
 
</head>
<body>
<%@ include file="../NavbarTab.jsp" %>  

		<div class="container-fluid" style="background-color:#E3E3E3;">
		<div class="row" >
		
 		<div class="col-md-2" style="background-color:#3A1F35;min-height:650px;padding-left:0px;padding-right:0px;">
      
        <%@ include file="../aside.jsp" %>  
		</div>
	 
		
				<div class="col-md-10">
				<br><br>
					<div class="container-fluid">
			   <div class="row"  >
			   <div class="col-md-4" style="padding-left:80px;"> 
			    
			    <%@ include file="loiSearchBarre.jsp" %>  
	    	
	    	
				<a href="${pageContext.request.contextPath }/GetDashLoi" class="btn btn-outline-secondary"  style="background-color:#3A1F35;color:white;">Parcourir la loi Algérienne</a>
				<br>
				<a href="${pageContext.request.contextPath }/GetDashArchive" class="btn btn-outline-secondary">Archives de la loi algérienne</a>
	
				<script  src="${pageContext.request.contextPath }/css/datepikerjs.js"></script>
			   	</div>
   				 <div class="col-md-8" style="padding-left:40px;">
		   		 <div class="container" >
			  		<div class="card bg-light" style="width:700px;">
			  		
			  		<c:if test="${ message !=null }">
					    <div class="alert alert-success" role="alert">
						 ${message }
						</div>	
					</c:if>
					
	          		<%@ include file="AjouterUneLoi.jsp" %>  
  			  		
  			  		<c:forEach items="${affichage}" var="val">	
 			  		  	<jsp:include page="cardFichier.jsp">
 			  		  			  <jsp:param name="source" 			value="${val.getSource()} "/>
 								  <jsp:param name="titre"		 	value="${val.getNomFichier()}"/>
								  <jsp:param name="description" 	value="${val.getDescriptionFr()}"/>
								  <jsp:param name="date"			value="${val.getDate()}"/>
								  <jsp:param name="url"				value="${val.getURL()}"/>
								  <jsp:param name="id" 				value="${val.getID_Fichier()}"/>
						</jsp:include>
						 
			  		</c:forEach>
  			  		
					
 			  		 
			  		
			  		</div>
	             </div>
	             </div>
	             
	             
	             </div>
	             </div>
			

		</div>
		
		</div>
		</div>
		
		

<%@ include file="../footerDash.jsp" %>
</body>
</html>