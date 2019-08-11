  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Consulter</title>

	<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/jquery/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/faq.css">
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/approval.css">
	
 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
</head>
<body>
 <%@ include file="../../Commun/HomeMember/NavbarMember.jsp" %>  
<br> <br>

 <div class="container" >
	   <div class="row">
	   <div class="col-md-4"> 
		<a href="${pageContext.request.contextPath }/GetInformationPermis" class="btn btn-outline-secondary">à propos du permis</a>
		<br>
		<a href="${pageContext.request.contextPath }/GetDemandePermis" class="btn btn-outline-secondary" >Demander un permis</a>
		<br>
		<a href="${pageContext.request.contextPath }/GetConsulterPermis" class="btn btn-outline-secondary" style="background-color:#3A1F35;color:white;" >Consulter l'état de ma demande</a>
		 <br>
		<a href="${pageContext.request.contextPath }/GetAfficherPermis" class="btn btn-outline-secondary"  >Afficher mes permis</a>
		</div>
		
		 <div class="col-md-7" style="margin-left:30px;">
		 				     <c:set var="number" value="1"/>
		 <h3>Ma demande de permis : </h3>
		 <div class="container">
  		<br>
  		
  		 
  		<br>
  		<c:if test="${workflow == null }">
  		<div class="alert alert-success" role="alert">
		Vous n'avez aucune demande en cours de traitement.
		</div>
  		</c:if>
  		
  		
  		
  							<c:if test="${  message_end1 != null }">
								<div class="alert alert-success" role="alert">
								${ message_end1}
								</div>
							</c:if>
							
							<br>
							<br>
	
	<c:choose>
	 			<c:when test="${workflow.isEncours() == false }">
	 
	
						 <div class="row">   		
					        <div class="col-md-5 approver-tenant"   >
					            <h3 class="approver-num text-center">En attente</h3>
					        </div>   
					        <div class="col-md-5 workflow-person">
					            <h4 class="mtop-30 text-center"> Approbation  </h4>
					            <div class="mtop-10 text-center">
					                <span class="">Votre demande est</span> <br>
					                <span class=""><b>En cours de traitement </b> </span>
					             </div>
					        </div>   
					        
						</div>
	 			<br><br>
	 				 </c:when>
	 				 
	 			<c:when test="${workflow.isEncours() == true }">
	 			
	 			<div class="row">   		
					        <div class="col-md-5 approver-sprovider">
					            <h3 class="approver-num text-center">Approuvée !</h3>
					        </div>   
					        <div class="col-md-5 workflow-person">
					            <h4 class="mtop-30 text-center"> Approbation </h4>
					            <div class="mtop-10 text-center">
					                <span class="">Votre demande est</span> <br>
					                <span class=""><b>Approuvée !</b> </span>
					             </div>
					        </div>   
					        
						</div>
						<br> <br>
						<c:forEach items="${workflow.getSteps() }" var="item">	 
							<c:choose>
							
							<c:when test="${ item.isDone() eq false}">
									<div class="row">   		
							        <div class="col-md-5 approver-sprovider">
							            <h3 class="approver-num text-center">${item.getNote() } /20</h3>
							        </div>
							        <div class="col-md-5 workflow-person">
							            <h4 class="mtop-30 text-center"> ${item.getNom() }</h4>
							            <div class="mtop-10 text-center">
							                <span class="">${item.getRole() }</span> <br>
							                <span class=""> Coeffiscient : <b>${item.getCoeffiscient() } </b> </span>
							             </div>
							        </div>   
							        
									</div>
									
									</c:when>
									
									
								<c:when test="${item.isDone() eq true}"> <!-- En attente -->
									<div class="row">   		
							        <div class="col-md-5 approver-tenant" >
							            <h3 class="approver-num text-center">?/20</h3>
							        </div>   
							        <div class="col-md-5 workflow-person">
							            <h4 class="mtop-30 text-center"> ${item.getNom() }</h4>
							            <div class="mtop-10 text-center">
							                <span class="">${item.getRole() }</span> <br>
							                <span class=""> Coeffiscient : <b>${item.getCoeffiscient() } </b> </span>
							             </div>
							        </div>   
							        
									</div>
									
								
									</c:when>
									
								
									
							</c:choose>
							<br><br>
							</c:forEach>
	 						
	 						
				
				
				<c:choose>
					<c:when test="${message_end2 != null }">
						<h4>	${message_end2}</h4> 
					</c:when>
				<c:when test="${message_end2 == null }">
				<h4> Votre note actuelle est de : ${ workflow.getNote()} /20 </h4> 
				
				</c:when>
				
				</c:choose>
				
	 			</c:when>
	 			
	 </c:choose>
	 
	 <c:if test="${workflow != null }">
	     <h5>Pour avoir le permis, il vous faut au minimum une note de <c:out value="${workflow.getNotemine() }"/> /20 </h5>	 
	 </c:if>
    
	 <br>
				<c:if test="${  message_end3 != null}">
						<div class="alert alert-danger" role="alert">
						${message_end3}
						</div>
			 	</c:if>
		 <br>
					<c:if test="${   message_end4 != null }">
					<div class="alert alert-success" role="alert">
						 ${message_end4} 
						 <br>
						 Vous pouvez le consulter à tout moment au niveau de la page "Afficher mes permis"  
					</div>
					</c:if>
  <br>
   <br>
</div>
		 
		 
		 </div> 
		 
		 
		 </div>
		  </div>
  		 
 <%@ include file="../../Commun/footer.jsp" %>
</body>
</html>
 