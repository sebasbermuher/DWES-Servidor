<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservar</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="barra.jsp"></jsp:include>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-6">
			<h1>DATOS DE LA RESERVA</h1>
				<form method="post">		
					<label class="form-label" for="fecha_inicio">Fecha de inicio:</label>
					<input class="form-control" type="date" name="fecha_inicio" required/>
					
					<label class="form-label" for="fecha_fin">Fecha de fin:</label>
					<input class="form-control" type="date" name="fecha_fin" required/>
					
					<label class="form-label" for="num_personas">Numero de personas:</label>
					<input class="form-control" type="number" name="num_personas" min="0" required/>
					
					<br>
					<h3>SERVICIOS</h3>
					<div class="col">
						<input type="checkbox" name="checkbox" value="WiFi">WiFi 
        				<input type="checkbox" name="checkbox" value="Toallas">Toallas
        			</div>
        			<div class="col">
        				<input type="checkbox" name="checkbox" value="Desayuno">Desayuno 
        				<input type="checkbox" name="checkbox" value="Limpieza">Limpieza
        			</div>
        			<div class="col">
        				<input type="checkbox" name="checkbox" value="Ruta guiada">Ruta guiada 
        				<input type="checkbox" name="checkbox" value="Sauna">Sauna
        			</div>
				
					<input class="btn btn-primary w-100 mt-3" type="submit" name="reserva" value="RESERVAR"/>					
				</form>
			</div>
		</div>
	</div>	
	
</body>
</html>