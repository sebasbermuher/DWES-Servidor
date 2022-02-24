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


		<jsp:include page="include/barra.jsp" />
		<div class="container mt-5">

			<h1>
				<fmt:message key="ordersTable" />
			</h1>
			<div class="row justify-content-center">
				<div class="col-10">
					<div class="row justify-content-end"></div>
					<table class="table table-striped table-hover">
						<thead>
							<tr>

								<th><fmt:message key="orderNumber" /></th>
								<th><fmt:message key="orderDate" /></th>
								<th><fmt:message key="shippedDate" /></th>
								<th><fmt:message key="status" /></th>
								<th><fmt:message key="opciones" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order}" var="o">
								<tr>
									<td>${o.orderNumber}</td>
									<td>${o.orderDate}</td>
									<td>${o.shippedDate}</td>
									<td>${o.status}</td>
									<%-- <td><a
										href="${pageContext.request.contextPath}CustomerReportServlet"><i
											class="bi bi-person-circle"></i></td> --%>

									<c:if test="${sessionScope.role=='user'}">
										<td><a href="OrderReport?on=${o.orderNumber}"><i
												class="bi bi-eye-fill"></i></a></td>
									</c:if>


									<c:if test="${sessionScope.role=='admin'}">
										<td><a href="Admin/ChangeOrderCustomer?on=${o.orderNumber}"><i class="bi bi-people-fill"></i></a></td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</body>
</html>