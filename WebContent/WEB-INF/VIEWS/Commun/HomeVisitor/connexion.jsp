<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/bootstrap/js/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/inscription.css">	
</head>
<body>


<%@ include file="../HomeVisitor/NavbarVisitor.jsp" %>  
<br>
<br>

<div class="container">
			
	<div class="card bg-light" >
	<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Connectez vous ! </h4>
	<p class="text-center">Des ressources à perte de vue vous attendent ! </p>
	
	
	<form method="get" action="connexion" width=100% align=center>
	
	 <!-- ********************************************************************************* -->
	<div class="form-group input-group">
		<div class="input-group-prepend">
		   
		 </div>
		 <div>
		 
		 </div>
        <input name="username" class="form-control" placeholder="Pseudonyme" type="text" > 
    </div>
     <c:if test="${ form.erreur['username'] !=null }">
		<span class="alert alert-danger" role="alert">${form.erreur['username']}</span>
		</c:if>
        <!-- ********************************************************************************* -->
    
    	<div class="form-group input-group">
		<div class="input-group-prepend">
		 </div>
        <input name="password" class="form-control" placeholder="Mot de passe" type="password"> 
    </div>
     <c:if test="${ form.erreur['password'] !=null }">
		<span class="alert alert-danger" role="alert">${form.erreur['password']}</span>
		</c:if>
		
		<c:if test="${ form.erreur['complet'] !=null }">
		<br>
		<span class="alert alert-danger" role="alert">${form.erreur['complet']}</span>
		<br>
		<br>
		</c:if>
    <!-- ********************************************************************************* -->

  

    
                                     
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Connexion  </button>
    </div>     
    <p class="text-center">Vous avez déjà un compte ? <a href="FormInscription.jsp">Inscrivez vous !</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div>
</div>
		
		
		
		<%@ include file="../footer.jsp" %>
</body>
</html>