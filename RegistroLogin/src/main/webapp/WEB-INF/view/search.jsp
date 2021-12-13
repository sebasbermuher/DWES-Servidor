<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<jsp:include page="include/barra.jsp" />
<title>SEARCH</title>
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-light bg-light justify-content-between">
			<div class="container-fluid">
				<a class="navbar-brand">Buscar Productos</a>
				<form method="post" class="d-flex">
					<input class="form-control me-2" type="search" name="busqueda"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-danger" type="submit" value="Buscar">Buscar</button>
				</form>
			</div>
		</nav>

		<div class="row justify-content-center">
			<c:choose>
				<c:when test="${productos!=null and productos.size()>0}">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Categoría</th>
								<th>Descripción</th>
								<th>Precio</th>
								<th>+INFO</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productos}" var="p">
								<tr>
									<td>${p.productName}</td>
									<td>${p.productLine}</td>
									<td>${p.productDescription}</td>
									<td>${p.buyPrice}</td>
									<td><a href="SearchDetails?productName=${p.productName}"><i
											class="bi bi-eye-fill"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:when test="${productos!=null and productos.size()==0}">
					<p class="text-danger">NO HAY RESULTADOS</p>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>