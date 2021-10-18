<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 8</title>
</head>
<body>

<h1>Generador de calendario</h1>
<form method="post">Mes
	<select name="mes">
	<option>Enero</option>
	<option>Febrero</option>
	<option>Marzo</option>
	<option>Abril</option>
	<option>Mayo</option>
	<option>Junio</option>
	<option>Julio</option>
	<option>Agosto</option>
	<option>Septiembre</option>
	<option>Octubre</option>
	<option>Noviembre</option>
	<option>Diciembre</option>
    </select>
      Año <input type="number" name="year">
      <p>El día 1 cae en
      <select name="dia1">
        <option value="1">Lunes</option>
        <option value="2">Martes</option>
        <option value="3">Miércoles</option>
        <option value="4">Jueves</option>
        <option value="5">Viernes</option>
        <option value="6">Sábado</option>
        <option value="7">Domingo</option>
      </select>
      </p>
      Número de días que tiene el mes <input type="number" min="28" max="31" name="diastotales">
      <p><input type="submit" value="Generar calendario"></p>
    </form>


<% if(request.getMethod().equals("POST")){
      int columna = 1;
      int diasTotales = Integer.parseInt(request.getParameter("diastotales"));
      int dia1 = Integer.parseInt(request.getParameter("dia1"));
    %>
    <table>
      <tr><th>Lunes</th><th>Martes</th><th>Miércoles</th><th>Jueves</th><th>Viernes</th><th>Sábado</th><th>Domingo</th></tr>
      <tr>
      <%
      for (int i = 1; i < diasTotales + dia1; i++) {
        if (i >= dia1) {
          out.print("<td>" + (i - dia1 + 1) + "</td>");
        } else {
          out.print("<td> </td>"); //celdas vacias
        }
        columna++;
        if (columna == 8) { // salto a la siguiente columna
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