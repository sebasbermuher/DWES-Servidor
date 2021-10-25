<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 16</title>
</head>
<body>

<div id="principal">
    <table>
      <tr><td></td><td>a</td><td>b</td><td>c</td><td>d</td><td>e</td><td>f</td><td>g</td><td>h</td><td></td></tr>
      <%
      String color = "";
      String imagen = "";
      
      int filaAlfil;
      int columnaAlfil;
      int filaCaballo;
      int columnaCaballo;
      
      do {
        
        // Coordenadas del alfil
        filaAlfil = (int)(Math.random() * 8) + 1;
        columnaAlfil = (int)(Math.random() * 8);
        
        // Coordenadas del caballo
        filaCaballo = (int)(Math.random() * 8) + 1;
        columnaCaballo = (int)(Math.random() * 8);
        
      } while ((filaAlfil == filaCaballo) && (columnaAlfil == columnaCaballo));
      
      
      for (int fila = 8; fila > 0; fila--) {
        out.print("<tr><td>" + fila + "</td>");
        for (int columna = 0; columna < 8; columna++) {
          
          // Determina el color de la casilla
          if ((((fila % 2) + (columna % 2)) % 2) == 0) {
            color = "blanco";
          } else {
            color = "negro";
          }
          
          // Determina la imagen que se inserta en la casilla
          if ((fila == filaAlfil) && (columna == columnaAlfil)) {
            imagen = "alfilBlanco.png";
          } else if ((fila == filaCaballo) && (columna == columnaCaballo)) {
            imagen = "caballoNegro.jpg";
          } else {
            imagen = "transparente.png";
          }
          out.print("<td class=\""+ color + "\"><img src=\"img/" + imagen + "\"</td>");
        }
        out.print("<td>" + fila + "</td></tr>");
      }
      %>
      <tr><td></td><td>a</td><td>b</td><td>c</td><td>d</td><td>e</td><td>f</td><td>g</td><td>h</td><td></td></tr>
    </table>
    </div>

</body>
</html>