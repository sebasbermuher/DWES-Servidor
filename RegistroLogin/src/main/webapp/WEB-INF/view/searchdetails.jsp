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
<title>Detalles del producto</title>
</head>
<body>

	<p><a href="Search">Atras<i class="bi bi-arrow-return-left"></i></a></p>

	<div class="container">
		<div class="row justify-content-center">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>productCode</th>
						<th>productName</th>
						<th>productLine</th>
						<th>productScale</th>
						<th>productVendor</th>
						<th>productDescription</th>
						<th>quantityInStock</th>
						<th>buyPrice</th>
						<th>MSRP</th>
					</tr>
				</thead>
				<tbody>
					 <c:forEach items="${productos}" var="p">
                        <tr>
                            <td>${p.productCode}</td>
                            <td>${p.productName}</td>
                            <td>${p.productLine}</td>
                            <td>${p.productScale}</td>
                            <td>${p.productVendor}</td>
                            <td>${p.productDescription}</td>
                            <td>${p.quantityInStock}</td>
                            <td>${p.buyPrice}$</td>
                            <td>${p.msrp}</td>
                        </tr>
                    </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>