<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="modelo.Administrativo" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar Usuario</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<% Administrativo user = (Administrativo) request.getAttribute("admin"); %>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>

<!-- Formulario Usuario Administrativo -->
    <form action="AdministrativoUpdate" method="POST" autocomplete="on">
        <fieldset>
            <legend>Editar Administrativo</legend>
                <ul>
                <li>RUT:
			 		<input type="hidden" name="rut" value="<%= user.getRut() %>">
					<input placeholder="<%= user.getRut().split("-")[0] %>" disabled>
					-
					<input placeholder="<%= user.getRut().split("-")[1] %>" disabled id="dv">
				</li>
                <li>Nombres:
                    <input type="text" name="nombres" placeholder="<%= user.getNombres() %>"
                                                    pattern="[\w+ ]+" required>
                </li>
                <li>Fecha Nacimiento:
                    <input type="date" name="fechaNacimiento"
                                                    max="2005-06-01" required>
                </li>
                <li>Area:
                    <input type="text" name="area" placeholder="<%= user.getArea() %>" pattern="[\w+ ]+"
                                                        maxlength="20" required>
                </li>
                <li>Experiencia Previa:
                    <input type="text" maxlength="50" pattern="[\w\d+ ]+" placeholder="<%= user.getExperienciaPrevia() %>"
                                    name="experienciaPrevia" required>
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
