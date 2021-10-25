<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retirada</title>
</head>
<body>


<%
	double dinero = Double.parseDouble(request.getParameter("dinero"));
	out.print("<h3> Has decidido abandonar el juego con " + dinero + "€</h3>");
%>

</body>
</html>