<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.usuario!=null}">
	<div class="row justify-center-end bg-primary">
		<div class="col-10">
			<p class="text-white">
				<a class="text-white" href="Profile?user=${sessionScope.usuario}"><i
					class="bi bi-person"></i>
				<c:out value="${sessionScope.usuario}" /></a> 
				
				<a class="text-white"
					href="${pageContext.request.contextPath}/LogOut"><i
					class="bi bi-box-arrow-left"></i>Logout</a>
			</p>
		</div>
	</div>
</c:if>
