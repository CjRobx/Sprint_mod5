<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="modelo.Cliente" %>

<%
	if ( request.getSession().getAttribute("usuario") == null ){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar Usuario</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<jsp:include page="/WEB-INF/piezas/NavBar.jsp"/>
<% Cliente user = (Cliente) request.getAttribute("cliente"); %>
<!-- Formulario Usuario Cliente -->
    <form action="ClienteUpdate" method="POST" autocomplete="on">
		<fieldset>
		<legend>Editar Cliente</legend>
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
			<li>Apellidos:
				<input type="text" name="apellidos"
					placeholder="<%= user.getApellidos() %>" pattern="[\w+ ]+" required>
			</li>
			<li>Fecha Nacimiento:
				<input type="date" name="fechaNacimiento"
												max="2005-06-01" required>
			</li>
			<li>Celular: +(56)
				<input type="tel" name="telefono" placeholder="<%= user.getTelefono() %>"
							pattern="[0-9]{8}" title="solo numeros" required>
			</li>
			<li>Sistema de Salud:
                <input type="radio" id="isapre" name="sistemaSalud"
														value="Isapre" required>
                <label for="isapre">Isapre</label>
                <input type="radio" id="fonasa" name="sistemaSalud"
																value="Fonasa">
                <label for="fonasa">Fonasa</label>
			</li>
			<li>AFP:
				<!-- debería ser una [combobox] -->
				<select name="afp" id="afp" required>
					<option value="Capital">Capital</option>
					<option value="Cuprum">Cuprum</option>
					<option value="Habitat">Habitat</option>
					<option value="Modelo">Modelo</option>
					<option value="Plan Vital">Plan Vital</option>
					<option value="Provida">Provida</option>
					<option value="Uno">Uno</option>
					<option value="Futuro">Futuro</option>
					<option value="Summa">Summa</option>
					<option value="Aporta">Aporta</option>
					<option value="Magister">Magister</option>
				</select>
			</li>
			<li>Dirección:
				<input type="text" name="direccion"
							placeholder=" <%= user.getDireccion() %> " pattern="[\w+ ]+ #\d+$"
														maxlength="30" required>
			</li>
			<li>Comuna:
				<!-- debería ser una [combobox] -->
				<input type="text" name="comuna" placeholder="Santiago"
										maxlength="45" pattern="[\w+ ]+" required>
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
