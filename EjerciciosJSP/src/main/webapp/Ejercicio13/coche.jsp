<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Esta es la configuracion de su coche</h2>

<% 
      String tapiceria = request.getParameter("tapiceria");
      String moldura = request.getParameter("moldura");
      String imagen = tapiceria + moldura + ".jpg";
      %>
    <p><img src="<%= imagen %>" width="400"></p>

</body>
</html>