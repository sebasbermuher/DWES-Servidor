<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="include/bootstrap.jsp"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
		
			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ProductLine</th>
							<th>TextDescription</th>
							<th>HTMLDescription</th>
							<th>Acciones</th>
							<th><a href="Insert?productLine=${productos.productLine}"><i class="bi bi-plus-circle-dotted"></i></a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listadoProductos}" var="productos">
							<tr>
								<td>${productos.productLine}</td>
								<td>${productos.textDescription}</td>
								<td>${productos.htmlDescription}</td>
							
								<td><a href="Update?productLine=${productos.productLine}"><i class="bi bi-pencil-fill"></i></a>
									<a href="Remove?productLine=${productos.productLine}"><i class="bi bi-trash-fill"></i></a>
								</td>
							</tr>
						 </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>