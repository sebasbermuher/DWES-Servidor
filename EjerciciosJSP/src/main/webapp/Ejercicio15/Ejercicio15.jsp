<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 15</title>
</head>
<body>
<h1>Apuesta y gana</h1>
    <div>
    <form method="post" action="juego.jsp">
      <p>Introduzca la cantidad que quiere apostar:</p>
      <input type="number" min="1" name="dinero">€<br>
      <input type="submit" value="Aceptar">
    </form>
    </div>

</body>
</html>