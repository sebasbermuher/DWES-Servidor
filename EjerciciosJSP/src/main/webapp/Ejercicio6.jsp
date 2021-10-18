<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 6</title>
</head>
<body>

<h3>Tabla de multiplicar</h3>
<form method="post">
	<label for="number">Introduce un numero:</label>
	<input id="numero" type="text"  name="numero" required>
	<input type="submit" value="Calcular">
</form>

<table border="1">
<%if(request.getMethod().equals("POST")){
	for(int i = 0; i < 11; i++) {
		out.print("<tr><td>");    
		int numero = Integer.valueOf(request.getParameter("numero"));
		out.print(numero + "</td><td> x </td><td> " + i + " </td><td> = </td><td>");                               
		out.print(numero * i);
		out.print("</td></tr>");
	}
}
%>
</table>
</body>
</html>