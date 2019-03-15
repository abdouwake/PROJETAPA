<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	
	<link	 rel="stylesheet" href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
	<script  src="${pageContext.request.contextPath }/utiles/bootstrap/js/jquery.min.js"></script>
	<link 	 rel="stylesheet" href="${pageContext.request.contextPath }/css/home.css">
</head>
<body>	

<%@ include file="NavbarVisitor.jsp" %>  


<%@ include file="../footer.jsp" %>

</body>
</html>