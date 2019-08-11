 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Mes permis</title>

	<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/jquery/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/faq.css">
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
		<a href="${pageContext.request.contextPath }/GetConsulterPermis" class="btn btn-outline-secondary"  >Consulter l'état de ma demande</a>
		 <br>
		<a href="${pageContext.request.contextPath }/GetAfficherPermis" class="btn btn-outline-secondary" style="background-color:#3A1F35;color:white;" >Afficher mes permis</a>
		</div>
		
		 <div class="col-md-8">
 		
 			<div class="container" >
 			
 			
 			<table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Nature</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Etat</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Du</th>
 						 <th scope="col" style="text-align:center;background-color: #3A1F35;">Au</th>
					      
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Action </th>
					    </tr>
					  </thead>
					  
					  <tbody>
					  <c:forEach items="${affichage}" var="val">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td  style="width:30%;">${val.getNature() }</td>
					      <td  style="width:10%;"> 
					      	<c:if test="${val.isEtat()==true }">
					      		Actif
					      	</c:if>
					      	<c:if test="${val.isEtat()==false }">
					      		Révoqué 
					      	</c:if>
					      
					      </td>   
					      <td  style="width:40%;">${val.getFrom() }</td>   
					      <td  style="width:40%;">${val.getTo() }</td>   
					       
					      <td> 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="afficherPdfPermi"> 
					    		 <input type="text" name="url" value="${val.getUrl()}" style="display:none"> 
					    		 <input type="text" name="pageName" value="/AfficherPermis.jsp" style="display:none"> 					    		 					    		 
								 <button class="btn btn-secondary btn-sm" type="submit" > Consulter </button>								  
								</form>
							</div> 
					      </td>
					    </tr>
					  </c:forEach>
					  </tbody>
					</table>
					
					
					
 			</div>
 		</div>
 		
 		</div>
 	</div>
 	
 <%@ include file="../../Commun/footer.jsp" %>
</body>
</html>
 