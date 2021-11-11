<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<jsp:include page="include/bootstrap.jsp" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizacion de la lista productos</title>
</head>
<body>
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-6 mt-5">
		<form method="post">
			<label for="productLine" class="form-label">ProductLine</label>
    		<input name="productLine" value="${listadoProductos.productLine}" type="text" class="form-control" id="productLine" disabled >
    		
    		<label for="textDescription" class="form-label">TextDescription</label>
    		<input name="textDescription" value="${listadoProductos.textDescription}" type="text" class="form-control" id="textDescription">
    		
    		<label for="htmlDescription" class="form-label">HTMLDescription</label>
    		<input name="htmlDescription" value="${listadoProductos.htmlDescription}" type="text" class="form-control" id="htmlDescription">
    		
    		<input type="submit" value="Actualizar" class="btn btn-primary w-100 mt-5">
		</form>
		</div>
	</div>
</div>
</body>
</html>