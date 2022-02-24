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
<title>Detalle Customer</title>
</head>
<body>

	<jsp:include page="include/barra.jsp" />
	<div class="container mt-5">

		<h1>Detalle Customer</h1>


		<div class="row justify-content-end">
			<div class="col-2">
				<!-- 				<a class="btn btn-primary w-100" href="AddEmpleado">AÑADIR EMPLEADO</a>
 -->
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Numero de cliente</th>
							<th>Nombre del cliente</th>
							<th>Nombre del contacto</th>
							<th>Apellidos del contacto</th>
							<th>Telefono</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customer}" var="customer">
							<tr>
								<td>${customer.customerName}</td>
								<td>${customer.contactFirstName}</td>
								<td>${customer.contactLastName}</td>
								<td>${customer.phone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<%-- <c:forEach items="${cust}" var="cu">
				<ul>
					<li>${cu.customerNumber}</li>
					<li>Apellidos del contacto</li>
					<li>Nombre del contacto</li>
					<li>Telefono</li>
					<li>Direccion 1</li>
					<li>Direccion 2</li>
					<li>Ciudad</li>
					<li>Estado</li>
					<li>Codigo Postal</li>
					<li>Pais</li>
					<li>salesRepEmployeeNumber</li>
					<li>creditLimit</li>
				</ul>
				</c:forEach> --%>
			</div>
		</div>
	</div>
</body>
</html>