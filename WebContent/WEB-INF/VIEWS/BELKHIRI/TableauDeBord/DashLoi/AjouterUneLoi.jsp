 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
 
<button type="button" class="btn btn-secondary btn-sm"   data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample" >Ajouter une nouvelle loi</button>

<div class="collapse" id="collapseExample">
  <div class="card card-body">
	<div class="form-group">
	
	<form method="post" action="AjouterLoi" enctype="multipart/form-data">
	
	<div class="row">
	
	<div class="col-md-6">
	<h3 style="text-align:center;">Français <span><img src="${pageContext.request.contextPath }/images/flags/FR.jpg" alt="Drapeau Français"> </span></h3>
		<label>Intitulé : </label>
		<textarea name="titreFr" class="form-control" rows="1" id="titleFr" required></textarea>
		<label for="contentFr" style="margin-top:10px;">Descriptif du fichier :</label>
		<label for="contentFr" style="font-size:12px;margin-top:0px;">Ce descriptif apparaitera lors de l'affichage du fichier :</label>
		<textarea name="contenuFr" class="form-control" rows="3" id="contentFr" required ></textarea>
		<label for="contentFr" style="margin-top:10px;">Source :</label> <textarea name="sourceFr" class="form-control" rows="1" id="sourceFr" required ></textarea>
		<br><label for="fileFr">Indiquez le fichier à ajouter :   </label>
		<input name="fileFr" type="file" id="fileFr" required accept="application/pdf,image/*,application/.docx">
	</div>
	<div class="col-md-6">
	<h3 style="text-align:center;">Arabe <span><img src="${pageContext.request.contextPath }/images/flags/AR.jpg" alt="Drapeau Algérien"> </span> </h3>
		<label>Intitulé : </label>
		<textarea name="titreAr" class="form-control" rows="1" id="titleAr" ></textarea>
		<label for="contentAr" style=" margin-top:10px;">Descriptif du fichier :</label>
		<label for="contentAr" style="font-size:12px;">Ce descriptif apparaitera lors de l'affichage du fichier :</label>
		<textarea name="contenuAr" class="form-control" rows="3" id="contentAr"  ></textarea>
		<label for="sourceAr" style="margin-top:10px;">Source :</label> <textarea name="sourceAr" class="form-control" rows="1" id="sourceAr"  ></textarea>
		
		<br><label for="fileAr">Indiquez le fichier à ajouter :   </label>
		<input name="fileAr" type="file"  accept="application/pdf,image/*,application/.docx">
	</div>
	</div>	
		<br>
		<div  style="text-align: center;">
		<button type="submit" class="btn btn-success green" style="width:200px;background-color:#6c757d;border:none;"><i class="fa fa-share"></i> Valider</button>
		</div>
		 		
	</form>		
	 </div>
   </div>
</div>