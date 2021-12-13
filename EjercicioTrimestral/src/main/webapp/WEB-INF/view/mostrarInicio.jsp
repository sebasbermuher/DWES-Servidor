<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>

<head>
<meta charset="UTF-8">
<title>ProductLine</title>
</head>
<body>
<jsp:include page="include/bootstrap.jsp" />
<jsp:include page="include/barra.jsp" />


	
		<p> DATOS DE LA OFICINA DE ${productline.productLine()} </p>
		<ul>
		<li> ${productline.productLine}</li>
		</ul>
		
		
	


</body>
</html>