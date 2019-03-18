<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Annuncio</title>
</head>
<body>


	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Conferma Acquisto</h3>
		</div>
		<div class="container-fluid">
<!-- 			<dl class="row"> -->
<!-- 				<dt class="col-sm-3 text-right">Azioni</dt> -->
<!-- 				<dd class="col-sm-9"> -->
<%-- 					<a href="ExecuteAcquistoServlet?idCartella=${annuncioSingolo.id}" --%>
<!-- 						class="btn btn-info">Acquista</a> -->
<%-- <a href="PrepareEliminaCartellaServlet?idCartella=${annuncioSingolo.id}" class="btn btn-danger">Elimina</a> --%>
<!-- 				</dd> -->
<!-- 			</dl> -->
			<hr>
			<dl class="row">
				<dt class="col-sm-3 text-right">Grazie per i tuoi danari!</dt>
				<dd class="col-sm-9">${annuncioSingolo.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${annuncioSingolo.testoAnnuncio}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Prezzo</dt>
				<dd class="col-sm-9">${annuncioSingolo.prezzo}</dd>
			</dl>

			<hr>
			<!-- 			<dl class="row"> -->
			<!-- 				<dt class="col-sm-3 text-right">Contribuente</dt> -->
			<%-- 				<dd class="col-sm-9"><a href="DettaglioContribuenteServlet?idContribuente=${cartellaAttributeName.contribuente.id}" class="btn btn-info">Dettagli</a>  ${cartellaAttributeName.contribuente.nome} ${cartellaAttributeName.contribuente.cognome}</dd> --%>
			<!-- 			</dl> -->

		</div>

	</div>

</body>
</html>