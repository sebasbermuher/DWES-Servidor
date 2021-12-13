<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="bootstrap.jsp" />

<c:if test="${sessionScope.usuario!=null }">

	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: blue">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav">
				<c:if test="${sessionScope.rol=='usuario'}">
					<li class="nav-item"><a class="nav-link text-white"
						href="${pageContext.request.contextPath}">Inicio</a></li>
					
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/OficinaServlet">Oficinas</a></li>
					</c:if>
					
					<c:if test="${sessionScope.rol=='admin'}">
					<li class="nav-item"><a class="nav-link text-white"
						href="${pageContext.request.contextPath}/Admin/Inicio">Inicio</a></li>
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
		</div>
	</nav>

</c:if>

