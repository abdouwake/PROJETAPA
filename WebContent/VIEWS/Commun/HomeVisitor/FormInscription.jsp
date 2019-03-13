<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/VIEWS/utiles/bootstrap/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath }/VIEWS/utiles/bootstrap/js/jquery.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/VIEWS/Commun/css/inscription.css">
</head>

	<body>
		<%@ include file="navbar.jsp" %>  
	<br>
	<br>
	<div class="container">
			
	<div class="card bg-light" >
	<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Création de compte</h4>
	<p class="text-center">Des ressources à perte de vue vous attendent ! </p>
	
	
	<form method="post" action="<c:url value="/inscription"/>">
	 <!-- ********************************************************************************* -->
	<div class="form-group input-group">
		<div class="input-group-prepend">
		  
		 </div>
        <input name="username" class="form-control" placeholder="Pseudonyme" type="text"> 
        <br>
         <span class="alert alert-danger" role="alert">${erreurs['username']}</span>
    </div>
    <!-- ********************************************************************************* -->

	<div class="form-group input-group">
		<div class="input-group-prepend">
		   
		 </div>
        <input name="nom" class="form-control" placeholder="Nom" type="text"> 
        
    </div>
    <!-- ********************************************************************************* -->
    
    <div class="form-group input-group">
		<div class="input-group-prepend">
		
		 </div>
        <input name="prenom" class="form-control" placeholder="Prenom" type="text"> 
       
    </div>
    <!-- ********************************************************************************* -->
        
        
        
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		   
		 </div>
        <input name="email" class="form-control" placeholder="adresse mail" type="email">
        <br>
        <span class="alert alert-danger" role="alert">${erreurs['email']}</span>
        
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		  
		</div>
		<select name="sexe" class="form-control">
			<option selected="sexe"> Sexe </option>
			<option>Masculin</option>
			<option>Féminin</option>
		</select>
		<br>
		<span class="alert alert-danger" role="alert">${erreurs['sexe']}</span>
		
	</div> <!-- form-group end.// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		 
		</div>
        <input name="password" class="form-control" placeholder="Votre mot de passe" type="password">
         <br>
        		<span class="alert alert-danger" role="alert">${erreurs['password']}</span>
        		 
        
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    
		</div>
        <input name="confmdp" class="form-control" placeholder="Répétez votre mot de passe" type="password">
         <br>
       	<span class="alert alert-danger" role="alert">${erreurs['confmdp']}</span>
        
    </div> <!-- form-group// -->                                      
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Créer un compte !  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">Vous avez déjà un compte ? <a href="connexion.jsp">Connexion</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div>
		
		
		
		
			<%@ include file="footer.jsp" %>
		 
		</body>
	</html>