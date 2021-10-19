<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El Trile</title>
</head>
<body>
<h1>El Trile</h1>
    <%
      int bolita = (int)(Math.random() * 3);
      int cubilete = Integer.parseInt(request.getParameter("cubilete"));
      
      String imagen[] = {"cubilete.png", "cubilete.png", "cubilete.png"};
      imagen[bolita] = "cubilete_con_bola.png";
      
      String mensaje;
      if (bolita == cubilete) {
        mensaje = "¡Enhorabuena! ¡Has acertado!";
      } else {
        mensaje = "Lo siento, has perdido.";
      }
      
    %>  
    <table>
      <tr>
        <td><img src="<%= imagen[0] %>" width="150"></td>
        <td><img src="<%= imagen[1] %>" width="150"></td>
        <td><img src="<%= imagen[2] %>" width="150"></td>
      </tr>
    </table>
      <p><%= mensaje %></p>
      <p><a href="Ejercicio14.jsp"><button>Volver a jugar</button></a></p>
</body>
</html>