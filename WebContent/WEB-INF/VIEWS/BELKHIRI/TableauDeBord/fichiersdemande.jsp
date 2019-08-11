

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
 				
				<div class="col-md-3" style=margin-top:10px;margin-left:50px;>
			 		<h4 style="margin-top:50px;margin-left:50px;">Demande N° : ${numero }</h4>
					 <h5  style=" margin-left:50px;margin-bottom:30px;">Fichiers joints à cette demande</h5>
					 <table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr>
 					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Document</th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35;">Action</th>
					      			      
					    </tr>
					  </thead>
					  
					  <tbody>
					  <td> Demande officielle</td>
					  
					  <td> 
					  <form method="get" action="ConsulterFichiersDemande"> 
				    		 <input type="text" name="uri" value="${demande.getUri() }" style="display:none"> 
				    		 <input type="text" name="idDemande" value="${demande.getIddemande()}" style="display:none"> 					    		 
					    	 <button class="btn btn-secondary btn-sm" type="submit" style="float:right;background-color:orange;border:none;"> Consulter </button>
					  </form>					  
					  </td>
					  
					  <c:forEach items="${affichage}" var="val">	 
					    <tr>
 					      <td  style="width:80%;">${val.getNomFichier() }</td>						      				     
					      <td  style="width:20%;" > 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="ConsulterFichiersDemande"> 
					    		 <input type="text" name="uri" value="${val.getURI()}" style="display:none"> 
					    		 <input type="text" name="idDemande" value="${val.getIdDemande()}" style="display:none"> 		
					    		 			    		 
 					    		 <button class="btn btn-secondary btn-sm" type="submit" style="float:right;background-color:orange;border:none;"> Consulter </button>
							</form>
							</div> 
					      </td>					      
					    </tr>
					  </c:forEach>
					  </tbody>
					  
				  </table>
				
				
				<form method="get" action="GetDemarerWorkflowPage"> 
	    		 <input type="text" name="id" value="${numero}" style="display:none"> 
	    		 <input type="text" name="idDemande" value="${demande.getIddemande() }" style="display:none"> 
 	    		 <button class="btn btn-secondary btn-sm" type="submit" style="background-color:green;border:none;"> Démarer le workflow ! </button>
				</form>
				
				</div>
				
				
 				
		</div>
		
		</div>
		 
		
		

<%@ include file="footerDash.jsp" %>
</body>
</html>