<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Utente</title>
</head>
<body>


	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Azioni</dt>
					<dd class="col-sm-9">
						<a href="${pageContext.request.contextPath}/ExecuteListaAcquistiServlet?idUtente=${utenteAttributeName.id}" class="btn btn-info">Acquisti effettuati</a>
						<a href="${pageContext.request.contextPath}/ExecuteListaAnnunciServlet?idUtente=${utenteAttributeName.id}" class="btn btn-success">Annunci pubblicati</a>
					</dd>
			</dl>
			<hr>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${utenteAttributeName.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${utenteAttributeName.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Username</dt>
				<dd class="col-sm-9">${utenteAttributeName.username}</dd>
			</dl>
<!-- 			<dl class="row"> -->
<!-- 				<dt class="col-sm-3 text-right">Data</dt> -->
<%-- 				<dd class="col-sm-9">${utenteAttributeName.dataRegistrazione}</dd> --%>
<!-- 			</dl>							 -->
			<hr>
<%-- 			<c:forEach items="${utenteAttributeName.annunci}" var="annuncio"> --%>
<!-- 				<dl class="row"> -->
<%-- 					<dt class="col-sm-3 text-right">Ruolo: ${annuncio.id}</dt> --%>
<%-- 					<dd class="col-sm-9"> ${annuncio.descrizione}</dd> --%>
<!-- 				</dl> -->
<%-- 			</c:forEach> --%>
			
		</div>

	</div>

</body>
</html>