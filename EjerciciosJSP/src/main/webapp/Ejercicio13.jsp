<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 13</title>
</head>
<body>

<h3>Configurador de vehículo</h3>
    <form method="post">
      Color de la tapicería:
      <select name="tapiceria">
        <option value="blanco">Blanco</option>
        <option value="negfro">Negro</option>
        <option value="berenjena">Berenjena</option>
      </select>
      <br>
       Material de las molduras:
      <select name="moldura">
        <option value="madera">Madera</option>
        <option value="carbono">Carbono</option>
      </select>
      <br>
      <input type="submit" value="Aceptar">
    </form>
    
    
    <% if(request.getMethod().equals("POST")){
      String tapiceria = request.getParameter("tapiceria");
      String moldura = request.getParameter("moldura");
      String imagen = tapiceria + moldura + ".jpg";
    }
    %>
    
     

</body>
</html>