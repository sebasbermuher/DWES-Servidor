<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola Mundo JSP</title>
</head>
<body>
<h1>Hola Mundo JSP</h1>
<h1>ADIOS Mundo JSP</h1>
<h3 style="color:green">La fecha de hoy es: <%=new Date() %></h3>
<ul>
<%    
    /* response.getWriter().println("<ul>"); */
    /* out.println("<ul>"); */
        for(int i = 0; i<101 ; i++){
            /* response.getWriter().println("<li>" + i + "</li>"); */
            /* out.println("<li>" + i + "</li>"); */
    %>
    
    <li> <%= i %> </li>
    
    <%}  
    /* response.getWriter().println("</ul>"); */
    /* out.println("</ul>"); */
    %>
    
    </ul>
</body>
</html>