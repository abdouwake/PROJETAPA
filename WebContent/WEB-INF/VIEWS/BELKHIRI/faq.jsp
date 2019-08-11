<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>FAQ</title>

	<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/jquery/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/faq.css">
 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
</head>
<body>
 <%@ include file="../Commun/HomeMember/NavbarMember.jsp" %>  
<br> <br>
	   <div class="container ">
	   <div class="row">
	   <div class="col-md-4"> 
	    	   	    <%@ include file="faqMenu.jsp" %>  
	    	   
	    
  		
				
   		</div>
   		
   		
			   <div class="col-md-8" >
		   		 <div class="container" >
				 <div class="card bg-light" style="width:700px;">
	             <div>
 	         		<a href="${pageContext.request.contextPath }/GetFaqPage" class="btn btn-secondary btn-sm">Tout Afficher</a>
	         		<a href="${pageContext.request.contextPath }/GetFaqPageWithAnswers" class="btn btn-secondary btn-sm">N'afficher que les questions qui ont des réponses</a>
	          
	          		<%@ include file="poserQuestion.jsp" %>  
	          		
	          		<c:if test="${ aucunprob }">
					    <div class="alert alert-success" role="alert">
						 Votre Question a été envoyée, elle sera visible après une validation de la part d'un modérateur.
						</div>	
					</c:if>
	          		
					 
					      		
	          		<br>
	          		
	          		<!-- Affichage des questions ici -->
	          		
		          		<c:forEach items="${affichage}" var="tab">
		          		
		          		<c:set var="val" value="${ tab}"/>
						<% String type = pageContext.getAttribute("val").getClass().getSimpleName(); %>
		          		<c:set var="type" value="<%= type %>"/>
		          		
		          		<c:choose>
  							<c:when test="${type eq 'Question' }">
  							
							<jsp:include page="question.jsp">
								  <jsp:param name="titre" value="${val.getTitre()}"/>
								   <jsp:param name="contenu" value="${val.getContenu()}"/>
								    <jsp:param name="date" value="${val.getDate()}"/>
								     <jsp:param name="id" value="${val.getId()}"/>
								      <jsp:param name="username" value="${val.getUsername()}"/>        
							</jsp:include>
						
  							</c:when>
  							
  							<c:when test="${type eq 'Reponse' }">
  							 <div>
								<jsp:include page="Reponses.jsp">
					            <jsp:param name="username" value="${val.getUsername()}"/>
					            <jsp:param name="contenu" value="${val.getContenu() }"/>
					            <jsp:param name="date" value="${val.getDate() }"/>
			       				</jsp:include>
									</div>
  							</c:when>
  							</c:choose>
		          			 	
		          		
		          			
		          			
					   	</c:forEach> 
					   
	          		       
	             		           
	             	 <!-- Fin de l'affichage des questions -->
	             </div>
	             </div>
	             </div>
	             </div>
	             </div>
	            
	            
	             </div>
	             


   	   	
<%@ include file="../Commun/footer.jsp" %>
</body>
</html>