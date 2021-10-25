<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seleccionar</title>
</head>
<body>
<form method="POST">
	<label>Nombre: </label>
	<input type="text" name="nombre" required/><br>
	<label>Apellidos: </label>
	<input type="text" name="apellidos" required/><br>
	<label>Correo Electronico: </label>
	<input type="text" name="email" required/><br><br>
	
	<label>Selecciona el curso:</label><br>
        <input type="radio" name="cursos" value="1DAW"> 1ºDAW<br>
        <input type="radio" name="cursos" value="2DAW"> 2ºDAW<br><br>
           
	<label>Selecciona los modulos:</label><br>
        <select multiple size="6" name="modulos" required>
            <option>Diseño</option>
            <option>Servidor</option>
            <option>Empresa</option>
            <option>HLC</option>
            <option>Cliente</option>
            <option>Despliegue</option>
        </select>
        <br><br>
        
        <input type="submit" value="Matricular">
        
    </form>

</body>
</html>