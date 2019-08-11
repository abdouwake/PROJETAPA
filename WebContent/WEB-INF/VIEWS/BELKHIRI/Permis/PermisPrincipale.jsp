 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Informations</title>

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
		<a href="${pageContext.request.contextPath }/GetInformationPermis" class="btn btn-outline-secondary" style="background-color:#3A1F35;color:white;">à propos du permis</a>
		<br>
		<a href="${pageContext.request.contextPath }/GetDemandePermis" class="btn btn-outline-secondary">Demander un permis</a>
		<br>
		<a href="${pageContext.request.contextPath }/GetConsulterPermis" class="btn btn-outline-secondary"  >Consulter l'état de ma demande</a>
		 <br>
		<a href="${pageContext.request.contextPath }/GetAfficherPermis" class="btn btn-outline-secondary"  >Afficher mes permis</a>
		</div>
		
		 <div class="col-md-8">
 		
 			<div class="container" >
 			<div style="padding-top:10px;"> 
				 <div class="card bg-light" id="cardib" style="background-color:#F9F5F5;width:700px;padding-top:50px;padding-right:50px;padding-left:50px;padding-bottom:50px;">
						<div> <h4 style="color:#3A1F35;display:inline-block;"> à propos du permis...</h4> <img alt="infos" src="${pageContext.request.contextPath }/images/7517.png" height="35" width="35" style="float:right;"> </div>
						 <br>
						
						<c:if test="${message != null }">
						<div class="alert alert-success" role="alert">
						Votre demande a été envoyée avec succés, les étapes seront visibles dés que votre demande sera validée par un modérateur.
						</div> 
						</c:if>
						
						 
						 
						 <p align="justify">  Afin de garantir le partage des avantages avec le pays Fournisseur de la Ressource 
						 Génétique (RG) et/ou la Connaissance Traditionnelle Associée (CTa), conformément à la 
						 Convention sur la Diversité Biologique (CDB), adoptée le 22 mai 1992 et entrée en vigueur 
						 le 29 décembre 1993, le TIRPAA adopté le 03 novembre 2001 et au Protocole de Nagoya adopté
						 le 29 octobre 2010 et entré en vigueur le 12 octobre 2014, le Bénin met tout en œuvre pour
						 Assurer la traçabilité de ses ressources génétiques Fournir une sécurité juridique
						 et légale pour les fournisseurs et les utilisateurs de ses ressources génétiques et/ou 
						 connaissances traditionnelles associées Assurer le respect des obligations 
						 contractuelles contenues dans les Conditions Convenues de Commun Accord. 
						 <br><br>
						 Dans ce cadre, au Bénin, la ressource génétique est cédée par le Fournisseur à l’Utilisateur
						 à travers le présent Accord dans les conditions ci-dessous. L'Accord est soumis à l’octroi d’un
						 permis auprès de l’Autorité Nationale Compétente en matière d'APA, la demande de permis est partie
						 intégrante de cet accord (et est jointe en annexe). Ce contrat APA constitue la loi des parties.
						 Il prévaut sur tout accord antérieur et entente entre les Parties.
						 <br><br>
						 En raison de la nature variée des collaborations possibles en matière d’APA, il est très difficile
						 (voire impossible) de fournir un modèle de contrat qui couvre et anticipe tous les scenarios et
						 situations contractuelles possibles. Dans toute transaction et collaboration en matière d’APA, la
						 nature et les dispositions régissant un contrat doivent être adaptées au cas par cas en vue de
						 répondre aux besoins et intérêts des Parties et afin de créer un arrangement optimal et mutuellement bénéfique.
						 <br><br>
						 A cet effet, toutes les dispositions du présent accord sont fournies à titre indicatif et pourraient
						 être partiellement ou entièrement renégociées, modifiées et adaptées selon les circonstances
						 spécifiques de chaque situation
							</p>
						
				  
				 </div>
				 </div>
 			</div>
		</div>
		</div>
		</div>

   	  
   	   	
<%@ include file="../../Commun/footer.jsp" %>
</body>
</html>
