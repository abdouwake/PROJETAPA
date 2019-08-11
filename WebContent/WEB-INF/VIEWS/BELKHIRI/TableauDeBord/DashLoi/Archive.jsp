 

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
				 <div class="container ">
	   <div class="row">
	   <div class="col-md-4"> 
	    	   	    <%@ include file="archivesMenu.jsp" %>  
	    	   </div>
	    	   
	    	   <div class="col-md-8" >
		   		 <div class="container" >
				 <div class="card bg-light" style="width:700px;">
	
					<c:if test="${ !empty message }">
					    <div class="alert alert-success" role="alert">
						 Votre Fichier a été Archiver avec succès ! 
						</div>	
					</c:if>
					
 			  		  <table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr   >
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Intitulé</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Description</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Action </th>
					    </tr>
					  </thead>
					  
					  <tbody>
					  <c:forEach items="${affichage}" var="val">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td  style="width:30%;">${val.getNomFichier() }</td>
					      <td  style="width:60%;">${val.getDescriptionFr() }</td>   
					       
					      <td> 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="OpenFilesArchives"> 
					    		 <input type="text" name="url" value="${val.getURL()}" style="display:none"> 
					    		 <input type="text" name="pageName" value="/Archive.jsp" style="display:none"> 
					    		 
					    		 
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
					</div>
					
					
				 
			

		</div>
		
		</div>
		</div>
		
		

<%@ include file="../footerDash.jsp" %>
</body>
</html>
 
 
  
 
    