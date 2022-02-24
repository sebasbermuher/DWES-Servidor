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
<title>Customer</title>
</head>
<body>

	<jsp:include page="include/barra.jsp" />
	<div class="container mt-5">

		<h1>Customer</h1>


		<div class="row justify-content-end">
			<div class="col-2">
				<c:if test="${sessionScope.role=='admin'}">
					<a class="btn btn-primary w-100" href="AddCustomerServlet">AÑADIR
						CUSTOMER</a>
				</c:if>

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
							<th>Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customer}" var="c">
							<tr>
								<td>${c.customerNumber}</td>
								<td>${c.customerName}</td>
								<td>${c.contactFirstName}</td>
								<td>${c.contactLastName}</td>
								<td>${c.phone}</td>
								<c:if test="${sessionScope.role=='user'}">
									<td><a
										href="CustomerReportServlet?customer=${c.customerNumber}"><i
											class="bi bi-pencil-fill"></i></a></td>
								</c:if>


								<c:if test="${sessionScope.role=='admin'}">
									<td><a><i class="bi bi-people-fill"></i></a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>