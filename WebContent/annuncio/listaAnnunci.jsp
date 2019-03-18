<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio Acquisti</h3>
		</div>
		<c:forEach var="listaAnnunciItem" items="${listaAnnuncio}">
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${listaAnnunciItem.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${listaAnnunciItem.testoAnnuncio}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Prezzo</dt>
				<dd class="col-sm-9">${listaAnnunciItem.prezzo}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Stato</dt>
				<dd class="col-sm-9">${listaAnnunciItem.aperto?"In vendita":"Venduto"}</dd>
			</dl>
			<hr> 
			</c:forEach>
			<a href="DettaglioUtenteServlet?idUtente=${userInfo.id}" class="btn btn-info">Torna all'Area Personale</a>
			
			
			

		</div>

	</div>
</body>
</html>