<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward</title>
</head>
<body>
<% 
        if((request.getParameter("usuario")).equals("admin") 
            && (request.getParameter("password")).equals("admin")){
    %>
    <jsp:forward page="admin.jsp"/>
    <%
        }
    if((request.getParameter("usuario")).equals("usuario") 
            && (request.getParameter("password")).equals("usuario")){
    %>
    <jsp:forward page="usuario.jsp"/>
    <% } else { %>
    <%-- <%@include file = "login.jsp"--%> 
    <jsp:forward page="login.jsp">
        <jsp:param name="error" value="Login incorrecto"/>
    </jsp:forward>
    <!-- <div style="color:red">Login Incorrecto</div> --> 
    <% } %>
</body>
</html>