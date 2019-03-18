<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Static navbar -->
<nav class="navbar navbar-expand-lg navbar-light " style="background-color: #e3f2fd;">

	<a class="navbar-brand" href="${pageContext.request.contextPath}/PrepareSearchAnnuncioServlet"><img style="height:50px;" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/EBay_logo.png/800px-EBay_logo.png" /></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
			<a  class="btn btn-outline-secondary btn-md" href="${pageContext.request.contextPath}/PrepareSearchAnnuncioServlet">Home
<%-- 			<a style="height:10px;" href="${pageContext.request.contextPath}/PrepareSearchAnnuncioServlet"><img style="" src="/img/800px-EBay_logo.png" /></a> --%>
					<span class="sr-only">(current)</span>
			</a></li>
<!-- 			<li class="nav-item dropdown"><a -->
<!-- 				class="nav-link dropdown-toggle" href="#" id="navbarDropdown" -->
<!-- 				role="button" data-toggle="dropdown" aria-haspopup="true" -->
<!-- 				aria-expanded="false"> Dropdown </a> -->
<!-- 				<div class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!-- 					<a class="dropdown-item" href="#">Action</a> <a -->
<!-- 						class="dropdown-item" href="#">Another action</a> -->
<!-- 					<div class="dropdown-divider"></div> -->
<!-- 					<a class="dropdown-item" href="#">Something else here</a> -->
<!-- 				</div></li> -->
		</ul>
		 <ul class="nav navbar-nav navbar-right">
            <li><p class="navbar-text">
				
				<c:if test="${userInfo.isAdmin()}">
				   	<a class="btn btn-outline-warning btn-md"  href="${pageContext.request.contextPath}/admin/PrepareSearchUtenteServlet">Area Admin</a></p>
				</c:if>
				
<%-- 			    <c:forEach items="${userInfo.ruoli}" var="ruolo"> --%>
<%-- 			    	<c:if test="${ruolo.codice == 'ADMIN_ROLE'}"> --%>
<%-- 				    		<a class="btn btn-outline-warning btn-md"  href="${pageContext.request.contextPath}/admin/PrepareSearchUtenteServlet">Area Admin</a></p> --%>
<%-- 					</c:if> --%>
<%-- 				</c:forEach> --%>
	            
	            <c:if test="${userInfo != null}">
	            	<a class="btn btn-outline-success btn-md" href="${pageContext.request.contextPath}/DettaglioUtenteServlet?idUtente=${userInfo.id}">Area personale</a>
					<a class="btn btn-danger btn-md" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
				</c:if>
				
				<c:if test="${userInfo == null}">
		            <a class="btn btn-success btn-md" href="${pageContext.request.contextPath}/login.jsp">Login</a> 
	            </c:if>

            </li>
          </ul>
	</div>
</nav>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.js"></script>
<script	src="${pageContext.request.contextPath}/js/jqueryUI/jquery-ui.min.js"></script>