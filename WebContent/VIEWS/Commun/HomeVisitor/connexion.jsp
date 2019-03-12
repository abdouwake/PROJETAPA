<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/VIEWS/utiles/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/VIEWS/Commun/css/connexion.css">
	<script src="${pageContext.request.contextPath }/VIEWS/utiles/bootstrap/js/jquery.min.js"></script>
	
</head>
<body>


<%@ include file="navbar.jsp" %>  
<br>
<br>

<div class="container">
			
	<div class="card bg-light" >
	<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Connectez vous ! </h4>
	<p class="text-center">Des ressources à perte de vue vous attendent ! </p>
	
	
	<form method="get" action="Connexion" width=100% align=center>
	
	 <!-- ********************************************************************************* -->
	<div class="form-group input-group">
		<div class="input-group-prepend">
		  
		 </div>
        <input name="username" class="form-control" placeholder="Pseudonyme" type="text"> 
    </div>
        <!-- ********************************************************************************* -->
    
    	<div class="form-group input-group">
		<div class="input-group-prepend">
		 </div>
        <input name="password" class="form-control" placeholder="Mot de passe" type="password"> 
    </div>
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
		
		
		
		<%@ include file="footer.jsp" %>
</body>
</html>