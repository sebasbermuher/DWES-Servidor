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
<title>Añadir Producto</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
	
		<div class="row justify-content-center mt-3">
			<div class="col-6">
			<h1>Add Product</h1>
			 <form method="post">
	
					<label for="productCode" class="form-label mt-3">Product Code</label>
    				<input type="text" class="form-control"  name="productCode" required >	
    				<label for="productName" class="form-label mt-3">Product Name</label>
    				<input type="text" class="form-control" id="firstName" name="productName" required>
    				<%-- <label for="productLine" class="form-label mt-3">Product Line</label>
    				 <select class="form-select" id="" name="productLine">
						<c:forEach  items="${offices}" var="o">
							<option value="${o.city}">${o.city}</option>
						</c:forEach>					
					</select>  --%>
    				<label for="productScale" class="form-label mt-3">Product Scale</label>
    				<input type="text" class="form-control" id="phone" name="productScale" required>
    				<label for="productVendor" class="form-label mt-3">Product Vendor</label>
    				<input type="text" class="form-control" id="addressLine1" name="productVendor" required>
    				<label for="productDescription" class="form-label mt-3">Product Description</label>
    				<input type="text" class="form-control" id="addressLine2" name="productDescription" required>
    				<label for="quantityInStock" class="form-label mt-3">Stock</label>
    				<input type="number" class="form-control" id="city" name="quantityInStock" required>
    				<label for="buyPrice" class="form-label mt-3">Buy Price</label>
    				<input type="number" class="form-control" id="state" name="buyPrice" required>
    				<label for="MSRP" class="form-label mt-3">MSRP</label>
    				<input type="number" class="form-control" id="postalCode" name="MSRP" required>
    			
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />					
				</form> 
			</div>
		</div>
	</div>
</body>
</html>