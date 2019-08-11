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
  	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/approval.css">
  
<meta charset="UTF-8">
<title>Mes workflows</title>
</head>
<body>
 <%@ include file="../Commun/HomeMember/NavbarMember.jsp" %>  
<br> <br><br>

 <div class="container">
	   <div class="row">
	   	<div class="col-md-8"   style="margin-left:200px;">
			
  	
				<c:if test="${!empty message }">
				<div class="alert alert-success" role="alert">
					"${message }"
				</div>
				</c:if>
			
			 <table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr   >
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Intitulé</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Nom</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Prenom </th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Action </th>
					      
					    </tr>
					  </thead>
					  
					  <tbody>
					  <c:forEach items="${affichage}" var="val">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td   >${val.getTitre() }</td>
					      <td   >${val.getNom() }</td>   
       				      <td >${val.getPrenom() }</td>   
					       
					      <td> 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="GetFormDelivrer"> 
					    		 <input type="text" name="iddemande" value="${val.getIddemande()}" style="display:none"> 
					    		 <input type="text" name="iduser" value="${val.getIduser()}" style="display:none"> 
					    		 <input type="text" name="nature" value="${val.getNature()}" style="display:none"> 
					    		 <input type="text" name="but" value="${val.getBut()}" style="display:none"> 
								 <button class="btn btn-secondary btn-sm" type="submit" > Délivrer </button>  
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
		
		

<%@ include file="../Commun/footer.jsp" %>
</body>
</html>