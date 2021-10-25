<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 9</title>
</head>
<body>

<h1>Generador de calendario</h1>
<form method="post">Mes
	<select name="mes">
	<option value="1">Enero</option>
	<option value="2">Febrero</option>
	<option value="3">Marzo</option>
	<option value="4">Abril</option>
	<option value="5">Mayo</option>
	<option value="6">Junio</option>
	<option value="7">Julio</option>
	<option value="8">Agosto</option>
	<option value="9">Septiembre</option>
	<option value="10">Octubre</option>
	<option value="11">Noviembre</option>
	<option value="12">Diciembre</option>
    </select>
      Año <input type="number" name="year">
      <p><input type="submit" value="Generar calendario"></p>
    </form>


<% if(request.getMethod().equals("POST")){
      int mes = Integer.parseInt(request.getParameter("mes"));
      int year = Integer.parseInt(request.getParameter("year"));
      String[] nombreMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
      Calendar miCalendario = Calendar.getInstance();
      miCalendario.set(year, mes - 1, 1); // meses = de 0 a 11
      int diasTotales = miCalendario.getActualMaximum(Calendar.DAY_OF_MONTH);
      int dia1 = miCalendario.get(Calendar.DAY_OF_WEEK);
      if (dia1 == 1) {
        dia1 = 7; // domingo = dia 1 // sabado = dia 7
      } else {
        dia1--;
      }
      int columna = 1;
    %>

    <table>
      <tr><th>Lunes</th><th>Martes</th><th>Miércoles</th><th>Jueves</th><th>Viernes</th><th>Sábado</th><th>Domingo</th></tr>
      <tr>
      <%
      for (int i = 1; i < diasTotales + dia1; i++) {
        if (i >= dia1) {
          out.print("<td>" + (i - dia1 + 1) + "</td>");
        } else {
          out.print("<td> </td>"); // pinta los huecos que corresponden a los días del mes pasado
        }
        columna++;
        if (columna == 8) { // termina la fila actual
          out.println("</tr><tr>");
          columna = 1;
        }
      }
}
      %>
      </tr>
    </table>
</body>
</html>