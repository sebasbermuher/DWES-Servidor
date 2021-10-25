<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmacion</title>
</head>
<body>

	<%
	Cookie[] cookie = null;

	%>
	
	<h4>Nombre: <%= request.getParameter("nombre") %> </h4>
	<h4>Apellidos: <%= request.getParameter("apellidos") %> </h4>
	<h4>Correo Electronico: <%= request.getParameter("email") %> </h4>
	<h4>Curso: <%= request.getParameter("cursos") %> </h4>
	<h4>Modulo/s: <%= request.getParameter("modulos") %> </h4>
	
</body>
</html>