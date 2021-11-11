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
<%@taglib prefix="fmt"     uri="http://java.sun.com/jstl/fmt_rt"    %>
<%@taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core"     %>
<fmt:setBundle basename="interface" />


<div class="container mt-5">
		<div class="row justify-content-center">
		
<% if (!session.isNew() && session.getAttribute("LOGEADO")!=null && ((boolean)session.getAttribute("LOGEADO")) ) { %>
			
			<jsp:include page="barra.jsp"></jsp:include>
			<div class="col-3">
				<img src="https://media-cdn.tripadvisor.com/media/photo-s/14/03/cb/1d/entrada-hotel.jpg"/>
			</div>

			<% } else { %>	
					
			<div class="col-6">
			<h1><fmt:message key="TravelCenter" /></h1>
				<form method="post">		
					<label class="form-label" for="user"><fmt:message key="user" /></label>
					<input class="form-control" type="text" name="user" required/>
					
					<label class="form-label" for="password"><fmt:message key="password" /></label>
					<input class="form-control" type="password" name="password" required/>
					
					<label class="form-label" for="confirmar_password"><fmt:message key="confirm" /></label>
					<input class="form-control" type="password" name="confirmar_password" required/>
					
					<label class="form-label mt-3" for="email"><fmt:message key="email" /></label>
					<input class="form-control mb-3" name="email" type="email" required/>
					
					<input class="btn btn-primary w-100 mt-3" type="submit" name="registrarse" value="<fmt:message key="register" />"/>					
				</form>
			</div>
			
			<% } %>
			
		</div>
	</div>	
	
</body>
</html>