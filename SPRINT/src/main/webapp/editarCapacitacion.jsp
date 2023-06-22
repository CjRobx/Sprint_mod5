<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="modelo.Capacitacion" %>

<%
	if ( request.getSession().getAttribute("usuario") == null ){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar Capacitación</title>

	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>

<% Capacitacion capa = (Capacitacion) request.getAttribute("capacitacion"); %>

	<form action="CapacitacionUpdate" method="POST" autocomplete="on">
		<fieldset>
		<legend>Editar Capacitación</legend>
		<ul>
			<li>RUT Cliente:
				<input hidden name="id" value="<%= capa.getId() %>">
				<input type="number" name="rut" placeholder="<%= capa.getRutCliente().split("-")[0] %>" 
				  pattern="[0-9]{6,8}" title="RUN sin puntos ni guion" required>
				-
				<input type="text" name="dv" id="dv" placeholder="<%= capa.getRutCliente().split("-")[1] %>"
								pattern="[\dkK]" title="digito o 'k'" required>
			</li>
			<li>Lugar:
				<input type="text" name="lugar" placeholder=" <%= capa.getLugar() %> "
														maxlength="30" required>
			</li>
			<li>Cantidad de Asistentes:
				<input type="number" name="cantAsistentes"
										placeholder="<%= capa.getCantAsistentes() %>" max="1000" min="1">
			</li>
			<li>Fecha:
				<input type="date" name="fecha"
									min="2023-07-01" max="2023-12-01" required>
			</li>
			<li>Hora Inicio:
				<input type="time" name="horaInicio" required>
			</li>
			<li>Hora Termino:
				<input type="time" name="horaTermino" required>
			</li>
		</ul>
       	<a href="UsuarioRead"><button type="button">Atras</button></a>
		<button type="submit">Editar</button>
		<a href="CapacitacionDelete?id=<%= capa.getId()%>"><button type="button">Eliminar</button></a>
		</fieldset>
    </form>

<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>