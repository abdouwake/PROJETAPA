<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="col-md-12" style="margin-top:15px;">
	             	<div class="card">
					  <div class="card-header" style="background-color:#3A1F35;color:white;">
					    <c:out value="${param.titre}"/>
					    <label style="float: right;">
					   <strong> <c:out value="${param.username}"/>  </strong></label> 
					  </div>
					  <div class="card-body">	
					    <p class="card-text"><c:out value="${param.contenu}"/></p>
					    
					<jsp:include page="Reponde.jsp">
			            <jsp:param name="id" value="${param.id}"/>
			            <jsp:param name="chaine" value="machaine"/>
			            <jsp:param name="diez" value="#"/>
			       		</jsp:include>
			       		  </div>
					  
					  
					<span style="margin-left:20px;margin-buttom:5px;">  <c:out value="  ${param.date}" /></span>
					</div>  
					 
</div> 