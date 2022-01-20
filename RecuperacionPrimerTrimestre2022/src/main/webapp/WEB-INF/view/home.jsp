<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="include/bootstrap.jsp" />
<fmt:setBundle basename="interface" />
<title>Home</title>
</head>
<body>

	

		
			<div class="col-16">
				<!-- Solo saco el formulario de login si no tengo sesion -->
				<c:if test="${sessionScope.role eq 'admin'}">

					<jsp:include page="include/barra.jsp" />
					<div class="container mt-5">


						<div class="row justify-content-center">
							<div class="col-10">
								<div class="row justify-content-end">
									<div class="col-2">
										<a class="btn btn-primary w-100" href="${pageContext.request.contextPath}/Admin/AddCustomerServlet">AÑADIR
											CUSTOMER</a>
									</div>
								</div>
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
										<c:forEach items="${customer}" var="cust">
											<tr>
												<td>${cust.customerNumber}</td>
												<td>${cust.customerName}</td>
												<td>${cust.contactFirstName}</td>
												<td>${cust.contactLastName}</td>
												<td>${cust.phone}</td>
												<td><a href="${pageContext.request.contextPath}CustomerReportServlet"><i class="bi bi-person-circle"></i></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
			
				</c:if>



				<c:if test="${sessionScope.role eq 'user'}">

					<jsp:include page="include/barra.jsp" />
					<div class="container mt-5">


						<div class="row justify-content-center">
							<div class="col-10">
								<table class="table table-striped table-hover">
									<thead>
										<tr>
										<th><fmt:message key="numcliente"/></th>
											<th><fmt:message key="nombrecliente"/></th>
											<th><fmt:message key="nombrecontacto"/></th>
											<th><fmt:message key="apellidoscontacto"/></th>
											<th><fmt:message key="telefono"/></th>
											<th><fmt:message key="opciones"/></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${customer}" var="cust">
											<tr>
												<td>${cust.customerNumber}</td>
												<td>${cust.customerName}</td>
												<td>${cust.contactFirstName}</td>
												<td>${cust.contactLastName}</td>
												<td>${cust.phone}</td>
												<td><a href="CustomerReportServlet"><i class="bi bi-eye-fill"></i></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>