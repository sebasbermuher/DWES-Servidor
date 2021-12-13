

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />

<title>Detalles Productos</title>
</head>
<body>

	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="col-2">
			<a class="btn btn-secondary w-100"
				href="${pageContext.request.contextPath}">Volver Atras</a>
		</div>

		<div class="row justify-content-center">
			<div class="text-center">
				<h3>Detalles del producto --> ${pro.productName}</h3>
			</div>

			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nº Pedidos</th>
							<th>Nº Productos en 1 venta</th>
							<th>Nº Ventas</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${detallesNumPedidos}</td>
							<td>${detallesNumProductosVentas}</td>
							<td>${detallesNumVentas}$</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>