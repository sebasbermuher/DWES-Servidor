<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A</title>
</head>
<body>
<h1>Hola soy A</h1>

<jsp:useBean id="usuario" scope="request" class="org.iesalixar.servidor.sbh.model.Usuario"></jsp:useBean>
<%= (String)request.getParameter("destino")%>

<p>Usuario: <%= usuario.getUsuario() %> </p>
<p>Password: <%= usuario.getPassword() %> </p>
</body>
</html>