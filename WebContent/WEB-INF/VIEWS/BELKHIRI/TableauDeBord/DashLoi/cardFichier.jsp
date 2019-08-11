<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="col-md-12" style="margin-top:20px;">
	             	<div class="card">
					  <div class="card-header" style="background-color:#C4BBBD;color:white;">
					   <span style="margin-top:0px;pading-top:0px;"> <b>source :</b> ${param.source } </span> 			     
					  </div>
					  <div class="card-body">
					  	
					  <form method="get" action="OpenFileLoiFromTab"> 
					  
					  <button type="submit" style="padding-left:0px;background:none; color:#01668e;border:none; font: inherit; cursor: pointer;font-size:24px;"> ${param.titre }</button>
					  <input type="text" name="url" value="<c:out value="${param.url }"/>" style="visibility:hidden;"></a>
					  </form>
					  
					    <p class="card-text"> ${ param.description}</p>
					    
					
			       		  </div>
					      <div class="card-header" style="background-color:#C4BBBD;color:white;">
					      <c:out value="Ajouter le  : ${ param.date }"/>
					      
					    		<div style="display:inline-block;position: absolute;right:10px;margin-bottom: 1em;">
					    		<form method="get" action="${pageContext.request.contextPath }/MAJLoi">  
					    		 <input type="text" name="idloi" value="${param.id }" style="visibility:hidden;"> 
								 <button class="btn btn-secondary btn-sm" type="submit" style="backround-color:#C4BBBD;float:right;">Archiver</button>
								</form>
					    		 </div>

					  </div>
				</div>  
					 
</div> 