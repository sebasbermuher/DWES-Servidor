<%@page import="org.iesalixar.servidor.model.sbh.Usuarios"%>

<div class="d-flex justify-content-end">
	<p><%= ((Usuarios)session.getAttribute("usuario")).getNombre()%></p>
	<a href="Logout">Logout</a>
</div>