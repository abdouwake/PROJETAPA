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
<br> 

 <div class="container">
	   <div class="row">
	   	<div class="col-md-6"  style="margin-top:50px;border-style:groove;min-height:300px;padding-right:0px;margin-bottom:100px;margin-left:50px;margin-right:50px;">
			<br>
			<h5 style="text-align:center;">Modele du workflow actuel</h5>
				
				<c:choose>
				  <c:when test="${empty modele}">
				  <div style="text-align: center;margin-bottom:0px;">
				  <img alt="Aucun modele trouver"  src="${pageContext.request.contextPath }/images/notfound.png" style="position:center;width:500px;height:200px;">
				  </div>
				  <form method="get" action="GetCreerModelePage">	
				  <button  class="btn btn-secondary btn-sm" type="submit" style="float:right;float:bottom;">Ajouter un nouveau modèle de workflow</button>
				  </form>
				  </c:when>
				  
				  <c:when test="${!empty modele}">
				     
				     <h4 style="text-align:center;margin-top:20px;margin-bottom:30px;">Note min : ${modele.getNotemin() } /20</h4>
				     <c:set var="number" value="1"/>				     
 					  <c:forEach items="${modele.getEtape() }" var="item">	 				  
 					  <div class="container">
	<div class="row">
    
        <div class="col-md-5 approver-sprovider">
            <h3 class="approver-num text-center">${number }</h3>
        </div>   
        <div class="col-md-5 workflow-person">
            <h4 class="mtop-30 text-center"> ${item.getNom() }</h4>
            <div class="mtop-10 text-center">
                <span class="">${item.getRole() }</span><br>
                <span class=""> Coeffiscient : <b>${item.getCoef() } </b></span>
                
            </div>
        </div>   
        
	</div>
	<c:set var="number" value="${number +1 }"/>
	
  <br><br>
</div>
	  
		 </c:forEach>
				
					  </c:when>
					  </c:choose>
  				</div>
	 
		
		<div class="col-md-4">
		<br><br>
				 
				<c:if test="${!empty message }">
				<div class="alert alert-success" role="alert">
					"${message }"
				</div>
				
				</c:if>
				
				<c:if test="${empty etapes }">
					<div class="alert alert-dark" role="alert">
					  Vous n'avez aucune tâche à valider pour le moment.
					</div>
				
				</c:if>
		<table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr   >
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Nom</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Coeffiscient</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Action </th>
					    </tr>
					  </thead>
					  
					  <tbody>
					  <c:forEach items="${etapes}" var="val">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td  style="width:30%;">${val.getNom() }</td>
					      <td  style="width:60%;">${val.getCoeffiscient() }</td>   
					       
					      <td> 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="GetNoterPage"> 
					    		 <input type="text" name="idetape" value="${val.getIdetape()}" style="display:none"> 
 					    		 <input type="text" name="idworkflow" value="${val.getIdworkflow()}" style="display:none"> 
 					    		 <input type="text" name="iduser" value="${val.getIduser()}" style="display:none"> 	 
 					    		 <input type="text" name="idDemande" value="${val.getIddemande()}" style="display:none"> 	 
								 <button class="btn btn-secondary btn-sm" type="submit" > Noter </button>
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