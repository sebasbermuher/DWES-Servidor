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


			<div class="row justify-content-center">
				<div class="col-10">
					<div class="row justify-content-end">
						<div class="col-2">
							<%-- 				<a class="btn btn-primary w-100"
								href="${pageContext.request.contextPath}/Admin/AddCustomerServlet">AÑADIR
								CUSTOMER</a> --%>
						</div>
					</div>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>OrderNumber</th>
								<th>OrderDate</th>
								<th>requiredDate</th>
								<th>ShippedDate</th>
								<th>Status</th>
								<th>comments</th>
								<th>customerNumber</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order}" var="o">
								<tr>
									<td>${o.orderNumber}</td>
									<td>${o.orderDate}</td>
									<td>${o.requiredDate}</td>
									<td>${o.shippedDate}</td>
									<td>${o.status}</td>
									<td>${o.comments}</td>
									<td>${o.customerNumber}</td>

									<%-- <td><a
										href="${pageContext.request.contextPath}CustomerReportServlet"><i
											class="bi bi-person-circle"></i></td> --%>

									<c:if test="${sessionScope.role=='user'}">
										<td><a href="OrderReportServlet?order=${o.orderNumber}"><i
												class="bi bi-eye-fill"></i></a></td>
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
</body>
</html>