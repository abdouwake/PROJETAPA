

<button type="button" class="btn btn-secondary btn-sm" style="background-color:green;"data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">Ajouter</button>


<div class="collapse" id="collapseExample">
  <div class="card card-body">
	<div class="form-group">
	
	<form method="post" action="PoserQuestion">
		<label for="title">Objet :</label>
		<textarea name="titre" class="form-control" rows="1" id="title" required></textarea>
		<label for="content">Votre Question :</label>
		<textarea name="contenu" class="form-control" rows="5" id="content" required ></textarea>
		
		<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> Valider</button>
	</form>		
	 </div>
   </div>
</div>
 