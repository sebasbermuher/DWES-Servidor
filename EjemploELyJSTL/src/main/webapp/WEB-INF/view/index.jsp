<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EJEMPLO</h1>

<p>${pageContext.request.method}</p>
<p>${saludo}</p>
<p>${sessionScope.saludo}</p>
<p>${requestScope.saludo}</p>
<p>${3+7}</p>
<p><c:out value="ESTO ES UN C:OUT"></c:out></p>




</body>
</html>