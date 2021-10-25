<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 12</title>
</head>
<body>
<%
	String[] cara = {"img/j.png", "img/k.png", "img/q.png", "img/rojos.png", "img/negros.png", "img/as.png"};
	for (int i = 0; i < 3; i++) {
		out.print("<img src=\"" + cara[(int)(Math.random()*6)] +"\">");
	}
%>
</body>
</html>