<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Mi Cuenta</title>
</head>
<body>
<jsp:include page="include/barra.jsp"></jsp:include>
<p><a href="Search">Atras<i class="bi bi-arrow-return-left"></i></a></p>
	<h1>Mi cuenta</h1>
	<p>
		Bienvenido ${sessionScope.usuario} </p>
	<p>
		(¿No eres ${sessionScope.usuario} ? <a href="LogOut">Cerrar sesión</a>)
	</p>

	<div class="card card-outline-secondary"
		style="width: 500px; position: relative; left: 100px; top: 10px">
		<div class="card-header">
			<h3 class="mb-0">Cambiar Contraseña</h3>
		</div>
		<div class="card-body">
			<form class="form" role="form" autocomplete="off" method="POST">
				<div class="form-group">
					<label for="inputPasswordOld">Contraseña Actual</label> <input
						type="password" class="form-control" id="inputPasswordOld"
						required="" name="currentPswd">
				</div>
				<div class="form-group">
					<label for="inputPasswordNew">Nueva Contraseña</label> <input
						type="password" class="form-control" id="inputPasswordNew"
						required="" name="newPswd"> 
				</div>
				<div class="form-group">
					<label for="inputPasswordNewVerify">Confirma la nueva contraseña</label> <input
						type="password" class="form-control" id="inputPasswordNewVerify"
						required="" name="confirmPswd">

					<c:if test="${requestScope.diferentes != null}">
						<div class="alert alert-danger" role="alert">Las contraseñas
							no son iguales</div>
					</c:if>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success btn-lg float-right">Guardar</button>
				</div>
			</form>
		</div>
	</div>


	<div class="card card-outline-secondary"
		style="width: 500px; position: relative; left: 800px; top: -310px">
		<div class="card-header">
			<h3 class="mb-0">Mis pedidos</h3>
		</div>
		<div class="card-body">


			<table class="table table-striped">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Producto</th>
						<th>Categoria</th>
						<th>Precio</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${requestScope.cesta}" var="cesta">
						<tr>
							<td>${cesta.productCode}</td>
							<td>${cesta.productName}</td>
							<td>${cesta.productLine}</td>
							<td>${cesta.buyPrice}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>




			<%--<p> ${requestScope.cesta.getProductCode()} | ${requestScope.cesta.getProductName()} | ${requestScope.cesta.getBuyPrice()}$</p> 
			 ${requestScope.cesta} --%>

		</div>
	</div>

</body>
</html>

</body>
</html>