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
<title>Oficinas</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp"></jsp:include>

		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>OfficeCode</th>
							<th>City</th>
							<th>Phone</th>
							<th>AddressLine1</th>
							<th>AddressLine2</th>
							<th>State</th>
							<th>Country</th>
							<th>PostalCode</th>
							<th>Territory</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${oficinas}" var="ofi">
							<tr>
								<td>${ofi.officeCode}</td>
								<td>${ofi.city}</td>
								<td>${ofi.phone}</td>
								<td>${ofi.addressLine1}</td>
								<td>${ofi.addressLine2}</td>
								<td>${ofi.state}</td>
								<td>${ofi.country}</td>
								<td>${ofi.postalCode}</td>
								<td>${ofi.territory}</td>
								<td><a href="Empleados?codigo=${ofi.officeCode}"><i
										class="bi bi-person-circle"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>