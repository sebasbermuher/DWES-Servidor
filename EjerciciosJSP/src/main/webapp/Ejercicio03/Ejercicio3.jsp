<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 3</title>
</head>
<body>
<h1>Introduce 3 notas y te calculo la media</h1>
<form method="post">
	<label for="nota1">Nota 1</label>
	<p><input id="nota1" type="number" step="any" name="nota1" required></p>
	<label for="nota2">Nota 2</label>
	<p><input id="nota2" type="number" step="any" name="nota2" required></p>
	<label for="nota3">Nota 3</label>
	<p><input id="nota3" type="number" step="any" name="nota3" required></p>
	<p><input type="submit" value="enviar"></p>
</form>

<% 
if ((request.getMethod().equals("POST"))){

			double nota1 = Double.parseDouble(request.getParameter("nota1"));
			double nota2 = Double.parseDouble(request.getParameter("nota2"));
			double nota3 = Double.parseDouble(request.getParameter("nota3"));
			
			double media = (nota1+nota2+nota3)/3;
			out.println("La media es: " + Math.round(media));			
}
%>
</body>
</html>