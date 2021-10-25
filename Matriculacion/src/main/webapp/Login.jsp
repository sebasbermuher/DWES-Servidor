
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Iniciar Sesion</title>
</head>
<body>
	<%
	if (session.isNew()) {
    %>
    
    <form method="POST">
		<input type="submit" name="entrar" value="IniciarSesion" />
	</form>

    <%
        } else {
    %>

    <form method="POST">
        <input type="submit" name="salir" value="Salir" />
    </form>

    <%
    }
    %>
    
</body>
</html>