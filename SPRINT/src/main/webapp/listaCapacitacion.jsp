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
	<title>Capacitaciones Agendadas</title>
	
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>

<div class="">
	<h1 class="centrar">Agenda de Capacitaciones</h1>
	<table class="tabla">
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Rut Cliente</th>
	            <th>Lugar</th>
	            <th>Fecha</th>
	            <th>Cantidad de Asistentes</th>
	            <th>Hora Inicio</th>
	            <th>Hora Termino</th>
	            <th></th>
	        </tr>
	    </thead>
	    <tbody>
	    <% List<Capacitacion> lista = (List<Capacitacion>) request.getAttribute("capacitaciones"); %>
	    	<% if (lista != null) { %>
	        	<% for ( Capacitacion capacitacion : lista ){ %>
	            <tr>
	            	<td><%= capacitacion.getId() %></td>
	                <td><%= capacitacion.getRutCliente() %></td>
	                <td><%= capacitacion.getLugar() %></td>
	                <td><%= capacitacion.getFecha() %></td>
	                <td><%= capacitacion.getCantAsistentes() %></td>
	                <td><%= capacitacion.getHoraInicio() %></td>
	                <td><%= capacitacion.getHoraTermino() %></td>
	                <td>
                            <a href="CapacitacionDetalle?id=<%= capacitacion.getId() %>">Editar</a>
                            <a href="CapacitacionDelete?id=<%= capacitacion.getId() %>">Eliminar</a>
                   </td>
	        	</tr>
	    	<% } %>
	    <% } %>
	    </tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
</body>
</html>