<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Profile</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/utiles/bootstrap/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath }/utiles/bootstrap/js/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/home.css">
</head>
<body>


	<%@ include file="NavbarMember.jsp"%>

	<h1>Vous êtes maintenant connecté "${USER.getUsername() }"</h1>

	<br>

	<%@ include file="../footer.jsp"%>

</body>
</html>
