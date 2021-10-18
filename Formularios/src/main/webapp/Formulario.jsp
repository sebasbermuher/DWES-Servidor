<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>
	<form method="post" action="<%= request.getContextPath() %>/Formularios">
		<p>
	<label for="simple">Campo de formulario simple</label>
	<input type="text" name="simple" id="name"/>
	</p>
	<p>Elija una o varias opciones</p>
	<p> <label for="checkbox"> Campo de formulario checkbox</label></p>
	<input type="checkbox" value="A" name="checkbox" > Opcion A <br>
	<input type="checkbox" value="B" name="checkbox" > Opcion B <br>
	<input type="checkbox" value="C" name="checkbox" > Opcion C <br>
	<input type="checkbox" value="D" name="checkbox" > Opcion D <br>
	<input type="checkbox" value="E" name="checkbox" > Opcion E <br>

	
	<p>
	<select name="select" multiple>
		<option>Opcion 1</option>
		<option>Opcion 2</option>
		<option>Opcion 3</option>
		<option>Opcion 4</option>
		<option>Opcion 5</option>
	</select>
	</p>
	
	<p>
	<input type="submit" name="submit" value="Enviar" >
	</p>
	</form>
 
</body>
</html>