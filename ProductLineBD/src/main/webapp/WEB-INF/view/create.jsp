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
<title>Insertar nuevo producto</title>
</head>
<body>
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-6 mt-5">
		<form method="post">
			<label for="productLine" class="form-label">ProductLine</label>
    		<input name="producto" type="text" class="form-control" id="producto" required >
    			 <c:if test="${requestScope.error!=null }">
    			 <p><small class="text-danger">Categoria ya existente</small></p>
    			</c:if> 
    			
    		<label for="textDescription" class="form-label">TextDescription</label>
    		<textarea class="form-control" id="textDescription" name="textDescription" required>
    			<c:if test="${requestScope.error!=null}">
    			<c:out value="${requestScope.texto}">
    			</c:out>
    			</c:if>
    		</textarea>
    		
    		<label for="htmlDescription" class="form-label">HTMLDescription</label>
    		<textarea class="form-control" id="htmlDescription" name="htmlDescription" required>
    			<c:if test="${requestScope.error!=null}">
    			<c:out value="${requestScope.html}">
    			</c:out>
    			</c:if>
    		</textarea>
    		<input type="submit" value="Insertar" class="btn btn-primary w-100 mt-5">
		</form>
		</div>
	</div>
</div>
</body>
</html>