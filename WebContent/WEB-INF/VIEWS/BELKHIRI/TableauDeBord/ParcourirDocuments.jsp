

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
	 
		<div class="col-md-3" style="margin-left:70px;margin-top:60px;">		 	
			 	<form method="get" action="RechercherDocument">
				<div class="input-group">
				<div class="input-group-btn search-panel">
				</div>
				<input type="text" class="form-control" name="nom" placeholder="Nom d'un client"    >              
				</div>
				  	<div class="row" style="padding-top:5px;margin-right:0px;">
				  		<div class="col-md-6">
				  		Publier entre le : <input  type="date" name="du" style="display:inline-block; border-style: solid;border-width:1px;border-color:#c6c6c6;color:#757575;">	
				  		</div> 	
				  		<div class="col-md-6">
				  	 	Et le : <input  type="date" name="au" style="display:inline-block; border-style: solid;border-width:1px;border-color:#c6c6c6;color:#757575;">		
				  		</div>		
				  	</div>
					  	
					<button class="btn btn-primary" type="submit">Recherche</button>
					</form>
			</div>
			
		<div class="col-md-6" style="margin-top:60px;margin-left:30px;">
	  
	  	
	  		<table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr   >
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Nom du fichier</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Extension</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Action </th>
					    </tr>
					  </thead>
					  
					  <tbody>
					  
					  
					  
					   <c:forEach items="${permis}" var="permis">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td  style="width:40%;">Permis N° ${permis.getIdpermi() }</td>
					      <td  style="width:10%;">".pdf"</td>   
					       
					      <td> 
					      <div style="display:inline-block;">
					       <form method="get" action="OpenFilesParcourir"> 
					    		 <input type="text" name="url" value="${val.getUrl()}" style="display:none"> 
								 <button class="btn btn-secondary btn-sm" type="submit" > Consulter </button>
								</form>
							</div> 
					      </td>
					    </tr>
					  </c:forEach>
					  
					  
					  <c:forEach items="${affichageForms}" var="val">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td  style="width:40%;">${val.getTitre() }</td>
					      <td  style="width:10%;">.pdf</td>   
					       
					      <td> 
					      <div style="display:inline-block;">
					       <form method="get" action="OpenFilesParcourir"> 
					    		 <input type="text" name="url" value="${val.getUri()}" style="display:none"> 
								 <button class="btn btn-secondary btn-sm" type="submit" > Consulter </button>
								</form>
							</div> 
					      </td>
					    </tr>
					  </c:forEach>
					  
					  
					    <c:forEach items="${affichage}" var="val">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td  style="width:40%;">${val.getNomFichier() }</td>
					      <td  style="width:10%;">${val.getExtension() }</td>   
					       
					      <td> 
					      <div style="display:inline-block;">
					       <form method="get" action="OpenFilesParcourir"> 
					    		 <input type="text" name="url" value="${val.getURI()}" style="display:none"> 
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
		
		

<%@ include file="footerDash.jsp" %>
</body>
</html>