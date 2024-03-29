<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.iesalixar.servidor.sbh.model.Payment" import="java.util.ArrayList" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pagos</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
		
			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>CustomerNumber</th>
							<th>CheckNumber</th>
							<th>Date</th>
							<th>Amount</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagos}" var="pago">
							<tr>
								<td>${pago.customerNumber}</td>
								<td>${pago.checkNumber}</td>
								<td>${pago.paymentDate}</td>
								<c:choose>
									<c:when test="${pago.amount >=0 and pago.amount<10000}">
										<td class="text-primary">${pago.amount}
									</c:when>
									<c:when test="${pago.amount >=10000 and pago.amount<20000}">
									<td class="text-secondary">${pago.amount}
									</c:when>
									<c:when test="${pago.amount >=20000 and pago.amount<30000}">
									<td class="text-warning">${pago.amount}
									</c:when>
									<c:otherwise>
									<td class="text-danger">${pago.amount}
									</c:otherwise>
								</c:choose>
							
								<td><a href="Update?cn=${pago.customerNumber}&checkn=${pago.checkNumber}"><i class="bi bi-pencil-fill"></i></a>
									<a href="Remove?cn=${pago.customerNumber}&checkn=${pago.checkNumber}"><i class="bi bi-trash-fill"></i></a>
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