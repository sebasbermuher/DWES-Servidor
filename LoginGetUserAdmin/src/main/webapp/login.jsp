<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<% if (request.getMethod().equals("POST")){%>
<% 
        if((request.getParameter("usuario")).equals("admin") 
            && (request.getParameter("password")).equals("admin")){
    %>
    <jsp:forward page="admin.jsp"/>
    <%
        }
    if((request.getParameter("usuario")).equals("usuario") 
            && (request.getParameter("usuario")).equals("usuario")){
    %>
    <jsp:forward page="usuario.jsp"/>
    <% } else { %>
        <p style="color:red">Login incorrecto</p>
    <% } %>
    <% } %>

	<form method="post">
		<p><label for="usuario">Usuario</label>
		<p><input id="usuario" type="text" name="usuario" required></p>
		<p><label for="password">Contraseña</label>
		<p><input id="password" type="password" name="password" required></p>
		<p><input type="submit" value="enviar"></p>
	</form>
</body>
</html>