<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Annuncio</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		<div class="page-header">
			<h3>Modifica Annuncio</h3>
		</div>

		<form class="form-horizontal"
			action="<%=request.getContextPath() + "/ExecuteModificaAnnuncioServlet"%>"
			method="post">
			<div class="form-group">
      			<label class="control-label col-sm-2" for="idInputId"></label>
	    		<div class="col-sm-4">
					<input class="form-control"  type="hidden" id="idInputId" name="idAnnuncio" value="${annuncioSingolo.id}">
			 	</div>
  			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="testoAnnuncioId">Testo Annuncio:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="testoAnnuncioId"
						name="testoInput" value="${annuncioSingolo.testoAnnuncio}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="prezzoInputId"
						name="prezzoInput" value="${annuncioSingolo.prezzo}">
				</div>
			</div>
			
			<div class="form-group">
   		 	<label class="control-label col-sm-2" for="categoryInputId">Seleziona Categoria:</label>
   		 	<div class="col-sm-4">
		 	<c:forEach var="categoryItem" items="${listaCategory}">
		 		<c:set var="checked" value="false" />
<%--    		 		<input type="checkbox" id="ruoliInputId" name="ruoliInput" value="${ruoliItem.id}"> ${ruoliItem.codice}<br> --%>
				<c:forEach var="categorieAnnunciItem" items="${annuncioSingolo.category}" >
					<c:if test="${categorieAnnunciItem.id==categoryItem.id && !checked}" >
						<c:set var="checked" value="true"/>
					</c:if>
	 			</c:forEach>
				<input type="checkbox" id="categoryInputId" name="categoryInput" value="${categoryItem.id}" ${checked?"checked='checked'":""}> ${categoryItem.nome} 
   		 	</c:forEach>
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Modifica</button>
<%-- 					<c:if test="${userInfo != null}"> --%>
<!-- 						<a href="PrepareInsertAnnuncioServlet" -->
<!-- 							class="btn btn-primary btn-md">Inserisci Nuovo Annuncio</a> -->
<%-- 					</c:if> --%>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->

</body>
</html>