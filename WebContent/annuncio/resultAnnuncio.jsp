<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="it.prova.gestioneebay.model.Annuncio"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati Utenti</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Testo</th>
				<th>Prezzo</th>				
				<th>Categoria Appartenenza</th>
				<th>Azioni</th>
			</tr>
		</thead>
		
		
			
			<c:forEach var="listaAnnuncioItem" items="${listAnnunciName}">
			<tr>
				<td>${listaAnnuncioItem.testoAnnuncio}</td>
				<td>${listaAnnuncioItem.prezzo}</td>
				
				
				<td>
				<c:forEach var="categoryItem" items="${listaAnnuncioItem.category}">
   		 				${categoryItem.nome }<br>		 		
   		 	</c:forEach>
				</td>
				<td>
					<a href="DettaglioAnnuncioServlet?idAnnuncio=${listaAnnuncioItem.id}" class="btn btn-info">Dettaglio</a>
<%-- 					<a href="PrepareUpdateAnnuncioServlet?idAnnuncio=${listaAnnuncioItem.id}" class="btn btn-info">Modifica</a> --%>
<%-- 					<a href="PreparaDeleteAnnuncioServlet?idAnnuncio=${listaAnnuncioItem.id}" class="btn btn-danger">Elimina</a> --%>
				</td>
			</tr>
				
</c:forEach>
	
	</table>
<!-- 	<a href="PrepareInsertAnnuncioServlet" class="btn btn-info">Inserisci Nuovo Elemento</a> -->
<%@ include file="../footer.jsp" %>
</body>
</html>