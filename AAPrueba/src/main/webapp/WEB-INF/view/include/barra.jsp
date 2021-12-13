<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.usuario!=null}">
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link text-white"
					href="${pageContext.request.contextPath}/Inicio">Inicio</a></li>
				<c:if test="${role=='usuario'}">
					<!-- <li class="nav-item"><a class="nav-link text-white" href="#">Buscar</a></li> -->
					<li class="nav-item"><a class="nav-link text-white"
						href="${pageContext.request.contextPath}/Oficina">Buscar
							Oficinas</a></li>
				</c:if>

				<li class="nav-item">
					<p class="nav-link text-white">
						Está usted logeado como:
						<c:out value="${sessionScope.usuario}"></c:out>
					</p>
				</li>

				<li class="nav-item"><a class="nav-link text-white"
					href="${pageContext.request.contextPath}/LogOut">Salir<i
						class="bi bi-box-arrow-left"></i></a></li>
			</ul>

		</div>
	</nav>
</c:if>