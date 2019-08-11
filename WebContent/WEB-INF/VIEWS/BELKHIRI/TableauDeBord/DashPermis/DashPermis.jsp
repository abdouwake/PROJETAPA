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
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/approval.css">
	
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
				 
			<div class="row">
			
			
			<div class="col-md-6"  style="border-style:groove;min-height:300px;padding-right:0px;margin-bottom:100px;margin-left:50px">
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
				     
				     Note min : ${modele.getNotemin() }
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
						
 										<form method="get" action="GetCreerModelePage">	
				  <button  class="btn btn-secondary btn-sm" type="submit" style="float:right;float:bottom;">Ajouter un nouveau modèle de workflow</button>
				  </form>			
					  </c:when>
					  </c:choose>
  				</div>
			  
    			 
    			 <div class="col-md-5" style="margin-left:50px;"> 
    			 <h4 style="text-align:center;margin-bottom:40px;"> Nouvelles demandes de permis en attente</h4>
    			 
    			  <table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;" >#</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Titre</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Consulter </th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Démarer workflow </th>				      
					    </tr>
					  </thead>
					  
					  <tbody>
					  <c:forEach items="${affichage}" var="val">	 
					    <tr>
					      <th scope="row" >1</th>
					      <td  style="width:30%;">${val.getTitre() }</td>	
					      				     
					      <td   > 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="GetFichiersDemandePage"> 
					    		 <input type="text" name="idDemande" value="${val.getIddemande()}" style="display:none"> 
 					    		 <button class="btn btn-secondary btn-sm" type="submit" style="text-align:center;background-color:orange;border:none;"> Consulter </button>
							</form>
							</div> 
					      </td>
					      
					       <td  > 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="GetDemarerWorkflowPage"> 
					    		 <input type="text" name="idDemande" value="${val.getIddemande()}" style="display:none"> 
 					    		 <button class="btn btn-secondary btn-sm" type="submit" style="text-align:center;background-color:green;border:none;"> Démarer workflow </button>
							</form>
							</div> 
					      </td>
					      
					      
					    </tr>
					  </c:forEach>
					  </tbody>
					  
				  </table>
				</div>
				
			</div>
			
			<br><br>
			</div>

		</div>
		
		</div>
		</div>
		
		

<%@ include file="../footerDash.jsp" %>
</body>
</html>