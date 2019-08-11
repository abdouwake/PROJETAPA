<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/jquery/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/faq.css">
 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  
<meta charset="UTF-8">
<title>Loi Algerienne</title>
</head>
<body>
 <%@ include file="../Commun/HomeMember/NavbarMember.jsp" %>  
<br> <br>

 <div class="container">
	   <div class="row">
	   <div class="col-md-4"> 
	    
	    
	    	<jsp:include page="loiSearchBarre.jsp">
 			 <jsp:param name="archiver" value="false"/>
 			  </jsp:include>	  			  
	    	
   		</div>
   				 <div class="col-md-8" >
		   		 <div class="container" >
			  		<div class="card bg-light" style="width:700px;">
			  		
			  		
					
   			  		
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
			  		<br><br>
	             </div>
	             </div>
	             
	             
	             </div>
	             </div>
	            
	            
	            




<%@ include file="../Commun/footer.jsp" %>
</body>
</html>