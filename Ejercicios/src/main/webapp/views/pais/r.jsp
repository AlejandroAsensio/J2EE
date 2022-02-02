<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de países</title>
</head>
<body>
	<h1>Lista de países</h1>
	<table>
	
	<tr>
		<th>Nombre</th>
	</tr>
		<c:forEach var="pais" items="${paises}">
		<tr>
			<td>${pais.nombre}</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>