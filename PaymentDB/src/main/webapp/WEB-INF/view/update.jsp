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
<title>Actualizacion del pago</title>
</head>
<body>
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-6 mt-5">
		<form method="post">
			<label for="customerNumber" class="form-label">CustomerNumber</label>
    		<input name="cn" value="${pago.customerNumber}" type="text" class="form-control" id="customerNumber" disabled>
    		
    		<label for="checkNumber" class="form-label">CheckNumber</label>
    		<input name="checkn" value="${pago.checkNumber}" type="text" class="form-control" id="checkNumber" disabled>
    		
    		<label for="paymentDate" class="form-label">PaymentDate</label>
    		<input name="paymentDate" value="${pago.paymentDate}" type="date" class="form-control" id="paymentDate">
    		
    		<label for="amount" class="form-label">amount</label>
    		<input name="amount" value="${pago.amount}" type="text" class="form-control" id="amount">
    		
    		<input type="submit" value="Actualizar" class="btn btn-primary w-100 mt-5">
		</form>
		</div>
	</div>
</div>
</body>
</html>