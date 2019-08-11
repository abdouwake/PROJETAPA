 

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
<%@ include file="NavbarTab.jsp" %>  

		<div class="container-fluid" style="background-color:#E3E3E3;">
		<div class="row" >
		
 		<div class="col-md-2" style="background-color:#3A1F35;min-height:650px;padding-left:0px;padding-right:0px;">
      
              <%@ include file="aside.jsp" %>  

		</div>
	 
		
				<div class="col-md-10">
				<br><br>
				
				<div class="row">
				
				<div class="col-md-5">
				
				<h5 style="text-align:center;">Questions à Valider</h5><br>	
				<table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Utilisateur</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Question</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Action </th>
					    </tr>
					  </thead>	
					  
					  <tbody>
					  <c:forEach items="${Questions}" var="question">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td  style="width:30%;">${question.getUsername() }</td>
					      <td  style="width:60%;">${question.getContenu() }</td>   
					    
					    <td >
					      
					      <div style="display:inline-block;">
				      
					       <form method=post action="ValiderQuestion" > 
					    		 <input type="text" name="idquestionValider" value="${question.getId()}" style="display:none"> 	
 								 <button class="btn btn-secondary btn-sm" type="submit" style="background:none;border:none;" > <img alt="infos" src="${pageContext.request.contextPath }/images/oui.png" height="20" width="20"/> </button>								  
							</form>
							
							<form method=post action="SupprimerQuestion"> 
					    		 <input type="text" name="idquestionSupprimer" value="${question.getId()}" style="display:none"> 					    		 
								 <button class="btn btn-secondary btn-sm" type="submit" style="background:none;border:none;"> <img alt="infos" src="${pageContext.request.contextPath }/images/no.png" height="20" width="20"/> </button>  
								</form>
							</div> 
							
							
					      
					      </td>
					      
					    </tr>
					  </c:forEach>
					  </tbody>
					  				 
				 </table>
					
					
					   
				</div>
				
				<div class="col-md-7">
				<h5 style="text-align:center;">Réponses à Valider</h5>	 <br>			
				<table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Utilisateur</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Questions</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;"> Réponses </th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;"> Action </th>					      
					    </tr>
					  </thead>	
					  	
					  <tbody>
					  <c:forEach items="${Reponses}" var="reponse">	 
					    <tr>
					      <th scope="row" >1</th>
					        
					      <td  style="width:10%;">${reponse.getUsername() }</td>
					        
					      <td  style="width:40%;">${reponse.getContenuquestion() }</td>   
					       
					      <td  style="width:40%;">${reponse.getContenu() }</td>   
					      <td >
					      
					      <div style="display:inline-block;">
					      
					      
					       <form method=post action="ValiderReponse"> 
					    		 <input type="text" name="idreponseValider" value="${reponse.getIdreponse()}" style="display:none">     					    		 
								 <button class="btn btn-secondary btn-sm" type="submit" style="background:none;border:none;" > <img alt="infos" src="${pageContext.request.contextPath }/images/oui.png" height="20" width="20"/> </button>								  
							</form>
							
							<form method=post action="SupprimerReponse" > 
					    		 <input type="text" name="idreponseSupprimer" value="${reponse.getIdreponse()}" style="display:none"> 					    		 
								 <button class="btn btn-secondary btn-sm" type="submit" style="background:none;border:none;"> <img alt="infos" src="${pageContext.request.contextPath }/images/no.png" height="20" width="20"/> </button>  
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
		</div>
		
		

<%@ include file="footerDash.jsp" %>
</body>
</html>
 
 
  
 
    