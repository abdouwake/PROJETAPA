<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <form method="get" action="SearchLois">
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
<small id="taxonomie" class="form-text text-muted">Séparez vos mots par une virgule</small>
 
	 
		<input type="text" name="archiver" value="${param.archiver }" style="display:none"> 					    		 

<button class="btn btn-primary" type="submit">Recherche</button>
</form>
<br><br><br>

 
<a href="${pageContext.request.contextPath }/GetLoiAlgeriennePage" class="btn btn-outline-secondary" style="background-color:#3A1F35;color:white;"
>Parcourir la loi Algérienne</a>
<br>
<a href="${pageContext.request.contextPath }/GetArchivesPage" class="btn btn-outline-secondary" >Archiver la loi algérienne</a>
<br>
<a href="${pageContext.request.contextPath }/GetFaqPageWithAnswers" class="btn btn-outline-secondary">Espace Question/réponses</a>

<script  src="${pageContext.request.contextPath }/css/datepikerjs.js"></script>
