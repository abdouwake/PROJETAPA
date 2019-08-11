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
	   	 <div class="col-md-6" style="margin-top:10px;margin-left:50px;">
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
				
				
 				<form method="get" action="Noter" > 
				 <input type="text" name="note" placeholder="Votre note /20"> 
	    		 <input type="text" name="id" value="${numero}" style="display:none"> 
	    		 <input type="text" name="idDemande" value="${demande.getIddemande() }" style="display:none"> 
 	    		 <button class="btn btn-secondary btn-sm" type="submit" style="background-color:green;border:none;"> Noter ! </button>
				</form>
 				</div>
	   	
	   	
	   	
	   
		
		
		</div>
		</div>
		
		

<%@ include file="../Commun/footer.jsp" %>
</body>
</html>