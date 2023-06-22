<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="modelo.Profesional" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar Usuario</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>

<% Profesional user = (Profesional) request.getAttribute("prof"); %>

<!-- Formulario Usuario Profesional -->
    <form action="ProfesionalUpdate" method="POST" autocomplete="on">
        <fieldset>
            <legend>Editar Profesional</legend>
             <ul>
                <li>RUT:
			 		<input type="hidden" name="rut" value="<%= user.getRut() %>">
					<input placeholder="<%= user.getRut().split("-")[0] %>" disabled>
					-
					<input placeholder="<%= user.getRut().split("-")[1] %>" disabled id="dv">
				</li>
                <li>Nombre:
                    <input type="text" name="nombre" placeholder="<%= user.getNombres() %> "
                                                    pattern="[\w+ ]+" required>
                </li>
                <li>Fecha Nacimiento:
                    <input type="date" name="fechaNacimiento"
                                                    max="2005-06-01" required>
                </li>
                <li>Titulo:
                    <input type="text" name="titulo" pattern="[\w+ ]+"
                    	placeholder=" <%= user.getTitulo() %>" maxlength="30" required>
                </li>
                <li>Fecha Ingreso:
                    <input type="date" name="fechaIngreso"
                                                    max="2023-07-01" required>
                </li>
                </ul>
            <button type="submit">Enviar</button>
        </fieldset>		
    </form>

<jsp:include page="/WEB-INF/piezas/Footer.jsp"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script> <%@include file="/WEB-INF/js/formulario.js"%> </script>
</body>
</html>
