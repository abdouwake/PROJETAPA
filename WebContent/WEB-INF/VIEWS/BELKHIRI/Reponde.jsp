<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:set var="identifiant">${param.diez}${param.chaine}${param.id}</c:set>
<c:set var="nom">${param.chaine}${param.id}</c:set>

  <button type="button" class="btn btn-secondary btn-sm" data-toggle="collapse" href="${ identifiant }" role="button" aria-expanded="false" aria-controls="${ nom }">Ajouter une réponse</button>
  
 
<br><br>

<div class="collapse" id="${ nom }">
  <div class="card card-body">
  <div class="form-group">
   <label for="content">Votre Réponse :</label>
      <form method="post" action="Repondre">
         <textarea name="contenu" class="form-control" rows="2"></textarea>
         <input type="hidden"  name="idquestion" value="${param.id}" visible=false/>
		 <button type="submit" class="btn btn-success green" style="float:right;padding-top:5px;"><i class="fa fa-share"></i> Valider</button>
	  </form>
		</div>
   </div>
</div>

 
 