<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<div class="container mt-5">
		<div class="row justify-content-center">
		
<% if (!session.isNew() && session.getAttribute("LOGEADO")!=null && ((boolean)session.getAttribute("LOGEADO")) ) { %>
			
			<div class="col-3">
				<jsp:include page="barra.jsp"></jsp:include>
				<img src="https://media-cdn.tripadvisor.com/media/photo-s/14/03/cb/1d/entrada-hotel.jpg"/>
			</div>

			<% } else { %>	
					
			<div class="col-6">
			<h1>CENTRAL DE VIAJES</h1>
				<form method="post">		
					<label class="form-label" for="user">Usuario:</label>
					<input class="form-control" type="text" name="user" required/>
					
					<label class="form-label" for="password">Contraseña:</label>
					<input class="form-control" type="password" name="password" required/>
					
					<label class="form-label" for="confirmar_password">Confirmar contraseña:</label>
					<input class="form-control" type="password" name="confirmar_password" required/>
					
					<label class="form-label mt-3" for="email">Email:</label>
					<input class="form-control mb-3" name="email" type="email" required/>
					
					<input class="btn btn-primary w-100 mt-3" type="submit" name="registrarse" value="REGISTRARSE"/>					
				</form>
			</div>
			
			<% } %>
			
		</div>
	</div>	
	
</body>
</html>