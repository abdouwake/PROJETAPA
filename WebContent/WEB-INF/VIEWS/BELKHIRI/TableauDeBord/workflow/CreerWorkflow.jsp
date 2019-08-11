

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
<%@ include file="../NavbarTab.jsp" %>  

		<div class="container-fluid" style="background-color:#E3E3E3;">
		<div class="row" >
		
 		<div class="col-md-2" style="background-color:#3A1F35;min-height:650px;padding-left:0px;padding-right:0px;">
      
        <%@ include file="../aside.jsp" %>  
		</div>
	 
		
		<div class="col-md-10">
		<br><br>
				 <div class="col-md-3">
				 
				 
				 </div>
			
				
				<div class="col-md-8" style="margin-left:50px;">
					<form method="get" action="DemarerWorkflow"> 
					 <table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr   >
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Nom</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Discipline</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Coeffiscient </th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Acteur </th>					      
					    </tr>
					  </thead>
					  					  
					  <tbody>
					  <c:forEach var="i" begin="0" end="${ modele.getNbsteps()-1 }" step="1">		
					  			  
					    <tr>					    
					      <th scope="row" ><c:out value="${i }"/> </th>					      
					      <td>	${ etapes.get(i).getNom()  }  </td>
					      <td>	${ etapes.get(i).getRole() }  </td>   
					      <td style="width:20px;">	${ etapes.get(i).getCoef() } </td>   
					      
						  
						  <td>   <input type="text" name="input" style="float:right;">	</td>    
						  </tr>
						  </c:forEach>
						  </tbody>
						  </table>		
						 
				     <input type="text" name="idDemande" value="${ idDemande}" style="display:none;"> 
				     <input type="text" name="idmodele" value="${modele.getIdmodele()}" style="display:none;"> 				   
					 <button class="btn btn-secondary btn-sm" type="submit" > Démarer le workflow </button>	
					 </form>					
				</div>
		</div>
		
		</div>
		</div>
		
		

<%@ include file="../footerDash.jsp" %>
</body>
</html>