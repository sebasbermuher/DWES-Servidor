

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />

<title>Empleados</title>
</head>
<body>

	<div class="container mt-5">
		<jsp:include page="../include/barra.jsp" />

		<div class="row justify-content-center">

			
			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Numero</th>
							<th>Apellidos</th>
							<th>Nombre</th>
							<th>Puesto</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaEmpleados}" var="empl">
							<tr>
								<td>${empl.employeeNumber}</td>
								<td>${empl.lastName}</td>
								<td>${empl.firstName}</td>
								<td>${empl.jobTitle}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>