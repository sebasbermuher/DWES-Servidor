<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 4</title>
</head>
<body>

<h1>Conversor de euros a dolares</h1>
<form method="post">
	<label for="euros">Introduce cantidad en euros</label>
	<p><input id="euros" type="text"  name="euros" required></p>
	<p><input type="submit" value="Calcular a dolares"></p>
</form>

<% 
if ((request.getMethod().equals("POST"))){

			double cantidad = Double.parseDouble(request.getParameter("euros"));
			double dolar = 1.16;
			
			double convertido = cantidad*dolar;
			out.println(cantidad  + " euros son " + convertido + " dolares.");			
}
%>

</body>
</html>