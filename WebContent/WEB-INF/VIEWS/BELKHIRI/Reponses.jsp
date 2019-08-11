<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container" >
<div class="row">
<div class="col-md-12" >

<div class="card" style="width:500px;margin-top:15px;float:right;">
  <div class="card-header" style="background-color:#C4BBBD;color:#3A1F35;">
   <strong> ${param.username } </strong> 
  </div>
  <div class="card-body">
    <blockquote class="blockquote mb-0">
      <p style="font-size:16px;">${ param.contenu }</p>
      <footer class="blockquote-footer"> Le <c:out value="${param.date }"/></footer>
    </blockquote>
  </div>
  </div>
</div>
 </div>
 </div>