<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.usuario!=null}">
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link text-white"
					href="${pageContext.request.contextPath}/Inicio">Inicio</a></li>
				<c:if test="${role=='usuario'}">
				<li class="nav-item"><a class="nav-link text-white" href="#">Buscar</a></li>
				<li class="nav-item"><a class="nav-link text-white" href="${pageContext.request.contextPath}/Oficina">Oficinas</a>
				</li>
				</c:if>
			</ul>
			<span class="navbar-text d-flex">
					
						<p class="text-white">
							Está usted logeado como:
							<c:out value="${sessionScope.usuario}"></c:out>
						</p>
				
					<a class="text-white"
						href="${pageContext.request.contextPath}/LogOut"><i
							class="bi bi-box-arrow-left"></i></a>
				</span>
		</div>
	</nav>
</c:if>