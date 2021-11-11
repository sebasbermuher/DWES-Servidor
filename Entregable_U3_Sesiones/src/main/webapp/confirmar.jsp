<%@page import="org.iesalixar.servidor.sbh.model.ReservaFinal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserva Confirmada</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="barra.jsp"></jsp:include>
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-6">
		
		<jsp:useBean id="reserva" scope="request" class="org.iesalixar.servidor.sbh.model.ReservaFinal"/>
			<h1>Reserva Confirmada</h1>

			<h4>Fecha de incio: <%= reserva.getFecha_incio() %></h4>
			<h4>Fecha de finalizacion: <%= reserva.getFecha_final() %></h4>
			<h4>Numero de personas: <%= reserva.getNum_personas() %></h4>
			<h4>Servicios reservados:</h4>
			
			<% String[] servicios = reserva.getServicios(); %>
			
			<% for(String s:servicios){ %>
			
			<p><%= s %></p>
			
			<% }%>
					
		</div>
	</div>
</div>
</body>
</html>