 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Demander Permis</title>

	<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/jquery/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/faq.css">
 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
</head>
<body>
 <%@ include file="../../Commun/HomeMember/NavbarMember.jsp" %>  
<br> <br>

 <div class="container" >
	   <div class="row">
	   <div class="col-md-4"> 
		<a href="${pageContext.request.contextPath }/GetInformationPermis" class="btn btn-outline-secondary">à propos du permis</a>
		<br>
		<a href="${pageContext.request.contextPath }/GetDemandePermis" class="btn btn-outline-secondary" style="background-color:#3A1F35;color:white;">Demander un permis</a>
		<br>
		<a href="${pageContext.request.contextPath }/GetConsulterPermis" class="btn btn-outline-secondary"  >Consulter l'état de ma demande</a>
		 <br>
		<a href="${pageContext.request.contextPath }/GetAfficherPermis" class="btn btn-outline-secondary"  >Afficher mes permis</a>
		</div>
		
		 <div class="col-md-8">

 			<div class="container" >
 			 <div style="padding-top:10px;"> 
				 <div class="card bg-light" id="cardib" style="background-color:#F9F5F5;width:700px;padding-top:50px;padding-right:50px;padding-left:50px;padding-bottom:50px;">
						<div> <h4 style="color:#3A1F35;display:inline-block;"> Avant de commencer...</h4> <img alt="infos" src="${pageContext.request.contextPath }/images/7517.png" height="35" width="35" style="float:right;"> </div>
						 <br>
						 <p>
						 Veuillez noter que ce formulaire de demande, si il est approuvé, devient une partie intégrante de l’accord  de base sur
						 l’APA  régissant l’accès et l’utilisation de  son objet. Soyez aussi spécifique et précis que possible.	
						 </p>
						 <br>
						 <h4>Notes explicatives pour remplir le formulaire </h4><br>
						 <h5>Utilisation </h5>

							<p>Dans ce contexte, le terme utilisation signifie mener la recherche et/ou le développement sur la génétique et/ou la
							composition biochimique des ressources génétiques, y compris au moyen de l’application de la biotechnologie telle que 
							définie à l’article 2 de la Convention sur la Diversité Biologique.</p> 
						
						
						<h5>But </h5>

							<p>But Non-Commercial : les ressources biologiques échantillonnées et/ou les CT associées ne seront pas utilisées pour les
							recherches et/ou le développement pour des buts commerciaux ou potentiellement commerciaux.<br>
							But Commercial ou potentiellement Commercial : les ressources biologiques échantillonnées et/ou les CT associées doivent 
							être utilisées pour la recherche et/ou le développement d’une application potentiellement commerciale (ex. pharmaceutique,
							agricole, industrielle ou autre – telle que le dépistage de bio activité).</p> 
							
							<div  style="text-align: center;">
			<a class="btn btn-success green" href="${pageContext.request.contextPath }/GetFormulairePermis" style="color:white;width:200px;background-color:#6c757d;border:none;"><i class="fa fa-share"></i> J'ai compris ! </a>
		</div>
		
							</div>
						
						</div>
 			</div>
 		</div>
 		
 		</div>
 	</div>
 	
 <%@ include file="../../Commun/footer.jsp" %>
</body>
</html>
 