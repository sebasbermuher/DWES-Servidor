<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="../include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Añadir Empleados</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
	
		<div class="row justify-content-center mt-3">
			<div class="col-6">
				<form method="post">
					<!-- <label for="customerNumber mt-3" class="form-label">Numero del Cliente</label>
					<input type="text" class="form-control" id="customerNumber" name="employeeNumber" required >	 -->
					<label for="checkNumber" class="form-label mt-3">Nombre del cliente</label>
    				<input type="text" class="form-control" id="lastName" name="customerName" required >	
    				<label for="paymentDate" class="form-label mt-3">Nombre de la persona de contacto</label>
    				<input type="text" class="form-control" id="firstName" name="contactLastName" required>
    				<label for="amount" class="form-label mt-3">Apellido de la persona de contacto</label>
    				<input type="text" class="form-control" id="extension" name="contactFirstName" required>
    				<label for="amount" class="form-label mt-3">Telefono</label>
    				<input type="text" class="form-control" id="phone" name="puesto" required>
    				<label for="amount" class="form-label mt-3">Direccion 1</label>
    				<input type="text" class="form-control" id="addressLine1" name="puesto" required>
    				<label for="amount" class="form-label mt-3">Direccion 2</label>
    				<input type="text" class="form-control" id="addressLine2" name="puesto" required>
    				<label for="amount" class="form-label mt-3">Ciudad</label>
    				<input type="text" class="form-control" id="city" name="puesto" required>
    				<label for="amount" class="form-label mt-3">Estado</label>
    				<input type="text" class="form-control" id="state" name="puesto" required>
    				<label for="amount" class="form-label mt-3">CP</label>
    				<input type="text" class="form-control" id="postalCode" name="puesto" required>
    				<label for="amount" class="form-label mt-3">País</label>
    				<input type="text" class="form-control" id="country" name="puesto" required>
    				<label for="amount" class="form-label mt-3">Empleado</label>
    				<%-- <select class="form-select" id="" name="oficina">
						<c:forEach  items="${offices}" var="o">
							<option value="${o.city}">${o.city}</option>
						</c:forEach>					
					</select> --%>
    				<label for="amount" class="form-label mt-3">Limite de credito</label>
    				<input type="number" class="form-control" id="creditLimit" name="jefe" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />					
				</form>
			</div>
		</div>
	</div>
</body>
</html>