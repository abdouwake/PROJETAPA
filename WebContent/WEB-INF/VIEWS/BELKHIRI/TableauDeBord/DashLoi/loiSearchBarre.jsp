<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div> 
<form method="get" action="RechercheLoiTab">
<div class="input-group">
<div class="input-group-btn search-panel">
</div>
<input type="text" class="form-control" name="search" placeholder="Chercher quelque chose..." >              
</div>
 
 
  	<div class="row" style="padding-top:5px;margin-right:0px;">
  		<div class="col-md-6">
  		Publier entre le : <input  type="date" name="du" style="display:inline-block; border-style: solid;border-width:1px;border-color:#c6c6c6;color:#757575;">	
  		</div> 	
  		<div class="col-md-6">
  	 	Et le : <input  type="date" name="au" style="display:inline-block; border-style: solid;border-width:1px;border-color:#c6c6c6;color:#757575;">		
  		</div>		
  	</div>
   
 
<input type="text" class="form-control" name="contient" placeholder="Contient les mots..." style="margin-top:15px;">              
 
	 
 
<button class="btn btn-primary" type="submit">Recherche</button>
</form>
</div>
<br><br><br>

 

