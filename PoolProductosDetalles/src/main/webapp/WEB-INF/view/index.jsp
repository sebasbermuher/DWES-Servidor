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
<title>Productos</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp"></jsp:include>

		<div class="row justify-content-center">

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ProductCode</th>
						<th>ProductName</th>
						<th>ProductLine</th>
						<th>ProductScale</th>
						<th>ProductVendor</th>
						<th>ProductDescription</th>
						<th>QuantityInStock</th>
						<th>BuyPrice</th>
						<th>MSRP</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productos}" var="prod">
						<tr>
							<td>${prod.productCode}</td>
							<td>${prod.productName}</td>
							<td>${prod.productLine}</td>
							<td>${prod.productScale}</td>
							<td>${prod.productVendor}</td>
							<td>${prod.productDescription}</td>
							<td>${prod.quantityInStock}</td>
							<td>${prod.buyPrice}</td>
							<td>${prod.MSRP}</td>
							<td><a href="Detalles?codigo=${prod.productCode}"><i
									class="bi bi-plus-circle-fill"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>