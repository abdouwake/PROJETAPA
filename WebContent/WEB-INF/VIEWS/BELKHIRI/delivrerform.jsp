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
<br> <br><br>

 <div class="container">
	   <div class="row">
	   	<div class="col-md-8"   style="margin-left:200px;">
			
  			<div class="container" >
 			 <div style="padding-top:10px;"> 
				 <div class="card bg-light" id="cardib" style="background-color:#F9F5F5;width:700px;padding-top:50px;padding-right:50px;padding-left:50px;padding-bottom:50px;">
						<div> <h4    style="text-align:center;color:#3A1F35;"> Procédure de délivrance du permis de la demande N°${iddemande } </h4> </div>
						 <br><br>
				<form method="get" action="DélivrerPermi"> 	
						
				 				
					<h5  style="text-align:center;" > Informations concernant le permis </h5> 
					<br>
						<div class="row" style="text-align:center;padding-top:5px;margin-right:0px;">
				  		<div class="col-md-6">
				  		Valable du : <input  type="date" name="du" style="display:inline-block; border-style: solid;border-width:1px;border-color:#c6c6c6;color:#757575;">	
				  		</div> 	
				  		<div class="col-md-6">
				  	 	jusqu'au : <input  type="date" name="au" style="display:inline-block; border-style: solid;border-width:1px;border-color:#c6c6c6;color:#757575;">		
				  		</div>		
				  	</div>
					
					<div class="form-group">
					<label for="email"></label>
   					<input type="text" name="nom" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Entrez le nom de l'entreprise ou de la personne concernée par le permi">
					</div>	
					
					
					<div class="form-group">
					<label for="email"></label>
   					<input type="text" name="type" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Entrez le type du permis">
					</div>	
					
					<div class="form-group">
					<label for="email"></label>
   					<input type="text" name="ressources" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Entrez les ressources utilisées">
					</div>	
					
					<div class="form-group">
					<label for="email"></label>
   					<input type="text" name="connaissances" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Entrez les Connaissances traditionnelles utilisées">
					</div>	
					
					<div class="form-group">
					<label for="email"></label>
   					<input type="text" name="endroits" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Entrez les Endroits autorisés à exploités">
					</div>
					
							
							
					
					 <input type="text" name="iddemande" value="${iddemande}" style="display:none"> 
		    		 <input type="text" name="iduser" value="${iduser}" style="display:none"> 
		    		 <input type="text" name="nature" value="${nature}" style="display:none"> 
		    		 <input type="text" name="but" value="${but}" style="display:none"> 
		    		 <button class="btn btn-primary" type="submit" style="float:right;">Délivrer</button>
					</form>
					</div>
					</div>
					</div>
					</div>
					
		</div>
		
		
		
		</div>
		</div>
		
		

<%@ include file="../Commun/footer.jsp" %>
</body>
</html>