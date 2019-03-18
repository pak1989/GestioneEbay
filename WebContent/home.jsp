<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Annunci</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		<div class="page-header">
			<h3>Ricerca Annunci</h3>
		</div>

		<form class="form-horizontal"
			action="<%= request.getContextPath()%>/ExecuteSearchAnnuncioServlet"
			action="${pageContext.request.contextPath}/ExecuteSearchAnnuncioServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="testoAnnuncioId">Testo Annuncio:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="testoAnnuncioId"
						name="testoInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="prezzoInputId"
						name="prezzoInput">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="categoryInputId">Seleziona Categoria:</label>
				<div class="col-sm-4">

					<c:forEach var="categoryItem" items="${listaCategory}">
						<input type="checkbox" id="categoryInputId" name="categoryInput"
							value="${categoryItem.id}"> ${categoryItem.nome}<br>
					</c:forEach>
				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Ricerca</button>
					<c:if test="${userInfo != null}">
						<a href="PrepareInsertAnnuncioServlet"
							class="btn btn-primary btn-md">Inserisci Nuovo Annuncio</a>
					</c:if>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->

</body>
</html>