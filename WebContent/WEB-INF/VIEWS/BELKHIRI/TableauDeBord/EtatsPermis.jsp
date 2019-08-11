 

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
		
		<div class="col-md-2" style="margin-top:50px;margin-left:50px;">
		<div class="input-group" style="width:100%;">
		
				<form method="get" action="ChercherPermis"> 
					<div class="input-group">
					<div class="input-group-btn search-panel">
					</div>
					
					<div style="margin-bottom:15px;">
					<input type="text" class="form-control" name="idpermi" placeholder="Numero du permi">    
					</div>
					<div style="margin-bottom:15px;">
 					<input type="text" class="form-control" name="nom" placeholder="Nom du client">              
 					</div>
 					<div style="margin-bottom:15px;">
 					<input type="text" class="form-control" name="prenom" placeholder="Prenom du client">              
 					</div>
 					
 					<div class="form-group" style="width:85%;style="margin-bottom:15px;"">
    					<select name="etat" class="browser-default custom-select">
					  <option selected>Etat du permi</option>
					  <option value="tous">Tous</option>
					  <option value="true">Actif</option>
					  <option value="false">Révoqué</option>
					  
					</select>
					</div>         
 					         
					</div>
					<button class="btn btn-primary" type="submit" style="margin-left:0px;">Recherche</button>	
				</form>	
				</div>	 
		</div>
		<div class="col-md-6">
		<br><br>
				 
			 <table class="table table-hover" >
					  <thead class="thead-dark " >
					    <tr>
 					      <th scope="col" style="text-align:center;background-color: #3A1F35;">N° Permi </th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Nom </th>
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Prenom </th>		
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Consulter </th>				      
					      <th scope="col" style="text-align:center;background-color: #3A1F35"> Action </th>				      
					      		      
					    </tr>
					  </thead>
					  
					  <tbody>
					  <c:forEach items="${affichage}" var="val">	 
					    <tr>
					      <td  style="width:40%;">${val.getIdpermi() }</td>	
					      <td  style="width:20%;">${val.getNomuser() }</td>	
					      <td  style="width:20%;">${val.getPrenomuser() }</td>					     
					      				     
					      <td   > 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="OpenFilesEtatsPermis"> 
					    		 <input type="text" name="url" value="${val.getUrl()}" style="display:none"> 
 					    		 <button class="btn btn-secondary btn-sm" type="submit" style="text-align:center;background-color:orange;border:none;"> Ouvrir </button>
							</form>
							</div> 
					      </td>
					      
					      <c:if test="${val.isEtat() == true }">
					       <td  > 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="Revoquer"> 
					    		 <input type="text" name="idpermi" value="${val.getIdpermi()}" style="display:none"> 
 					    		 <button class="btn btn-secondary btn-sm" type="submit" style="text-align:center;background-color:red;border:none;"> Révoquer </button>
							</form>
							</div> 
					      </td>
					      </c:if>
					      
					      <c:if test="${val.isEtat() == false}">
					       <td  > 
					      <div style="right:0px;top:0px;">
					       <form method="get" action="Reactiver"> 
					    		 <input type="text" name="idpermi" value="${val.getIdpermi()}" style="display:none"> 
 					    		 <button class="btn btn-secondary btn-sm" type="submit" style="text-align:center;background-color:green;border:none;"> Réactiver </button>
							</form>
							</div> 
					      </td>
					      </c:if>
					      
					      
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