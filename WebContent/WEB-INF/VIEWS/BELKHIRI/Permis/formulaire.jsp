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
						<div> <h4    style="text-align:center;color:#3A1F35;"> Formulaire de demande de permis </h4> </div>
						 <br><br>
				<form method="post" action="PostForm" enctype="multipart/form-data"> 	
				<div class="row">						
				<div class="col-md-12">
				  	<div class="row">						
					<div class="col-md-6">
					<h5  style="text-align:center;" > Vos informations </h5> 
					
					<div class="form-group">
					<label for="nom">Votre Nom</label>
   					<input type="text" name="nom" class="form-control" id="nom" aria-describedby="emailHelp" placeholder="Entrer votre nom">
   					</div>
   					
   					<div class="form-group">
					<label for="prenom">Votre Prenom</label>
   					<input type="text" name="prenom" class="form-control" id="prenom" aria-describedby="emailHelp" placeholder="Entrer votre prenom">
					</div>
					
					<div class="form-group">
					<label for="email">Votre Email</label>
   					<input type="text" name="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Entrer votre email">
					</div>
					
					<div class="form-group">
					<label for="numero">Votre Numero</label>
   					<input type="text" name="numero" class="form-control" id="numero" aria-describedby="emailHelp" placeholder="Entrer votre Numéro">
					</div>

					<div class="form-group">
					<label for="adresse">Votre Adresse</label>
   					<input type="text" name="adresse" class="form-control" id="adresse" aria-describedby="emailHelp" placeholder="Entrer votre Adresse">
					</div>
					
					<div class="input-group">		  	
					  <div class="custom-file">
					    <input type="file" name="carteid" class="custom-file-input" id="carteid" aria-describedby="inputGroupFileAddon01">
					    <label class="custom-file-label" for="carteid">Votre carte d'identité</label>
					  </div>
					</div>
					
					
					</div>
					<div class="col-md-6">
					<h5 style="text-align:center;"> Votre Projet </h5> 
					
					<div class="form-group">
					<label for="titreprojet">Titre du projet</label>
   					<input type="text" name="titreprojet" class="form-control" id="titreprojet" aria-describedby="emailHelp" placeholder="Entrer le titre de votre projet">
   					</div>  
					
					 
					<br>
					<div class="input-group" style="padding-top:10px;padding-bottom:15px;">		  	
					  <div class="custom-file">
					    <input type="file" name="projetdescription" class="custom-file-input" id="projetdescription" aria-describedby="inputGroupFileAddon01">
					    <label class="custom-file-label" for="projetdescription">Résumé de votre projet</label>
					  </div>
					</div>
					
					
					<div class="form-group">
					<label>Lieu de collecte </label>
					<input type="text" name="localisation" class="form-control" id="localisation" aria-describedby="emailHelp" placeholder="localisation" ><br>
					<input type="text" name="longitude" class="form-control" id="longitude" aria-describedby="emailHelp" placeholder="longitude" ><br>
					<input type="text" name="latitude" class="form-control" id="latitude" aria-describedby="emailHelp" placeholder="latitude" >
 					</div>
 					
 					<div class="form-group" style="padding-top:15px;">
					<label for="duree" >Durée du projet </label>
					<input type="text" name="duree" class="form-control" id="duree" aria-describedby="emailHelp" placeholder="Durée du projet"><br>
					</div>
		 
					</div>
				</div>
 				</div>
						
				</div>
				<div class="row">
				<div class="col-md-12">
				<div><h5 style="text-align:center;">Votre entreprise (Si vous êtes une personne morale)</h5></div> 
				
				<div class="form-group">
				<label for="nomentreprise">Nom de l'entreprise  </label>
   				<input type="text" name="nomentreprise" class="form-control" id="nomentreprise" aria-describedby="emailHelp" placeholder="Entrer le nom de votre entreprise">
   				</div>
				
				<div class="form-group">
				<label for="siege">Siège  </label>
   				<input type="text" name="siege" class="form-control" id="siege" aria-describedby="emailHelp" placeholder="Entrer l'adresse de votre entreprise">
   				</div>
				
				<div class="form-group">
				<label for="numeroentreprise">Numéro  </label>
   				<input type="text" name="numeroentreprise" class="form-control" id="numeroentreprise" aria-describedby="emailHelp" placeholder="Entrer le numéro pour contacter votre entreprise">
   				</div>
   				
   				<div class="form-group">
				<label for="siteentreprise">Site Web  </label>
   				<input type="text" name="siteentreprise" class="form-control" id="siteentreprise" aria-describedby="emailHelp" placeholder="Entrer le sitee de votre entreprise">
   				</div>
   		 
   				
				<div><h5 style="text-align:center;">Fournisseur d'accès</h5></div> 
				
				<div class="form-group">
					<label for="fournisseurnom">Nom du fournisseur d'accès </label>
   					<input type="text" name="fournisseurnom" class="form-control" id="fournisseurnom" aria-describedby="emailHelp" placeholder="Entrer le nom du fournisseur d'accès">
   					</div>
   					
				<div class="input-group">		  	
					  <div class="custom-file">
					    <input type="file" name="autorisationFournisseur" class="custom-file-input" id="autorisationFournisseur" aria-describedby="inputGroupFileAddon01">
					    <label class="custom-file-label" for="autorisationFournisseur">Autorisation du fournisseur</label>
					  </div>
					</div>
				<br>
				<div><h5 style="text-align:center;">Ressources biologiques utilisées</h5></div> <br>
				
					<div class="form-group">
					<label for="nomusuel">Nom usuel </label>
   					<input type="text" name="nomusuel" class="form-control" id="nomusuel" aria-describedby="emailHelp" placeholder="Entrer le nom usuelle de la ressource utilisée">
   					</div>
   					
   					<div class="form-group">
					<label for="nomusuel">Taxon </label>
   					<input type="text" name="nomusuel" class="form-control" id="nomusuel" aria-describedby="emailHelp" placeholder="Entrer le Taxon de la ressource">
   					<small id="taxonomie" class="form-text text-muted">Au niveau taxonomique le plus spécifique connu.</small>
   					</div>
   					
   					<div class="form-group">
					<label for="quantite">Quantité, Nombre et volume </label>
   					<input type="text" name="quantite" class="form-control" id="quantite" aria-describedby="emailHelp" placeholder="Entrer le nom usuelle de la ressource utilisée">
   					</div>
   					
   					<br>
   					<div><h5 style="text-align:center;">Connaissances traditionelles associées</h5></div>  <br>
   					
   					<div class="form-group">
					<label for="community">Identification de la communaute : </label>
   					<input type="text" name="community" class="form-control" id="community" aria-describedby="emailHelp" placeholder="Identifiez la communauté concernée">
   					</div>
   					
   					<div class="form-group">
					<label for="typeconnaissance">Type de la connaissance traditionnelle </label>
   					<input type="text" name="typeconnaissance" class="form-control" id="typeconnaissance" aria-describedby="emailHelp" placeholder="Entrez le type de la connaissance traditionnelle">
   					</div>
   					
   					<div class="form-group">
					<label for="descriptionUsage">Décrivez l'utilisation prévue </label>
   					<input type="text" name="descriptionUsage" class="form-control" id="descriptionUsage" aria-describedby="emailHelp" placeholder="Description de l'usage">
   					</div>
   					
   					
   					<div><h5 style="text-align:center;">Informations concernant le permis </h5></div> <br>
   					
   					
   					
   					<div class="form-group">
   					<label for="descriptionUsage">Permis pour l’utilisation de :</label>
   					<select name="type" class="browser-default custom-select">
					  <option selected>Choisissez le type de votre permis</option>
					  <option value="Ressources Génétiques">Ressources Génétiques	</option>
					  <option value="CT associées aux Ressources Génétiques">CT associées aux Ressources Génétiques</option>
					</select>
					</div>
					
					<div class="form-group">
    				<select name="but" class="browser-default custom-select">
					  <option selected>Permis à but </option>
					  <option value="Commercial ou potentiellement commercial">Commercial ou potentiellement commercial	</option>
					  <option value="Non-commercial">Non-commercial</option>
					</select>
					</div>
					
					 <div class="input-group">		  	
					  <div class="custom-file">
					    <input type="file" name="demandemanuscrite" class="custom-file-input" id="demandemanuscrite" aria-describedby="inputGroupFileAddon01">
					    <label class="custom-file-label" for="demandemanuscrite">Demande manuscrite scannee ou prise en photo</label>
					  </div>
					</div>
					
					
					<br> 
			  		Le projet va durer du : <input  type="date" name="du" style="display:inline-block; border-style: solid;border-width:1px;border-color:#c6c6c6;color:#757575;">	  		 
			  	 	au :  <input  type="date" name="jusquau" style="display:inline-block; border-style: solid;border-width:1px;border-color:#c6c6c6;color:#757575;">		
					<br><br><br>

				</div>
				</div>
				  <button class="btn btn-primary" type="submit" style="display: block; margin: 0 auto;">Valider</button> 
				
 				</form>
				
				
 			</div>
 		</div>
 		
 		</div>
 	</div>
 	</div>
 	</div>
 <%@ include file="../../Commun/footer.jsp" %>
</body>
</html>
 