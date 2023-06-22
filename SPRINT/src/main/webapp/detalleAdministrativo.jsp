<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="modelo.Administrativo" %>

<%
	if ( request.getSession().getAttribute("usuario") == null ){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Administrativo</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>

<!-- Formato de Ventana -->
<!-- Podría desplegar por GRID -->
<!-- Consutlar opciones a CJ -->
<% Administrativo user = (Administrativo) request.getAttribute("admin"); %>

<form>
	<fieldset>
		<legend>Administrativo</legend>
		<ul>
			<li>RUT:
			<input disabled placeholder="<%= user.getRut().split("-")[0] %>">
			-
			<input disabled placeholder="<%= user.getRut().split("-")[1] %>" id="dv">
			</li>
			<li>Nombres: <input disabled
				placeholder=" <%= user.getNombres() %> ">
			</li>
			<li>Fecha Nacimiento: <input disabled
				placeholder=" <%= user.getFechaNacimiento().toString() %> ">
			</li>
			<li>Area: <input disabled placeholder=" <%= user.getArea() %> ">
			</li>
			<li>Experiencia Previa: <input disabled
				placeholder=" <%= user.getExperienciaPrevia() %> ">
			</li>
		</ul>
		<a href="UsuarioRead"><button type="button">Atras</button></a>
		<a href="AdministrativoEditar?rut=<%= user.getRut()%>"><button type="button">editar</button></a>
		<a href="UsuarioDelete?rut=<%= user.getRut()%>"><button type="button">Eliminar</button></a>
	</fieldset>
</form>

<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script> <%@include file="/WEB-INF/js/formulario.js"%> </script>
</body>
</html>